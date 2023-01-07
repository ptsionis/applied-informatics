"use strict";

let arr = [0, 1, 2, 3, 4, 5, 12, 7, 8 , 9];
let flag = false;

for (let i of arr) {
    if (i===12) {
        flag = true;
        break;
    }
}

flag ? console.log(`Number 12 exists in the array`) : console.log(`12 does not exist in the array`);
