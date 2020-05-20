//js things
// let i = 100;

// let method = window.setTimeout(() => {
//   document.getElementById("aa").innerHTML = "get changed";
//   window.alert("changed");
// }, 2000);

// console.log(`${method}`);

// let timer = window.setInterval(
//   () =>
//     (document.getElementById("aa").style.color = `rgb(${Math.floor(
//       Math.random() * 256
//     )}, ${Math.floor(Math.random() * 256)}, ${Math.floor(
//       Math.random() * 256
//     )})`),
//   2000
// );

// function stop() {
//   window.clearInterval(method);
//   window.clearInterval(timer);
//   console.log("method stoped");
// }

let restVar = (a, ...b) => {
  console.log(a, b);
};

function perm(prefix, word) {
  if (word == "") {
    console.log(prefix);
    return;
  }
  for (let i = 0; i < word.length; i++) {
    perm(prefix + word[i], word.substring(0, i) + word.substring(i + 1));
  }
}

//partially applied functions
//user only needed to invoke complex arguments are handled by code
function notInvoked(x, y, z) {
  console.log(`x ${x} y ${y} z ${z}`);
}
let onlyUserNeededInvocation = notInvoked.bind(null, 12, 13, 14);
onlyUserNeededInvocation();

//A closure is a function having access to the parent scope, even after the parent function has closed.
function count() {
  let counter = 10;
  console.log("outer count function called");
  return () => {
    counter++;
    console.log(counter);
  };
}
let increaseCount = count();
increaseCount();
increaseCount();
increaseCount();

//closures and curring
// technique of translating the evaluation of a function that takes multiple arguments into evaluating a sequence of functions

let number = (no) => {
  return (squaringAmount) => {
    return [...Array(squaringAmount - 1).keys()].reduce((total, val) => {
      return total * no;
    }, no);
  };
};

//another tasty curry
function sum(x, y, z) {
  return x + y + z;
}
//x ta para yawwama y dana function eka denawa yta yawwama z denawa zta yawwama x y z sum eka
let currySum = (x) => {
  return (y) => {
    return (z) => {
      return x + y + z;
    };
  };
};
//can simplified as this  (x) => (y) => (z) => x + y + z;

console.log(currySum(1)(2)(3), "A nice curry");
//now awsomeness
let addTo10and20 = currySum(10)(20);
console.log(addTo10and20(100), "100 added to memorized 10 20");
console.log(addTo10and20(1), "1 added to memorized 10 20");
console.log(addTo10and20(30), "30 added to memorized 10 20");

//main
((main) => {
  let square = number(2);
  console.log(square(2));
  console.log(square(3));
  console.log(square(4));
  // let array = [4, 3, 2, 1];
  // console.log(array);
  // insertionSort(array);
  // console.log(array);
  // perm("", "abc");
  // console.log("ishan".substring(0));
  // restVar(1, 2, 3, 4);
})();