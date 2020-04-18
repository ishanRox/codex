let bubbleSort = (array) => {
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length - 1 - i; j++) {
      let flag = true;
      if (array[j] > array[j + 1]) {
        flag = false;
        swap(array, j, j + 1);
      }
      if (flag) {
        break;
      }
      console.log("repeat");
    }
  }
};

let selectionSort = (array) => {
  for (let i = 0; i < array.length; i++) {
    let min = i;
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < array[min]) {
        min = j;
      }
    }
    swap(array, i, min);
  }
};

let insertionSort = (array) => {
  for (let i = 1; i < array.length; i++) {
    let holeIndex = i;
    let holeValue = array[i];

    while (holeIndex != 0 && holeValue < array[holeIndex - 1]) {
      array[holeIndex] = array[holeIndex - 1];
      holeIndex--;
    }
    array[holeIndex] = holeValue;
  }
};

let merge = (array, left, right) => {
  let indexMain = 0,
    indexLeft = 0,
    indexRight = 0;

  while (indexLeft < left.length && indexRight < right.length) {
    if (left[indexLeft] <= right[indexRight]) {
      array[indexMain] = left[indexLeft];
      indexLeft++;
    } else {
      array[indexMain] = right[indexRight];
      indexRight++;
    }
    indexMain++;
  }

  while (indexLeft < left.length) {
    array[indexMain] = left[indexLeft];
    indexLeft++;
    indexMain++;
  }
  while (indexRight < right.length) {
    array[indexMain] = right[indexRight];
    indexRight++;
    indexMain++;
  }
};

let sort = (array) => {
  if (array.length < 2) return;

  let mid = Math.floor(array.length / 2);
  let left = new Array(mid);
  let right = new Array(array.length - mid);

  for (let i = 0; i < mid; i++) {
    left[i] = array[i];
  }
  for (let i = mid; i < array.length; i++) {
    right[i - mid] = array[i];
  }

  sort(left);
  sort(right);
  merge(array, left, right);
};

function swap(array, a, b) {
  let temp = array[a];
  array[a] = array[b];
  array[b] = temp;
}
let array = [4, 3, 2, 1];

console.log(array);
//bubbleSort(array);
//selectionSort(array);
//insertionSort(array);
sort(array);
console.log(array);
