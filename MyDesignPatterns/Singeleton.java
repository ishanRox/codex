/**
 * Singeleton
 */
public class Singeleton {

    public static void main(String[] args) {

        SingleObject singleObject = SingleObject.getSingleObject();
        singleObject.showMessage();

        SingleObject singleObject1 = SingleObject.getSingleObject();
        singleObject.showMessage();
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