'use strict'
//old way

const foo = function () {
    console.log("foo called...");
}

//so this C is capital in car its knows as a class
const Cars = function () {
    if (!(new.target)) {
        throw new Error("stupid shit u call this as a function")
    } else {
        console.log("called as a class...");
    }
}

new Cars();
//Car(); stupid man
console.log("________________");
//new way
class Human {

}
//the advantage of it is auto handled errors like calling it as a function give error
console.log(new Human());
//bt still its a wrapper around a modified function
console.log(typeof (Human));
// console.log(Human());Class constructor Human cannot be invoked without 'new'

console.log("________________");

//what about methods and constructors

class Robot {
    constructor(age) {
        this.age = age;
        this.name = "crazy"
        this.km = 0;
    }
    drive(distance) {
        this.km += distance;
    }
    //we can use getters and setters but if we 
    //use getter for setting some value it will blows up if we use strict
    //And we cant use parameters in getter

    get Color() {
        return this.storedColor;
    }
    set Color(val) {
        this.storedColor = val;
    }

}

const robo1 = new Robot(12);
console.log(robo1);
robo1.drive(199);
console.log(robo1);
robo1.Color = ("green");
console.log(robo1.Color);

//static in js
class A {
    static info() {
        console.log("info called");
        return "data returned"
    }
    //you can have static getters and settersS
    constructor() {
    }
}
A.count = 12;
console.log(A.count);

//unlike in java if we call static from object it gives us
//a error we can only call from class scope

console.log(A.info());

try {
    new A().info();
} catch (error) {
    console.log("u cant do this here this is not java");
}
console.log("________________________");
//Weird inheritance in javascript
//in java we used class based inheritance but js and few languages like lua use 
//prototypical inheritance

//how we do inheritance before

const sam = { name: "sam" };

const use = function (person) {
    try {
        person.work();
    } catch (error) {
        console.log("not found");
    }
}

use(sam);
//fix
const employment = {
    work: function () {
        console.log("working.....");
    }
}

//Like extending a class we give employment behaviour to the sam
//https://www.youtube.com/watch?v=dxzBZpzzzo8&t=4743s  2:02:46 

Object.setPrototypeOf(sam, employment);
use(sam);

const management = {
    work: function () {
        console.log("dont do work just getting athal !");
    }
}

Object.setPrototypeOf(sam, management);
use(sam);
//class based inheritance is static inflexible(AOP is there but its another topic)
//prototypal inheritance is dynamic which is flexible

console.log("__________________________________________");
//how prototype behaves in code
const Car = function () {
    this.drive = function (dist) {
        this.km += dist;
    }
}
//prototype value added as km
Car.prototype.km = 0;

const car1 = new Car();
const car2 = new Car();

//these are different objects
console.log(car1 === car2);
console.log(Object.getPrototypeOf(car1) === Object.getPrototypeOf(car2));
console.log("_________________");
//so setted value of the 0 km applied to all new objects with that prototype
console.log(car1.km);
console.log(car1);
console.log(` no value for km so went to prototype and get it`);
console.log(car2.km);
console.log(car1);
console.log(`no value for km so went to prototype and get it`);
console.log("\n");

car1.drive(10);
console.log(car1.km);
console.log(car1);
console.log('so km added to this car1 so no need to go for its prototype');
console.log(car2.km);
//so conclution is gets are deep ,sets are shallow
//syntax here is horrible but behaviour is awsome
//in modern js symantic is same syntax is awsome but we must remember its same old one
console.log("___________________________________");

//inherit form a class
class Person {
    constructor(first, last) {
        this.first = first;
        this.last = last;
    }

    toString() {
        return ` ${this.first} ${this.last}`
    }
}
const ishan = new Person("ishan", "vimukthi");
console.log(ishan);

class CoolPerson extends Person {
    //if this was java or c# we must write a constructor 
    //but javascript says ill handle it
    //if you want do special thing u can also write a constructor

    constructor(first, last, index) {
        console.log("rule is dont use this before super");
        super(first, last);
        this.index = index;
    }

    toString() {
        return `${super.toString()} ${this.index}`
    }

}

const alan = new CoolPerson('alan', 'turing', 120);
console.log(alan);
console.log(Object.getPrototypeOf(alan));
console.log(Object.getPrototypeOf(Object.getPrototypeOf(alan)));
//https://www.hackerrank.com/challenges/js10-inheritance/topics