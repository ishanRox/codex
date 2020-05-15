import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("hello");

        //get distinct from chars()
        "ishannnnnnnnn".chars().distinct().forEach(e->System.out.println((char)e));
     //get List
        List varList=   "ishannnnnnnnn".chars().distinct().mapToObj(e->(char)e).collect(Collectors.toList());
     System.out.println(varList);
     
    }
}