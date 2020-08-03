const promise1 = Promise.resolve('hello world');
const promise2 = 10;
const promise3 = new Promise((resolve, reject) => {
    //this is same as resolve('Goodbye') setTimeout can take a method and pass para to it 
    setTimeout(resolve, 5000, 'Goodbye');
});
//const promise4 = fetch('https://jsonplaceholder.typicode.com/users'); not work in node cause node havent fetch()



//so to complete this it takes the longest time taken by promise amonge given in here 5 s 
Promise.all([promise1, promise2, promise3]).then(val => console.log(val)).catch(console.log);

//with error (see the majic error viewed first and correct one give result this is becuase .
//all immediately go to catch if one fails)
Promise.all([promise1, promise2, promise3, Promise.reject('error happen')]).then(val => console.log(val)).catch(console.log);

//if we want to get result although one or more fails
Promise.allSettled([promise1, promise2, promise3, Promise.reject('error happen')]).then(val => console.log(val)).catch(console.log);
