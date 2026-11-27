public class Ex06_Methods {

    static void greet() {
        System.out.println("Welcome to Java!");
    }

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        greet();

        int result = add(10, 20);

        System.out.println("Addition: " + result);
    }
}