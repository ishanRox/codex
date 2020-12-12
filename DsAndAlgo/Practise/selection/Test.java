/**
 * Test
 */
public class Test {

    public static void main(String[] args) {

        int array[] = { 1, 2, 3, 4 };
        // selectionSort(array);
        // bubbleSort(array);
        insertionSort(array);
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
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }

        }
    }

    public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int holeIndex = i;
            int holeValue = array[i];

            while (holeIndex > 0 && array[holeIndex - 1] > holeValue) {
                array[holeIndex] = array[holeIndex - 1];
                holeIndex--;
            }
            array[i] = holeValue;
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
}