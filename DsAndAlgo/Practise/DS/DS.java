import java.util.Arrays;
import java.util.stream.Collectors;

class DS {
    public static void main(String[] args) {
        int array[] = { 4, 3, 2, 1 };
        // selectionSort(array);
        // bubbleSort(array);
        // insertionSort(array);
        // mergeSort(array);
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int holeIndex = i;
            int holeValue = array[i];

            while (holeIndex > 0 && array[holeIndex - 1] > holeValue) {

                array[holeIndex] = array[holeIndex - 1];
                holeIndex--;
            }
            array[holeIndex] = holeValue;
        }
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
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, min, i);
        }
    }

    public static void mergeSort(int array[]) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int left[] = new int[mid];
        int right[] = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }

    public static void merge(int array[], int left[], int right[]) {
        int mainIndex = 0, leftIndex = 0, rightIndex = 0;

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

        while (leftIndex < left.length) {

            array[mainIndex] = left[leftIndex];
            leftIndex++;
            mainIndex++;
        }

        while (rightIndex < right.length) {

            array[mainIndex] = right[rightIndex];
            rightIndex++;
            mainIndex++;
        }

    }

    public static void quickSort(int array[], int start, int end) {
        if (start < end) {
            System.out.println(start+" start end "+end);
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);

        }
    }

    public static int partition(int array[], int start, int end) {
        int pivot = array[end];
        int partitionIndex = start;

        for (int i = start; i < end; i++) {
            System.out.println(i);
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        System.out.println(partitionIndex + " parrr");
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));

        swap(array, partitionIndex, end);
        return partitionIndex;
    }
}