package ro.teamnet.zerotohero.oop;

import ro.teamnet.zerotohero.oop.graphicshape.Shape;

/**
 * Created by user on 6/30/2016.
 */
public class Square extends Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public double area() {
        System.out.println("ro.teamnet.zerotohero.oop.Square.area: ");
        return (side * side);
    }
}
