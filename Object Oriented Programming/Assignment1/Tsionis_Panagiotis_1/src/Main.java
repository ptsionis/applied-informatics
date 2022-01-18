import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	
	static public void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		welcomeMessage();
		
		//Αρχικοποίηση του πάιχτη και του dealer
		Player dealer = new Player("Dealer");
		Player player = new Player();
		System.out.println("Enter your name: ");
		player.setName(keyboard.nextLine());
		
		char play_again = 'Y';
		
		//Το παιχνίδι σταματάει όταν ο παίχτης δεν θέλει να πάιξει και άλλο γύρο, ή όταν παίχτης ή dealer χρεοκοπήσουν
		while (play_again=='Y' && player.getCash()>0 && dealer.getCash()>0) {
			
			//Αρχικοποίηση της λίστας-στοίβας με τις κάρτες
			ArrayList<Integer> card_stack = new ArrayList<>();
			cardStackInit(card_stack);
			
			/*Ο παίχτης θα ποντάρει ένα ποσό πριν κάθε γυρό, και θα γίνεται έλεγχος αν ο αριθμός
			είναι θετικός και μικρότερος-ίσος από τα συνολικά του χρήματα. Τέλος, παίχτης και dealer βάζουν το ποσό που κρατείται στην bet*/
			int bet;
			do {
				System.out.println("Your cash: $" + player.getCash());
				System.out.println("\nPlace Bet: ");
				bet = keyboard.nextInt();
				if (bet<=0) {
					System.out.println("Invalid bet, type a positive number!");
				}
				if (bet>player.getCash()) {
					System.out.println("Bet can't be higher than your cash.");
				}
 			} while (bet<=0 || bet>player.getCash());
			player.placeBet(bet);
			dealer.placeBet(bet);
			bet*=2;
			System.out.println();
			
			boolean end_of_round = false;
			
			//Μοίρασμα των δύο πρώτων φύλλων σε παίχτη και dealer
			shareCards(player, card_stack);
			shareCards(dealer, card_stack);
			
			//Ελέγχεται αν ο παίχτης έτυχε blackjack
			if (blackJack(player)) {
				System.out.println("BlackJack!");
				player.winBet(bet);
			}
			else {
				/*Αν δεν υπάρχει blackjack, ο παίχτης μπορεί να παίξει ή να καθίσει (αποθηκεύεται στην hs αφού γίνει έλεγχος).
				Μπορεί να παίζει (hit) όσο το χέρι του δεν έχει υπερβεί το 21*/
				char hs = 0;
				do {
					System.out.println();
					System.out.println("Hit = H | Stand = S\nEnter letter:");
					do {
						hs = keyboard.next().charAt(0);
						if (hs!='H' && hs!='S') {
							System.out.println("Invalid letter! Please type again:");
						}
					} while (hs!='H' && hs!='S');
					
					if (hs=='H') {
						//Δίνεται φύλλο στον παίχτη, εφόσον επέλεξε hit
						giveCard(player, card_stack);
					}
					/*Γίνεται έλεγχος για το αν ο παίχτης κάηκε με το φύλλο που πήρε. Αν ναι,
					παίρνει το ποντάρισμα ο dealer και ο γύρος τελειώνει*/
					if (isBusted(player)) {
						System.out.println("Busted!");
						dealer.winBet(bet);
						hs = 'S';
						end_of_round = true;
					}
				} while(hs!='S');
				
				//Εφόσον δεν υπήρχε BlackJack και ο παίχτης έκατσε χωρίς να καεί (άρα δεν τελείωσε ο γύρος), είναι η σειρά του dealer
				if (!end_of_round) {
					System.out.println("\nDealer's hand: " + dealer.getHand());
					/*Ελέγχος αν ο dealer έχει BlackJack. Αν ναι, παίρνει το ποντάρισμα, αλλιώς παίζει είτε μέχρι
					να περάσει το χέρι του παίχτη, είτε να καεί*/
					if (blackJack(dealer)) {
						System.out.println("BlackJack!");
						dealer.winBet(bet);
					}
					else {
						do {
							if (dealer.getHand()>=player.getHand() && dealer.getHand()<=21) {
								System.out.println("Dealer wins!");
								dealer.winBet(bet);
							}
							else if (dealer.getHand()>21) {
								System.out.println("Busted!");
								player.winBet(bet);
							}
							else {
								giveCard(dealer, card_stack);
								if (dealer.getHand()>21) {
									System.out.println("Busted!");
									player.winBet(bet);
								}
								if (dealer.getHand()>=player.getHand() && dealer.getHand()<=21) {
									System.out.println("Dealer wins!");
									dealer.winBet(bet);
								}
							}
						} while (dealer.getHand()<player.getHand() && dealer.getHand()<21);
					}
				}
			}
			
			//Αν ο παίχτης δεν έχει χρεοκοπήσει, μπορεί να επιλέξει αν θέλει να παίξει ξανά ή οχι
			if (player.getCash()>0) {
				play_again = playAgain();
			}
			else {
				play_again = 'N';
			}
		}
		
		endMessage(player);
		
	}
	
	//Αρχικό μήνυμα και γενικές πληροφορίες
	public static void welcomeMessage() {
		System.out.println("Welcome to Blackjack, designed by Panagiotis Tsionis.");
		System.out.println("The cards available are four for each number, from 2 to 11, "
				+ "which means that there are 40 cards in total.");
		System.out.println("\nYou start with $1000. "
				+ "Game ends when you wish to stop or when you go broke.\n");
	}
	
	//Δημιουργία της λίστας-στοίβας, όπως περιγράφεται στο welcome message
	public static void cardStackInit(ArrayList<Integer> card_stack) {
		int current_number = 2;
		for (int i=0; i<40; i++) {
			if(i!=0 && i%4==0) {
				current_number++;
			}
			card_stack.add(current_number);
		}
	}
	
	/*Μοιράζει τυχαία τις πρώτες δύο κάρτες στο εκάστοτε αντικείμενο που περνάμε στην πρώτη παράμετρο, έπειτα τις αφαιρεί από την τράπουλα.
	Στην περίπτωση που το αντικείμενο είναι ο παίχτης, τυπώνει και το χέρι του*/
	public static void shareCards(Player player, ArrayList<Integer> card_stack) {
		
		Random random = new Random();
		int card_slot = random.nextInt(card_stack.size());
		int card1 = card_stack.get(card_slot);
		card_stack.remove(card_slot);
		
		card_slot = random.nextInt(card_stack.size());
		int card2 = card_stack.get(card_slot);
		card_stack.remove(card_slot);
		
		player.initHand(card1, card2);
		if (player.getName()!="Dealer" ) {
			System.out.println("Your hand: " + player.getHand() + "\n");
		}
	}
	
	//Συνάρτηση που επιστρέφει αν το χέρι του αντικείμενου στην παράμετρο έτυχε Blackjack (οι πρώτες δύο κάρτες έχουν άθροισμα 21)
	public static boolean blackJack(Player player) {
		if (21==player.getHand()) {
			return true;
		}
		return false;
	}
	
	//Συνάρτηση που ελέγχει αν το χέρι του εκάστοτε αντικειμένου της παραμέτρου κάηκε (έχει φύλλα με άθροισμα πάνω από 21)
	public static boolean isBusted(Player player) {
		if (21<player.getHand()) {
			return true;
		}
		return false;
	}
	
	/*Διαλέγεται τυχαία μια κάρτα απ' τις διαθέσιμες της τράπουλας, την προσθέτει στο χέρι του αντικειμένου της πρώτης παραμέτρου και αφαιρεί
	το φύλλο από την τράπουλα. Τέλος, δείχνει και το χέρι του αντικειμένου*/
	public static void giveCard(Player player, ArrayList<Integer> card_stack) {
		Random random = new Random();
		int card_slot = random.nextInt(card_stack.size());
		player.addHand(card_stack.get(card_slot));
		card_stack.remove(card_slot);
		System.out.println(player.getName() + "'s hand: " + player.getHand());
	}
	
	//Χρησιμοποιείται για να ελέγξει αν ο παίχτης θέλει να παίξει ξανά
	public static char playAgain() {
		Scanner keyboard = new Scanner(System.in);
		char play_again;
		
		System.out.println("\nDo you wish to play again? (Yes = Y | No = N)");
		do {
			play_again = keyboard.next().charAt(0);
			if (play_again!='Y' && play_again!='N') {
				System.out.println("Invalid letter! Please type again!");
			}
		} while (play_again!='Y' && play_again!='N');
		
		return play_again;
	}
	
	//Μήνυμα τέλους που εκτυπώνει με πόσα χρήματα ξεκίνησε το αντικείμενο (ο παίχτης) και με πόσα τελείωσε
	public static void endMessage(Player player) {
		System.out.println("\nGame is over!");
		System.out.println("You started with: $1000");
		System.out.println("You ended with: $" + player.getCash());
	}
 
}
