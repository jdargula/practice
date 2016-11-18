public class C extends RuntimeException {
    public C(String arg) {
        super(arg);
        System.out.print("boom!");
    }
}