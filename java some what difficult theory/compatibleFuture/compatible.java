import java.util.concurrent.CompletableFuture;

/**
 * compatible
 */
public class compatible {

    public static void main(String[] args) {
        // compatibleFuture is the promises of java
        System.out.println("compatible future main -" + Thread.currentThread());

        // call back hell ask from javascript developer
        // so they found prmises which is promising
        // promise is in 3 states reject,pending ,resolve
        // has two channels
        // error channel and data channel
        // data--function-data-function

        // javascripts promises and java completable future are almost same

        // stage is segment of pipe line

        // seperate the creation of create() which call compute
        // and return completableFuture
        CompletableFuture<Integer> cFuture = create();
        // give time to create method that means the thread in fork join
        // can complete the work in real life that means this thread doing some work we
        // simulate that so forkjoin thread has time to complete it work and .
        // the print it run in main thread .
        // because its aim is to give non blocking feature .
        // in summary for create it uses seperate thread and
        // because this main sleep give s time to complete its work.
        // the cFuture has resolved data not pending .
        // so no need to keep forkjoin thread so it runs in main thread .
        // if compatible future thread still doing work when we request it run
        // seperately but if already completed it
        // work when request not pending .then runs in calling thread

        cFuture.thenAccept(data -> {
            printIt(data);
        }).thenRun(()->System.out.println("all done"))
        .thenRun(()->System.out.println("not really"))
        .thenRun(()->System.out.println("this keep going"));

//Stream                  and     CompletableFuture
//0,1 or more                     one data or error
//forEach-Consumer                 thenAccept
//         accept()                     
//map- Function
//     apply()

        System.out.println("in main");
        // meka danne main wa halt karanna
         sleep(9000);

        System.out.println("main ended");
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // meka use karann completable future eka genath dena data
    // koheda run wenne balanna
    public static void printIt(Integer value) {
        System.out.println("printit  method -" + Thread.currentThread());
        System.out.println(value);

    }

    public static Integer compute() {

        // when we comment sleep all the work have done when main
        // requesting data.
        // **********************simply when we requesting data if completable future
        // thresds work still not completed
        // it runs on forkjoin thread if its completed its handed overto calling
        // thread**********************
        sleep(5000);
        System.out.println("compute method -" + Thread.currentThread());

        return 20;
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(compatible::compute);
    }
}