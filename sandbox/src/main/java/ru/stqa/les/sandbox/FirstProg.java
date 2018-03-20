package ru.stqa.les.sandbox;

public class FirstProg {

    public static void main(String[] args) {

       // System.out.println("This is my first program.");

        Point p1 = new Point();

        p1.x = 2;
        p1.y = 3;

        Point p2 = new Point();

        p2.x = 4;
        p2.y = 6;

    }


    public static double distance(Point p1, Point p2) {

        return Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));

    }
}