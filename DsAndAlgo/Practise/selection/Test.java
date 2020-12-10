/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        int[] array = { 4, 3, 2, 1 };
        
    }

    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }
}