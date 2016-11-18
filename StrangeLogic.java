public class StrangeLogic {
    private static int counter = 10;
private static void consider(int num) throws A {
if (num < counter) {
throw new A("bar");
} else {
throw new B("foo");
}
}
private static void count(int num) throws A {
if (10 / counter == num) {
throw new C("B");
} else {
consider(num);
}
}
public static void main(String args[]) {
try {
count(15);
} catch (A error) {
System.out.println(error.getMessage());
}
}
}
