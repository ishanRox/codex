const seperator = "_".repeat(15);

//let and const has a scope

for (var index = 0; index < 10; index++) {
    let k = index + 1;

}

console.log(index);
//console.log(k); index is printed bt not k because it s scoped to for loop

console.log(seperator);

//const cant protect inside of object or arrays it only make reference constant

const birthday = '1996 1 26';
// you cant do this birthday = '1998 2 12';
let newBday = birthday;
//const protect only the reference not value inside it 
newBday = "1996 23 23";
console.log(` new bday ${newBday} `);

const array = [0, 1, 2, 3,];
array[0] = 199;
console.log(array);

console.log(seperator);

//you can assign outer value directly and you can add dynamic properties

let nameIsh = "ishan";
//and we can set a name dynamically to a value which we dont know surely
let manyNames = ["friend", "girlfriend", "crush"];
const ishan = {
    nameIsh,
    age: 23,
    [manyNames[Math.floor(manyNames.length * Math.random())]]: "**ni"
};

console.log(ishan.name);
console.log(ishan);

console.log(seperator);

//Object.freeze work only for first level.
//For deep levels like array in object or object in object it dosent work

let flower1 = {
    name: 'ishan',
    price: {
        winter: 1299,
        summer: 488
    }
};

Object.freeze(flower1);
//first level values freeze so cant change
flower1.name = "rose";
//inner levels cant change
flower1.price.winter = 10000;

console.log(flower1);


console.log(seperator);

//classses constructor keyword,no local keyword   
class Employee {
    constructor(name) {
        //no need java like initialization
        this.name = name;
    }
    banner = () => console.log(this.name + 'is an employee');
}

class Manager extends Employee {
    constructor(name, section) {
        super(name);
        this.section = section;
    }
    banner = () => console.log(this.name + ' is and emplyee an manager of ' + this.section);
}

const e1 = new Employee("brian");
const e2 = new Manager("chriss", "Qa");


//arrow  funcitons wala lexicaly kiwwata meka kohomada une 
//methana this eka global(module.exports) ekane ?
//na meke podi wadak wenawa api declare karana arrow function eka constructor eka assata dagannawa
// class Picture {
//   draw = () => {
//     console.log('drawing')
//   }
// }

// class Picture {
//   constructor() {
//     this.draw = () => {
//       console.log('drawing');
//     };
//   }
// }

//so constructor ekedi this kiyanne ape object ekama thama habai price eka thama slow meka
//https://stackoverflow.com/questions/50325925/using-es6-arrow-functions-inside-class
//https://stackoverflow.com/questions/48920135/es6-functions-arrow-functions-and-this-in-an-es6-class
//https://medium.com/@charpeni/arrow-functions-in-class-properties-might-not-be-as-great-as-we-think-3b3551c440b1

e1.banner();
e2.banner();
e2.banner = () => console.log(' this is overridden');
e2.banner();

console.log(seperator);

//destruct types https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment

//1 way

//const PI = Math.PI;
//const SQRT2 = Math.SQRT2;
//we need to give exact name in here
const { PI, SQRT2 } = Math;
console.log(`pi ${PI} square root ${SQRT2}`);

// 2nd way

const square = {
    base: 12.2,
    id: 'main'
};

//we can exract the desired one from object in functions
const area = ({ base }) => base * base;

console.log(area(square));

//3 rd way

const area2 = ({ base }, { round = 3 } = {}) => (base * base).toFixed(round);

console.log(area2(square));
console.log(area2(square, { round: 5 }));
//if youre confuse about this to fixed it takes {} and return 12
//console.log(12.33333.toFixed({}));

//4 rth way
console.log(seperator);
const fs = require('fs');
fs.writeFile('ishan.txt', 'hello js', error => {
    if (error)
        throw error;
    console.log('saved');
});
//easy way using destruct
const { writeFile } = require('fs');
writeFile('ishaneasy.txt', 'hellooo\n'.repeat(122), e => {
    if (e) throw e;
    console.log('saved easily');
});

//array destructure


const [jan, feb, mar, , may] = [10, 20, 30, 40, 50];
console.log(`jan ${jan}`);
console.log(`may ${may}`);

//rest operator
const [month, ...otherMonths] = [1, 2, 3, 4, 5];
console.log(month);
console.log(otherMonths);

//you can copy array into other array using spread operator
let newArray = [...otherMonths];
console.log(`new array ${newArray}`);
console.log(`you can merge arrays ${[...otherMonths, month]}`);

console.log(seperator);


const complexObject = {
    name: 'ishan',
    age: 34,
    sex: 'male',
    job: 'thama sutine',
    car: 'mazda'
};
//rest element must be the last element
const { name, ...simpleObject } = complexObject;
console.log(complexObject);
console.log(name);
console.log(simpleObject);
console.log(seperator);