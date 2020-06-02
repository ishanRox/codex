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
        // ________________________________________________________________________________________________________________________________________

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
        // ________________________________________________________________________________________________________________________________________

        // run some task and return a result
        // Run a task specified by a Supplier object asynchronously
        // Using Lambda Expression
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10000; i++)
                ;

            return "Result of the asynchronous computation";
        });

        // Block and get the result of the Future
        // becauese all completableFutures are daemon threads we must halt main if not
        // it will end
        try {
            // Block and get the result of the Future
            String result = future1.get();
            System.out.println(result);

        } catch (Exception e) {
            // TODO: handle exception
        }

        // you dont need any of try catch and blocking these when getting result in this
        // way if fork join has
        // completed its work
        // this may run in that (pending ) but if its resolved
        // this use calling thread
        future1.thenAccept(e -> System.out.println("result recived " + e + "   " + Thread.currentThread()));
        // ________________________________________________________________________________________________________________________________________
        // thenApply and thenApplyAsync wala wenasa thama
        /*
         * thenApply Executed in the same thread where the supplyAsync() task is
         * executed or in the main thread If the supplyAsync() task completes
         * immediately (Remove sleep() call to verify)
         *
         * But thenApplyAsync Executed in a different thread from 
         * ForkJoinPool.commonPool() Executed in
         * a different thread from ForkJoinPool.commonPool()
         */
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("mainend");
    }
}