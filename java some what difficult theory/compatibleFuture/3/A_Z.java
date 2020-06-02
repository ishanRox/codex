import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * A_Z
 */
public class A_Z {

    public static void main(String[] args) {

        // simplest example
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

        completableFuture.complete("result given");
        try {
            // this is blocking it wait until competablefuture completes
            String result = completableFuture.get();
            System.out.println(result);
        } catch (Exception e) {
            // TODO: handle exception
        }

        // runAsync() for processes that didnt return
        // main difference in these and custom made thread by us are.
        // these are daemon threads and it gives more features
        // https://stackoverflow.com/questions/51155123/completablefuture-runasync-vs-new-thread

        // Using Lambda Expression
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            for (int i = 0; i < 10000; i++)
                ;
            System.out.println("I'll run in a separate thread than the main thread and this thread is daemon ."
                    + Thread.currentThread());
        });

        // run some task and return a result
        // Run a task specified by a Supplier object asynchronously
        // Using Lambda Expression
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });

        // Block and get the result of the Future
        String result = future1.get();
        System.out.println(result);

        // becauese all completableFutures are daemon threads we must halt main if not
        // it will end
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("mainend");
    }
}