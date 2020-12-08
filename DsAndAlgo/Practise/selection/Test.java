class Test {
    public static void main(String[] args) {
        int array[] = { 4, 3, 2, 1 };

        // selectionSort(array);
        // bubbleSort(array);
        // insertionSort(array);
        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    // If small element is found then assign it to min
                    min = j;

                }
            }
            swap(array, i, min);
        }
    }

    public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int holeValue = array[i];
            int holeIndex = i;

            while (holeIndex > 0 && holeValue < array[holeIndex - 1]) {
                array[holeIndex] = array[holeIndex - 1];
                holeIndex--;
            }
            array[holeIndex] = holeValue;
        }
    }

    public static void mergeSort(int main[]) {
        if (main.length < 2) {
            return;
        }
        int mid = main.length / 2;
        int left[] = new int[mid];
        int right[] = new int[main.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = main[i];
        }
        for (int i = mid; i < main.length; i++) {
            right[i - mid] = main[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(main, left, right);
    }

    public static void merge(int main[], int left[], int right[]) {
        int mainIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                main[mainIndex] = left[leftIndex];
                leftIndex++;
            } else {
                main[mainIndex] = right[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }

        while (leftIndex < left.length) {
            main[mainIndex] = left[leftIndex];
            leftIndex++;
            mainIndex++;
        }
        while (rightIndex < right.length) {
            main[mainIndex] = right[rightIndex];
            rightIndex++;
            mainIndex++;
        }

    }

}