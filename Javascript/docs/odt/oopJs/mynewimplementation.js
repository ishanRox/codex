//our old ways of doing this class like function through constructor functions

function Pearson(saying) {
    this.saying = saying;
}

Pearson.prototype.talk = function () {
    console.log("I say ", this.saying);
}

const ishan = new Pearson("hello im ishan reply me !")
ishan.talk();

//what exactly new keyword do in javascript
//1.creates a new empty plain object
//2.check prototype
//3.call constrocture bind with newly created object
//4.return object
//this how js fakes the mechanism of classes

//custom built my new 

function Vehical(hornSound) {
    this.hornSound = hornSound;
}
Vehical.prototype.honk = function () {
    console.log("Horn sound is ", this.hornSound);
};


function newObject(constructorFunction) {
    //1st step make a new object
    const obj = {};

    //2nd step set the prototype to new object
    //get the empty object and set the prototype of given class to new object
    Object.setPrototypeOf(obj, constructorFunction.prototype);

    //3rd step call the constructor function with newly maked object and arguments so it sets args to new object
    //get second argument(for cleanlyness) and call the constructorFunction but remember this is a function
    //if we call it normally its 'this' will be global object
    // but in here we bind it with our empty object
    //more info https://www.dotnetodyssey.com/2019/06/25/difference-between-calling-a-function-with-new-keyword-and-without-new-keyword-in-javascript/
    // after calling our object initialized with constructors lojic
    const argsArray = Array.from(arguments);
    constructorFunction.apply(obj, argsArray.slice(1));

    //4th step - return the object 
    return obj;
}
console.log("_______________________");
//regular new keyword way
const alto = new Vehical("beep");
alto.honk();


//custom build new object creator by ishan
const benz = newObject(Vehical, "benzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
benz.honk();

