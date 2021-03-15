package my.pkg.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationsTest {

    @Test
    public void test0(){
    Equations e = new Equations(1,1,1);
        Assert.assertEquals(e.rootNumber(), 0);
    }

    @Test
    public void test1(){
        Equations e = new Equations(1,2,1);
        Assert.assertEquals(e.rootNumber(), 1);
    }

    @Test
    public void test2(){
        Equations e = new Equations(1,5,6);
        Assert.assertEquals(e.rootNumber(), 2);
    }

    @Test
    public void testLine(){
        Equations e = new Equations(0,1,1);
        Assert.assertEquals(e.rootNumber(), 1);
    }

    @Test
    public void testConst(){
        Equations e = new Equations(0,0,1);
        Assert.assertEquals(e.rootNumber(), 0);
    }

    @Test
    public void testMany(){
        Equations e = new Equations(0,0,0);
        Assert.assertEquals(e.rootNumber(), -1);
    }
}
