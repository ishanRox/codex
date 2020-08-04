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

let name = "ishan";
//and we can set a name dynamically to a value which we dont know surely
let manyNames = ["friend", "girlfriend", "crush"];
const ishan = {
    name,
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
    banner = () => console.log(this.name + 'is and emplyee an manager of ' + this.section);
}

const e1 = new Employee("brian");
const e2 = new Manager("chriss", "Qa");

e1.banner(); 