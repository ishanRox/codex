import java.util.Arrays;

class A {
    public static void main(String[] args) {

        int testArray[] = { 4, 3, 2, 1 };
        insertionSort(testArray);

        Arrays.stream(testArray).forEach(System.out::println);

    }

    private static void swap(int index1, int index2, int array[]) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void SelectionSort(int array[]) {

        for (int i = 0; i < array.length; i++) {
            int minimum = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimum]) {
                    minimum = j;
                }
            }
            swap(i, minimum, array);
        }
    }

    private static void BubbleSort(int array[]) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    private static void insertionSort(int array[]) {

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
}