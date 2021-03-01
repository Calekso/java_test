package my.pkg.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SqareTests {

  @Test // помечаем тест для фреймворка
  public void testArea(){
    Sqare s = new Sqare(5);
    Assert.assertEquals(s.area(), 25.0); // добавляем проверку в тест
  }

}
