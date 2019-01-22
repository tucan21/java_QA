package pl.java_qa.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");
        hello("Jacek");

        double l = 8;
        System.out.println("Powierzchnia kwadratu o boku " + l + " wynosi " + area(l)+".");

        double a = 6;
        double b = 8;
        System.out.println("Powierzchnia prostokonta o bokach " + a + " i " + b + " wynosi " + area(a, b)+".");
            }

    public static void hello(String sombody) {

        System.out.println("Hello " + sombody + "!");

    }

    public static double area(double len) {
        return len * len;

    }

    public static double area(double a, double b) {
        return a * b;

    }

}
