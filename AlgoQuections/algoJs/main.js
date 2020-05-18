// // let i = 100;

// // let method = window.setTimeout(() => {
// //   document.getElementById("aa").innerHTML = "get changed";
// //   window.alert("changed");
// // }, 2000);

// // console.log(`${method}`);

// // let timer = window.setInterval(
// //   () =>
// //     (document.getElementById("aa").style.color = `rgb(${Math.floor(
// //       Math.random() * 256
// //     )}, ${Math.floor(Math.random() * 256)}, ${Math.floor(
// //       Math.random() * 256
// //     )})`),
// //   2000
// // );

// // function stop() {
// //   window.clearInterval(method);
// //   window.clearInterval(timer);
// //   console.log("method stoped");
// // }

// //0(n2)
let selectionSort = (array) => {
  const length = array.length;

  for (let i = 0; i < array.length - 1; i++) {
    let min = i;
    //i ara anith okkomath ekka compare karanawa i wa
    //i min neme nam i ta wada adu ekak hambuna nam swap
    for (let val = i + 1; val < array.length; val++) {
      if (array[val] < array[min]) {
        min = val;
      }
    }
    swap(array, i, min);
  }
};

let bubbleSort = (array) => {
  const length = array.length;
  for (let i = 0; i < array.length; i++) {
    let flag = true;
    for (let j = 0; j < array.length - 1; j++) {
      if (array[j] > array[j + 1]) {
        swap(array, j, j + 1);
        flag = false;
      }
    }
    if (flag) {
      break;
    }
    console.log(i);
  }
};

let insertionSort = (array) => {
  for (let i = 0; i < array.length; i++) {
    let holeIndex = i;
    let holeValue = array[i];
    while (holeIndex > 0 && array[holeIndex - 1] > holeValue) {
      array[holeIndex] = array[holeValue - 1];
      holeIndex--;
    }
    array[holeIndex] = holeValue;
  }
};

function swap(array, i, min) {
  let temp = array[i];
  array[i] = array[min];
  array[min] = temp;
}

let merge = (array, left, right) => {
  let mainIndex = 0,
    leftIndex = 0,
    rightIndex = 0;

  while (leftIndex < left.length && rightIndex < right.length) {
    if (left[leftIndex] <= right[rightIndex]) {
      array[mainIndex] = left[leftIndex];
      leftIndex++;
    } else {
      array[mainIndex] = right[rightIndex];
      rightIndex++;
    }
    mainIndex++;
  }

  while (rightIndex < right.length) {
    array[mainIndex] = right[rightIndex];
    rightIndex++;
    mainIndex++;
  }
  while (leftIndex < left.length) {
    array[mainIndex] = left[leftIndex];
    leftIndex++;
    mainIndex++;
  }
};
let sort = (array) => {
  if (array.length < 2) return;
  console.log(array);
  //float val reduction
  let mid = Math.floor(array.length / 2);
  let leftArray = new Array(mid);
  let rightArray = new Array(array.length - mid);
  for (let i = 0; i < mid; i++) {
    leftArray[i] = array[i];
  }
  for (let i = mid; i < array.length; i++) {
    rightArray[i - mid] = array[i];
  }

  sort(leftArray);
  sort(rightArray);
  merge(array, leftArray, rightArray);
};
let numberArray = [4, 5, 6, 7, 1, -2];
//insertionSort(numberArray);
//bubbleSort(numberArray);
//selectionSort(numberArray);
sort(numberArray);
console.log(numberArray);
