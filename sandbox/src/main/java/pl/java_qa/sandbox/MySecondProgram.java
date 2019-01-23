package pl.java_qa.sandbox;

public class MySecondProgram {

  public static void main(String[] args)
  {
    Point p1 = new Point(8.0, 2.0);

    Point p2 = new Point(3.0, 5.0);

    double distance = p1.distance(p2);

    System.out.println("Distance between point (" + p1.x + ", " + p1.y + ") and ("
            + p2.x + ", " + p2.y + ") is " + distance + ".");


  }
}
