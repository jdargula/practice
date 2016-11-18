public class A extends Exception {
    public A (String arg) {
        super(arg);
        System.out.print("ouch!");
    }
}