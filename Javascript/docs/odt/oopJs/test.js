'use strict'
//old way

const foo = function () {
    console.log("foo called...");
}

//so this C is capital in car its knows as a class
const Car = function () {
    if (!(new.target)) {
        throw new Error("stupid shit u call this as a function")
    } else {
        console.log("called as a class...");
    }
}

new Car();
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

//past