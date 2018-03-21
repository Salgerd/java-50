package ru.stqa.les.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class EquationTest {

   @Test
   public void test0() {
      Equation e = new Equation(5, 3, 7);
      Assert.assertEquals(e.rootNumber(),0);
   }

   @Test
   public void test1() {
      Equation e = new Equation(1, -6, 9);
      Assert.assertEquals(e.rootNumber(),1);
   }

   @Test
   public void test2() {
      Equation e = new Equation(1, -8, 12);
      Assert.assertEquals(e.rootNumber(),2);
   }
}
