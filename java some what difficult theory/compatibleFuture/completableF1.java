import java.util.concurrent.CompletableFuture;

/**
 * completableF1
 */
public class completableF1 {

    public static void main(String[] args) {

        // simplest completable future
        // https://www.callicoder.com/java-8-completablefuture-tutorial/
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture
                .thenAcceptAsync(data -> System.out.println("thread " + Thread.currentThread() + " data -> " + data));

        completableFuture.complete("Future's Result");

        System.out.println("main end");

        // remove sleep then main will end without doing async because remember the
        // rule.
        // JVM will not wait to Shutdown for daemon thread to
        // complete its execution. when there is no active non-daemon thread
        // our CompetebleFurure forkjoin threads are daemon thread
        try {

            Thread.sleep(6000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}