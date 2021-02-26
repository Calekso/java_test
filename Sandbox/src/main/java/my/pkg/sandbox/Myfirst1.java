package my.pkg.sandbox;

public class MyFirst1 {

  public static void main(String[] args) {

    hello("World");
    hello("user");

    int l = 6;

    int a = 2;
    int b= 3;

    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b +  " = " + area(a, b));
  }

  public static void hello(String name) {
    System.out.println("Hello, " + name + "!");
  }

  public static double area(double ars) {
    return ars * ars;
  }
  public static double area(double ars1, double ars2) {
    return ars1 * ars2;
  }
}