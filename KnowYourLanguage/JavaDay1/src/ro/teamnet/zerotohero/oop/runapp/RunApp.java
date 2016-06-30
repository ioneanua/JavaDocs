package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.oop.Circles;
import ro.teamnet.zerotohero.oop.Square;
import ro.teamnet.zerotohero.oop.graphicshape.Circle;
import ro.teamnet.zerotohero.oop.graphicshape.Shape;
import ro.teamnet.zerotohero.oop.graphicshape.ShapeBehaviour;
import ro.teamnet.zerotohero.oop.graphicshape.point;

/**
 * Created by user on 6/30/2016.
 */
public class RunApp {

    public static void main(String[] args) {

        Circles cercuri = new Circles();

        System.out.println("Area from getAreaPub: " + cercuri.getAreaPub());

        System.out.println("Def from getAreaDef: ");
        cercuri.getAreaDef();

        Shape shapeNew = new Circle(10);
        System.out.println("shapeNew Area: ");
        shapeNew.area();

        ShapeBehaviour shapeBehObject = new Square(10);
        System.out.println("ShapeObject Area by Square: ");
        shapeBehObject.area();

        Object p1 = new point(10, 20);
        Object p2 = new point(50, 100);
        Object p3 = new point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }
}
