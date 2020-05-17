import java.util.Arrays;
import java.util.stream.Stream;

class A {
    public static void main(String[] args) {

        int array[] = { 4, 3, 2, 1 };
        selectionSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

   

    private static void insertionSort(int array[]) {
        
    for (int i = 1; i < array.length; i++) {
  
        int holeIndex=i;
        int holeValue=array[i];

        while (holeIndex>0 && holeValue< array[holeIndex-1] ) {
            array[holeIndex]=array[holeIndex-1];
            holeIndex--;
        }
        array[holeIndex]=holeValue;
    }

    }
    private static void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            
            int min=i;

            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[min]){
                    min=j;
                }
                swap(min,i, array);
            }
        }
    }

    private static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++)
                if (array[j] > array[j + 1])
                    swap(j, j + 1, array);

    }

    private static void swap(int index1, int index2, int array[]) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}