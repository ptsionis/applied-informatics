"use strict";

console.log(addNums(1, 8, 2, 4, 6, 10));

function addNums(...rest) {
    let sum = 0;
    console.log(rest);

    for (let i of rest) {
        sum += i;
    }

    return sum;
}
