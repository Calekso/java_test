package my.pkg.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

    @Test
    public void testPrimes(){
        Assert.assertTrue(Primes.isPrimes(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimesTwo(){
        Assert.assertTrue(Primes.isPrimes(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testPrimesLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimes(n));
    }
}


