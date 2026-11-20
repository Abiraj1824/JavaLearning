
public class Ex02_TypeConversion {

    public static void main(String[] args) {

        int number = 99;
        double decimal = number;

        System.out.println("Widening: " + decimal);

        double price = 99.99;
        int newPrice = (int) price;

        System.out.println("Narrowing: " + newPrice);
    }
}
