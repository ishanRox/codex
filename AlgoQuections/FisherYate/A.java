import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A
 */
public class A {

    public static void main(String[] args) {

        int array[] = IntStream.range(1, 11).toArray();

        // convert to Integer list and showed
        System.out.println("Before " + Arrays.stream(array).boxed().collect(Collectors.toList()));
        FisherYate(array);
        System.out.println("After " + Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    private static void randomize(int array[]) {

        for (int i = 1; i < array.length - 1; i++) {
            int indexToSwap = (int) (Math.random() * i + 1);
            System.out.println(indexToSwap + "   index range - 0 to " + (i + 1));
            int temp = array[i];
            array[i] = array[indexToSwap];
            array[indexToSwap] = temp;
        }

    }

    private static void FisherYate(int array[]) {

        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int indexToSwap = random.nextInt(i + 1);
            System.out.println(indexToSwap + "   index range - 0 to ");
            int temp = array[i];
            array[i] = array[indexToSwap];
            array[indexToSwap] = temp;
        }

    }

    private static void permutations(String prefix, String word) {
        if (word.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            permutations(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
        }
    }
}