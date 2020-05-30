import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * parallel
 */
public class parallel {
    private static int transform(int no) {
        // System.out.println(Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return no;
    }

    public static void main(String[] args) {
        System.out.println("programming concurrent ly");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers);

        // We going to chek how sequantal and parrallel stream work
        // we call to pseudo slow stream

        numbers.stream().map(e -> transform(e)).forEach(System.out::println);
        System.out.println("______________this is sequantal____________________________");

        // And there are two ways to achive
        // parallel streams.
        // One is using parallelStreams and
        // other one is use parallel for a stream.
        // we use parallel when we receives a stream() and we want to convert that
        // stream to parallel stream.

        // when we can directly convert that mean we have the data

        numbers.parallelStream().map(e -> transform(e)).forEach(System.out::println);
        System.out.println("______________this is parallel _Stream___________________________");

        // when we have stream but not the source
        // numbers.stream().parallel().map(e ->
        // transform(e)).forEach(System.out::println);
        // System.out.println("______________this is stream converted to
        // parallel___________________________");

        // adding sequantal to parallel stream make no sense
        // streams get the last convertion in this it s sequantial
        // so in here this stream is not parallel
        numbers.parallelStream().map(parallel::transform).sequential().forEach(System.out::print);
        System.out.println("when we use sequential to parallel whole thing converted to sequential");
        System.out.println();

        // but we have solution for it
        numbers.parallelStream().map(parallel::transform).forEachOrdered(System.out::println);
        System.out.println("when we use forEachOrdered even parallel give answer sequntially");
        System.out.println();

        // reduce in parallel

        // people in room give (total=0,add your age ) add ur age to total
        System.out.println();
        System.out.println("sequantial reduce initial 0 " + // people in room give (total=0,add your age ) add ur age to
                                                            // total
                numbers.stream().map(parallel::transform).reduce((t, val) -> t + val));

        System.out.println();
        System.out.println("Parallel reduce 0 " + // people in room give (total=0,add your age ) add ur age to total
                numbers.parallelStream().map(parallel::transform).reduce((t, val) -> t + val));

        System.out.println();
        System.out.println("Parallel reduce wronge initial 20 -" +
        // people in room give (total=0,add your age) to eachrows for add ur age to
        // total and add rows total at end
        // we can think this rows as cores which runs parallel
        // so if we give 20 each of our 8 cpus calculation is going to be wronge
        // in these type of scenarios add 20 to end after all thingsare done
                numbers.parallelStream().map(parallel::transform).reduce(20, (t, val) -> t + val));

        System.out.println("___________________________________________________________");
        System.out.println(Runtime.getRuntime().availableProcessors() + " available processors to run things parallel");
        System.out.println();
        System.out.println(ForkJoinPool.commonPool());

        List<Integer> no1 = Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        System.out.println(" this pc hava " + Runtime.getRuntime().availableProcessors()
                + " so this is processed in that no of parallel cors");
 
no1.parallelStream().map(parallel::transform).forEach(System.out::println);
            }
}