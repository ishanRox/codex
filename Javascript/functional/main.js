//main
(() => {
  console.log("started");
})();

//container data store that provide function to performe operations on data
class Container {
  constructor(data) {
    this.data = data;
  }

  static of(data) {
    return new Container(data);
  }

  map(lambdaFunction) {
    //always return new Container in java also this ok
    let newData = lambdaFunction(this.data);
    return new Container(newData);
  }
}

const container = Container.of(20);
console.log(container);
//container val * val method
console.log(container.map((e) => e * e));
//container val minus 10
console.log(container.map((e) => e - 10));

//MayBe container
class MayBe {
  constructor(data) {
    this.data = data;
  }

  static of(data) {
    return new MayBe(data);
  }

  isEmpty() {
    return this.data == undefined || this.data == null;
  }
  map(func) {
    if (this.isEmpty()) {
      //can handle it in this
      return this;
    }

    return MayBe.of(func(this.data));
  }
}

console.log(MayBe.of(10).map((e) => e + 10));
console.log(MayBe.of().map((e) => e + 10));
//__________________________________________________________
//this in javascript
//method mean function in object
//inside method -> currrent running object
//inside function -> global object (window i browser ,global in node)

//*first a this inside method in object*
const video = {
  title: "a",
  play() {
    console.log(this);
  },
};
console.log("_______________1");
video.play();

//although we define this outside its also a function inside object-this resolved by who calling the function
video.stop = function () {

console.log("_______________2");
  console.log(this);
};
//little lambda problem here video.stop=()=> {console.log(this);};
video.stop();

//in constructor function to make new object

function Movie(title) {
  this.title = title;
  console.log(this);
}

//*constructor function initiate by new keyword*
let Maleena = new Movie("Maleena film");
//make empty new object and reference it when using new {}

//but directly invoked it still gives global
//Movie("direct without new is global and this title added to global");

const man = {
  favoriteFoods: ["burger", "kos", "biriyani"],
  age: 24,
  name: "ishan",
  details() {
    // ok with this this   this.favoriteFoods.forEach((e) => console.log(e));
    this.favoriteFoods.forEach(function (name) {
      console.log(this, "inside call back this refer to global");
    });

    this.favoriteFoods.forEach((element) => {
      console.log(this, "But for arrow function its the object executing ");
    });
  },
};

man.details();
//___________________________________________________________
//Then a normal function
function playVideo() {
  //globle if node window if browser
  console.log(this);
}

//playVideo();

// For fns inside Objects: 'this' refers to the object calling the function.
// For fns not called by objects - Eg call back functions -    'this' refers to the global object.
// For fns defined using arrow functions - 'this' simple refers to the object that is executing the arrow function - Irrespective of object's scope.
//  Meaning:  if the arrow function is called from a global scope? 'this' will refer to the global object.
//   If the arrow function is called with in a function which belongs to an object?
// 'this' will refer to the calling function's scope and in this case the object itself.

//This in arrow functions

//
[1, 2, 3, 4, 233].forEach((e) => console.log(this));

let o = {
  traditionalFun: function () {
    console.log(`traditional func this==o`, this == o);
  },
  arrowFun: () => {
    console.log(`Arrow func this==o`, this == o);
    console.log(`Arrow func this==window`, this == window);
  },
};

o.traditionalFun();

//arrow function was created in window scope
//but Run in Scope of o so it always binded
//to scope where its created
o.arrowFun();

//read about this more
//https://www.w3schools.com/js/js_this.asp (most clear)
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this

//With a regular function this represents the object that calls the function:

//With an arrow function this represents the owner of the function:
//https://stackoverflow.com/questions/36717376/arrow-function-in-object-literal
//https://stackoverflow.com/questions/48295265/lexical-scope-in-javascript

//******************************************************
//normal function wala this call karana kena (caller)
//arrow wala this wenne arrow eka hadapu thana this(owner)(parent gen inherit wenwa)

let a = {
  name: "ishan",
  foo: function () {
    //methana this a object eka
    [4, 3, 2, 1].forEach((element) => {
      console.log(this, this == a);
    });
  },
};

a.boo = function () {
  console.log(`${this} booo`);
};
a.noo = () => console.log(`${this} noo`);
//owner(haduwe kawru gawada) of noo is window so this==window
a.noo();

//caller is a regualar function
a.boo();

//caller is a but arrow inside another function so this==a
a.foo();

//methana this window object eka
[4, 3, 2, 1].forEach((element) => {
  console.log(this, this == a);
});
