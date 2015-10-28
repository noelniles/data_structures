package csci2913.data.structures.noel.niles;

/**
 * Test some recursion ideas
 */
public class RecursionTests {

    public static void f(int n) {
        System.out.println(n);
        if (n > 1)
            f(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        f(3);
    }
}
