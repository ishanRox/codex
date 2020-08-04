//call start
const calculateAge = function () {
    console.log(this.age);
    console.log(this.name);
};


const ishan = {
    name: "ishan",
    age: "24"
};

calculateAge.call(ishan);


//apply method started
let manyArgs = function (name, age, sex) {
    console.log(this);
    console.log(`full name of client person is ${this.fullName}`);
    console.log(`name ${name} age ${age} sex ${sex}`);

};

const obj = { fullName: "ishan vimukthi kandage don", codeNo: 6656 };

console.log(obj);
manyArgs.apply(obj, ["drone", 24, "male"]);


//is call and apply work for arrow funcitons ? 

const m1 = () => console.log(`hello  ${this.name}`);

m1.call({ name: "ishan" });
//sadly no because of arrow functions get their this form lexical scope

