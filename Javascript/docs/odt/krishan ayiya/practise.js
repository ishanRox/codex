
//3nd schenario receving  promise rejected(firstly finished promise or winner of race)
const promiseArray1 = [
    new Promise((resolve, reject) => setTimeout(reject, 1000, "one"))
    ,
    new Promise((resolve, reject) => setTimeout(resolve, 2000, "two"))
    ,
    new Promise((resolve, reject) => setTimeout(resolve, 3000, "three"))
    ,
    new Promise((resolve, reject) => setTimeout(resolve, 4000, "four"))
];

//this takes 4 seconds because it wait till longest one completes
Promise.all(promiseArray1).then(console.log).catch(error => console.log(`error happens in ${error}`));

//race is a race between promises it takes firstly completed one in here that is rejected promise
Promise.race(promiseArray1).then(console.log).catch(
    error => console.log(`error happens in ${error}`)
);
//in here firstly completed one is rejected so but it complete race first 
//so no  matter others completed or not 1 st complete one gives by race and error is catched
