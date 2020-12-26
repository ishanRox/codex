public class p {

    public static void main(String[] args) {
       
        byte x = (byte) 197;
        System.out.println(x);
        A a = new B();
        a.name();
        try {

        } finally {
        }
    }
}

class A {
    void name() {
        System.out.println("AAAA");
    }

    A() {
    }

    public Object name1() {
        return 1;
    }

}

/**
 * Innerp
 */
class B extends A {
    public B() {
        System.out.println("");

    }

    public Byte name1() {
        return 12;
    }

    protected B(int a) {

    }

    public void name() {

        System.out.println("BBBB");
        super.name();
        this.name(22);
    }

    public void name(int a) {
        System.out.println("BBBB");
    }

}