package ru.stqa.les.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 21.03.2018.
 */
public class EquationTest {

   @Test
   public void test0() {                                   //нет корней
      Equation e = new Equation(5, 3, 7);
      Assert.assertEquals(e.rootNumber(),0);
   }

   @Test
   public void test1() {                                 // один корень
      Equation e = new Equation(1, -6, 9);
      Assert.assertEquals(e.rootNumber(),1);
   }

   @Test
   public void test2() {                                // два корня
      Equation e = new Equation(1, -8, 12);
      Assert.assertEquals(e.rootNumber(),2);
   }

   @Test
   public void testLinear() {                           //линейное уравнение
      Equation e = new Equation(0, 1, 1);
      Assert.assertEquals(e.rootNumber(),1);
   }

   @Test
   public void testConstat() {                           // выраждается в константу
      Equation e = new Equation(0, 0, 1);
      Assert.assertEquals(e.rootNumber(),0);
   }

   @Test
   public void testZero() {                             //корней бесконечное множество
      Equation e = new Equation(0, 0, 0);
      Assert.assertEquals(e.rootNumber(),-1);
   }

}
