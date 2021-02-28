package my.pkg.sandbox;

public class Sqare {
  public double l;

  public Sqare(double l){ //конструктор класса
    this.l = l;           // this - обрашение к данному объекту
  }
  public double area() { //*метод класса  *
    return this.l * this.l;
  }
}
