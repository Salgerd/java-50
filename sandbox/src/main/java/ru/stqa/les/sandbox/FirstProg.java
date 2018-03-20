package ru.stqa.les.sandbox;

public class FirstProg {

    public static void main(String[] args) {

       // System.out.println("This is my first program.");

        Point p1 = new Point(1,3);

        Point p2 = new Point(4, 4);

        System.out.println("Растояние между точками =" + p1.distance(p2));

    }



}