
/**
 * Singeleton
 */
public class Singeleton {

    public static void main(String[] args) {

        SingeletonAdvance singleObject = SingeletonAdvance.getInstance();
        singleObject.showMessage();

        SingeletonAdvance singleObject1 = SingeletonAdvance.getInstance();
        singleObject.showMessage();

    }
}

class SingeletonAdvance {
    // create volatile var read from main memory not from cpu cash
    // refer http://tutorials.jenkov.com/java-concurrency/volatile.html
    // this is lazy initialization
    private static volatile SingeletonAdvance instance;

    // make constructor private so other class cant make objects
    private SingeletonAdvance() {
        // avoid using reflection we check if instance is alread maded if it have made
        // dont make instance
        if (instance != null) {
            throw new RuntimeException("Please use the get instance Avoid reflection !");
        }
    }

    public static SingeletonAdvance getInstance() {

        // double checking singeleton

        // take 2 threads when first one thread enter and see instance is null
        // And the get into synchronized block block is used because we can get
        // performance hit
        // if we synchronized the method.
        // then lock is taken by first thread and go inside and meet if() and see
        // instance is still
        // null
        // and make the object.
        // while 1 st thread making the object 2nd thread come and chek instance is null
        // so yes
        // then 2nd thread try to enter synchronized block but it cant enter because
        // clas lock has been tacken
        // meantime 1st object make the instance and assign it to instance
        // then 2nd thread comes inside and meet if() and see 1st thread has make the
        // instance
        // so it wont enter if and make new object it leaves

        if (instance == null) {

            // only one lock per class so lock is needed for thread to enter
            synchronized (Singeleton.class) {
                if (instance == null) {
                    instance = new SingeletonAdvance();
                }
            }

        }

        return instance;
    }

    // to show same instance is used
    public void showMessage() {
        System.out.println("Instance is " + this.hashCode());
    }
}

class SingleObject {

    // create Single instance this is a lazy Initialization
    private static SingleObject instance = new SingleObject();

    // make the constructor private so this class cant be instantiated
    private SingleObject() {
    }

    // return the only object
    public static SingleObject getSingleObject() {
        return instance;
    }

    // to show same instance is used
    public void showMessage() {
        System.out.println("Instance is " + this.hashCode());
    }
}