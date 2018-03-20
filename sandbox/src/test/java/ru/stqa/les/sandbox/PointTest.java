package ru.stqa.les.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 20.03.2018.
 */

@Test
public class PointTest {


   public void testPointDistance() {

      Point p1 = new Point(2,1);
      Point p2 = new Point(5, 5);

      Assert.assertEquals(p1.distance(p2),5.0);

   }

   public void testPointDistance1() {

      Point p1 = new Point(7,0);
      Point p2 = new Point(3, 0);

      Assert.assertEquals(p1.distance(p2),4.0);

   }

}
