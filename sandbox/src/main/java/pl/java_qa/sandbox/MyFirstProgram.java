package pl.java_qa.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        hello("user");
        hello("Jacek");

        Square s = new Square(8);
        System.out.println("Powierzchnia kwadratu o boku " + s.l + " wynosi " + s.area()+".");

        Rectangle r = new Rectangle(6,8);
        System.out.println("Powierzchnia prostokąta o bokach " + r.a + " i " + r.b + " wynosi " + s.area()+".");
            }

    public static void hello(String sombody) {

        System.out.println("Hello " + sombody + "!");

    }

    }