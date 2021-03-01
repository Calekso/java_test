package my.pkg.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPointFirst(){
    Point p1 = new Point(4,0);
    Point p2 = new Point(4,3);
    Assert.assertEquals(p1.distance(p2), 3.1); // негативный тест
  }
  @Test
  public void testPointSecond(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,66);
    Assert.assertEquals(p1.distance(p2), Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)  ));
  }
  @Test
  public void testPointThird(){
    Point p1 = new Point(-5,-7.0);
    Point p2 = new Point(0,-7);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

}
