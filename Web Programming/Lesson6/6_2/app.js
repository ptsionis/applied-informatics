"use strict";

let arr = new Array(4);
let counter = 1;

for (let i=0; i<arr.length; i++) {
    arr[i] = new Array(3);
    for (let j=0; j<arr[i].length; j++) {
        arr[i][j] = counter;
        counter++;
    }
}

for (let i of arr) {
    console.log(`[${i[0]}], [${i[1]}], [${i[2]}]`);  
}

console.log(`-------------`);

let row = [0, 0, 0, 0];
let col = [0, 0, 0];

for (let i=0; i<arr.length; i++) {
    for (let j=0; j<arr[i].length; j++) {
        row[i] += arr[i][j];
        col[j] += arr[i][j];
    }
}

let x = 0;
for (let i of row) 
    console.log(`Sum of row ${x++}: ${i}`);
    
console.log(`-------------`);

x = 0;
for (let i of col) 
    console.log(`Sum of col ${x++}: ${i}`);
