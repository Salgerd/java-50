package ru.stqa.les.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 12.04.2018.
 */
public class PrimeTests {

   @Test
   public void testPrime() {

      Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
   }

   @Test
   public void testNonPrime() {

      Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
   }

   @Test (enabled = false)
   public void testPrimeLong() {
      long n = Integer.MAX_VALUE;
      Assert.assertTrue(Primes.isPrime(n));
   }

   @Test
   public void testPrimeFast() {

      Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
   }
}
