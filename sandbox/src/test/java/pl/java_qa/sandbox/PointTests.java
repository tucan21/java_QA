package pl.java_qa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distanceTest() {
    Point p1 = new Point(8.0, 2.0);
    Point p2 = new Point(3.0, 5.0);
    Assert.assertEquals(p1.distance(p2), 5.830951894845301);
  }
}
