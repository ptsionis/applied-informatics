// SPDX-License-Identifier: MIT
pragma solidity 0.8.17;

contract Lottery {
    enum Stage {Init, Reg, Bid, Done}

    struct Person {
        uint personId;
        address addr;
        uint remainingTokens;
    }

    struct Item {
        uint itemId;
        uint[] itemTokens;
    }

    event Winner(address winnerAddr, uint itemId);

    uint lotteryCount = 1;
    mapping(address => Person) bidders;
    uint biddersCount = 0;
    mapping (uint => address) personAddress;
    Item[] public items;
    address[] public winners;
    address public beneficiary;
    Stage public stage;

    modifier onlyOwner {
        require(msg.sender == beneficiary, "Only owner can call this function.");
        _;
    }

    modifier notOwnerReg() {
        require(msg.sender != beneficiary, "Owner not allowed to register.");
        _;
    }

    modifier atStage(Stage _stage) {
        require(stage == _stage, "Function not allowed at this stage.");
        _;
    }

    constructor() payable {
        beneficiary = msg.sender;
        stage = Stage.Init;
    }

    function register() public payable notOwnerReg atStage(Stage.Reg) {
        require(msg.value >= 0.005 ether, "Minimum deposit is 0.005 ether.");
        require(bidders[msg.sender].personId == 0, "Person already registered.");
        bidders[msg.sender] = Person({
            personId: biddersCount + 1,
            addr: msg.sender,
            remainingTokens: 5
        });
        personAddress[biddersCount + 1] = msg.sender;
        biddersCount++;
    }

    function registerItem() public payable onlyOwner atStage(Stage.Reg) {
        items.push(Item({
            itemId: items.length,
            itemTokens: new uint[](0)
        }));
        winners.push(address(0));
    }

    function bid(uint _itemId, uint _tokensCount) public payable atStage(Stage.Bid) {
        require(bidders[msg.sender].personId != 0, "User not registered.");
        require(_itemId <= items.length, "Invalid item ID.");
        require(_tokensCount <= bidders[msg.sender].remainingTokens, "Not enough tokens.");
        bidders[msg.sender].remainingTokens -= _tokensCount;
        for (uint i = 0; i < _tokensCount; i++) {
            items[_itemId].itemTokens.push(bidders[msg.sender].personId);
        }
    }

    function revealWinners() public payable onlyOwner atStage(Stage.Done) {
        for (uint itemId = 0; itemId < items.length; itemId++) {
            if (items[itemId].itemTokens.length > 0) {
                if (winners[itemId] == address(0)) {
                    uint rand = uint(keccak256(abi.encodePacked(block.timestamp, block.difficulty, msg.sender))) % items[itemId].itemTokens.length;
                    uint winnerId = items[itemId].itemTokens[rand];
                    winners[itemId] = personAddress[winnerId];
                    emit Winner(winners[itemId], itemId);
                }
            }
            else {
                winners[itemId] = address(0);
            }
        }
    }

    function advanceStage() public onlyOwner {
        require(stage != Stage.Done, "Cannot advance from Done stage.");
        stage = Stage(uint(stage) + 1);
    }

    function withdraw() public onlyOwner {
        payable(beneficiary).transfer(address(this).balance);
    }

    function reset() public onlyOwner {
        for (uint i = 0; i < items.length; i++) {
            delete items[i].itemTokens;
        }
        
        delete winners;
        biddersCount = 0;
        stage = Stage.Reg;
        lotteryCount++;
    }
}