function swap(array, a, b) {
  let temp = array[a];
  array[a] = array[b];
  array[b] = temp;
}

let bubbleSort = (array) => {
  for (let i = 0; i < array.length - 1; i++) {
    for (let j = 0; j < array.length - 1 - i; j++) {
      if (array[j] > array[j + 1]) {
        swap(array, j, j + 1);
      }
    }
  }
};

let selectionSort = (array) => {
  for (let i = 0; i < array.length; i++) {
    let min = i;
    for (let j = i + 1; j < array.length; j++) {
      if (array[min] > array[j]) {
        min = j;
      }
    }
  }
};

let insertionSort = (array) => {
  for (let i = 1; i < array.length; i++) {
    let holeIndex = i;
    let holeValue = array[i];

    while (holeIndex != 0 && array[holeIndex - 1] > holeValue) {
      array[holeIndex] = array[holeIndex - 1];
      holeIndex--;
    }
    array[holeIndex] = holeValue;
  }
};

let restVar = (a, ...b) => {
  console.log(a, b);
};

let array = [4, 3, 2, 1];
console.log(array);
insertionSort(array);
console.log(array);
perm("", "abc");

console.log("ishan".substring(0));

restVar(1, 2, 3, 4);

function perm(prefix, word) {
  if (word == "") {
    console.log(prefix);
    return;
  }
  for (let i = 0; i < word.length; i++) {
    perm(prefix + word[i], word.substring(0, i) + word.substring(i + 1));
  }
}
