import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class A {

    private static void merge(int left[], int right[], int main[]) {
        int leftIndex = 0, rightIndex = 0, mainIndex = 0;

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

    private static void sort(int array[]) {
        
        if (array.length<2) {
            return;
        }

        int mid=array.length/2;
        int left[]=new int[mid];
        int right[]=new int[]
    }

    public static void main(String[] args) {
       
        int left[] = IntStream.range(0, 10).toArray();
        int right[] = IntStream.range(10, 20).toArray();
        int main[] = new int[20];

        merge(left, right, main);

        //yse merging of two arrays worked
        Arrays.stream(main).forEach(System.out::println);
    
    
    }
}
