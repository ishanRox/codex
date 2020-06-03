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
        System.out.println();
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

        System.out.println();
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

        System.out.println();
        // ________________________________________________________________________________________________________________________________________
        // thenApply and thenApplyAsync wala wenasa thama
        /*
         * thenApply Executed in the same thread where the supplyAsync() task is
         * executed or in the main thread If the supplyAsync() task completes
         * immediately (Remove sleep() call to verify)
         *
         * But thenApplyAsync Executed in a different thread from
         * ForkJoinPool.commonPool() Executed in a different thread from
         * ForkJoinPool.commonPool()
         */
        CompletableFuture.supplyAsync(() -> {
            return "Some Result";
        }).thenApplyAsync(result -> {
            // Executed in a different thread from ForkJoinPool.commonPool()
            System.out.println(Thread.currentThread() + " this is a different thread defineately in fork join");
            return "Processed Result";
        }).thenAcceptAsync(e -> System.out.println(e + " see it uses different forkjoins " + Thread.currentThread()));

        System.out.println();
        // ________________________________________________________________________________________________________________________________________
        // ________________________________________________________________________________________________________________________________________
        // combine completable futures and play with multiple of them
        CompletableFuture<String> usersDetail = getUsersDetail("#123");

        // api userDetail gen awa future eka modifi karanawa eke thiyena detai aran
        // thawa future ekakata eee data yawanawidihata
        // so ehema unahama nested future seen eka enawa data eka ganna nam future 2
        // resolve karanna one
        CompletableFuture<CompletableFuture<String>> completableFuture1 = usersDetail
                .thenApply(user -> getCreditRating(user));

        // when we accept the result we ger completableFuture which contain
        // completableFuture<String> this is more work.
        // so insted of this we use thenCompose which directly give output which given
        // by completableFuture<String>.
        completableFuture1
                .thenAccept(completableFuture2 -> completableFuture2.thenAccept(string -> System.out.println(string)));

        // because of this nesting completableFuture problem we use thenCompose
        // apita nested ewala final future eka auto resolve karala denawa thenCompose
        CompletableFuture<String> stringCompletableFuture = usersDetail.thenCompose(user -> getCreditRating(user));

        // ___________________________________________________________________________________________________________________
        // method 3 kata balamu completableFuture data ethakota nested futures 3k enawa
        CompletableFuture<CompletableFuture<CompletableFuture<String>>> threeNestedFutures = usersDetail
                .thenApply(user -> getCreditRating(user).thenApply(credit -> getAnotherDetail(credit)));

        // but then compose use kalama wade lesi nested wechcha ewalin final eka aran
        // denawa
        CompletableFuture<String> finalOf3Nested = usersDetail
                .thenCompose(user -> getCreditRating(user).thenCompose(credit -> getAnotherDetail(credit)));
        finalOf3Nested.thenAccept(finalString -> System.out.println(finalString));
        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("mainend");
    }

    // combining 2 completable Futures
    static CompletableFuture<String> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("method 1 finished");
            return ", data from get user detail - " + userId;
        });
    }

    static CompletableFuture<String> getCreditRating(String user) {
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("method 2 finished");
            return ", data from get credit detail  12,0000 " + user;
        });
    }

    static CompletableFuture<String> getAnotherDetail(String user) {
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("method 3 finished");
            return " data from another which use credit card data " + user;
        });
    }
}