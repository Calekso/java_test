package my.pkg.sandbox;


public class MyFirst1 {

  public static void main(String[] args) {

    hello("World");
    hello("user");

    Sqare s = new Sqare(7);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
// sout - сокращение для System.out.println()

    Rect r = new Rect(2,4);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String name) {

    System.out.println("Hello, " + name + "!");
  }
}