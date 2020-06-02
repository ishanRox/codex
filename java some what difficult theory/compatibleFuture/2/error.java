import java.util.concurrent.CompletableFuture;

/**
 * error
 */
public class error {
    private static String handle(Throwable e) {
        System.out.println("handled " + e);

        // methanata awa kiyanne error path ekata
        // awith but methnin fix kalama
        // happy path ekata yanawa
        // methaninuth awul giyoth error path eke thawa exceptionally
        // naththam meka handle karanna exit wenawa.
        return "error fixed";
    }

    public static void main(String[] args) {

        // remember there are 2 paths in pipeline happy and unhappy path
        // -x-f-x-f----------------x-f-x--
        // \ /
        // ---------e-f-e-f-e-f-------------

        CompletableFuture future = new CompletableFuture<String>();

        // exceptionally thibbata future eken return wunoth error
        // nathuwa exceptionally eka udin paninawa bypass karanawa
        future.exceptionally(throwable -> handle((Throwable) throwable)).thenApply(e -> e + " added")
                .thenAccept(e -> System.out.println(e + "  " + Thread.currentThread()));

     // future.complete("ishan");
        future.completeExceptionally(new RuntimeException("somwthing went wronge"));
        System.out.println("main end");
        
    }
}