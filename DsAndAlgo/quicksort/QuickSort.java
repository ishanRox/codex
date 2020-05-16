import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("QuickSort Initiated");

        int array[] = { 4, 3, 2, 1, 123 };
        QuickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void swap(int index1, int index2, int array[]) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void QuickSort(int array[], int start, int end) {

        if (start < end) {
            int partitionIndex = partition(array, start, end);
            QuickSort(array, start, partitionIndex - 1);
            QuickSort(array, partitionIndex + 1, end);

        }
    }

    private static int partition(int array[], int start, int end) {

        int pivotValue = array[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (array[i] < pivotValue) {
                swap(i, pIndex, array);
                pIndex++;
            }
        }

        swap(pIndex, end, array);

        return pIndex;
    }
}