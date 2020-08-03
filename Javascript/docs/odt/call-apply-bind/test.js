
const calculateAge = function () {
    console.log(this.age);
    console.log(this.name);
};


const ishan = {
    name: "ishan",
    age: "24"
};

calculateAge.call(ishan);