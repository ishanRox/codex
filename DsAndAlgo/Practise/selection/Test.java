import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        int array[] = { 4, 3, 2, 1 };
        // selectionSort(array);
        // bubbleSort(array);
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
        for (int i = 0; i < array.length; i++) {
            int holeIndex = i;
            int holeValue = array[i];
            while (holeIndex > 0 && array[holeIndex - 1] > holeValue) {
                array[holeIndex] = array[holeIndex - 1];

            }

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

    public static void quickSort(int array[], int start, int end) {

        if (start < end) {
            int partitionIndex = partition(array, start, end);
            System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
            System.out.println(start + "start end" + end + " partition index " + partitionIndex);
            System.out.println("_________________________________");
            quickSort(array, partitionIndex + 1, end);
            quickSort(array, start, partitionIndex - 1);
        }
    }

    public static int partition(int array[], int start, int end) {
        int partitionIndex = start;
        int pivot = array[end];

        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, partitionIndex);
                System.out.println(partitionIndex + " partirion index");
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, end);
        return partitionIndex;
    }
}