package ru.stqa.les.sandbox;

/**
 * Created by a.zelenskaya on 19.03.2018.
 */
public class Point {

   public double x;
   public double y;

   public Point(double p1, double p2)

   {
      this.x= p1;
      this.y = p2;

   }

   public double distance(Point p2) {

      return Math.sqrt(Math.pow((p2.x - this.x), 2) + Math.pow((p2.y - this.y), 2));

   }

}
