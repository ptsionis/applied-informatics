"use strict";

function Student(fname, lname, grade = 0) {
    this.fname = fname;
    this.lname = lname;
    this.grade = grade;

    Student.prototype.toString = function () {
        return `${this.fname} ${this.lname} (grade: ${this.grade})`;
    }
}

let students = [];

console.log(students);

for (let i = 0; i < 10; i++) {
    students[i] = new Student("Stud", i.toString())
}

function gradeStudent(student) {
    student.grade = Math.floor(Math.random() * 11);
}

for (let i = 0; i < students.length; i++) {
    gradeStudent(students[i]);
}

function average(allStudents) {
    let avg = 0;
    for (let st = 0; st < allStudents.length; st++) {
        avg += allStudents[st].grade;
        console.log(allStudents[st].toString());
    }
    avg /= allStudents.length;
    console.log(`The average is ${avg}`);
}

average(students);