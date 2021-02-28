package my.pkg.sandbox;


public class MyFirst1 {

  public static void main(String[] args) {

    hello("World");
    hello("user");

    Sqare s = new Sqare(7);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    Rect r = new Rect(2,4);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
  }

  public static void hello(String name) {

    System.out.println("Hello, " + name + "!");
  }

  public static double area(Sqare s) {

    return s.l * s.l;
  }

  public static double area(Rect r) {

    return r.a * r.b;
  }
}