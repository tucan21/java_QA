package pl.java_qa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE ));
  }
  @Test
  public void testNoPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

}
