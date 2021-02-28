package my.pkg.sandbox;

public class LineLen {
  public static void main(String[] args) {

    Point p1 = new Point(4,0);
    Point p2 = new Point(4,3);
    double s = p1.distance(p2);

    System.out.println("Расстояние между p1(" + p1.x + "," + p1.y + ") и p2(" + p2.x + "," + p2.y + ") = " + s);

    p1.x = 5.5;
    p1.y = 0;
    p2.x = 0;
    p2.y = 0;
    s = p1.distance(p2);

    System.out.println("Расстояние между p1(" + p1.x + "," + p1.y + ") и p2(" + p2.x + "," + p2.y + ") = " + s);


  }

}
