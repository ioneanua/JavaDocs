package ro.teamnet.zerotohero.oop;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;

/**
 * Created by user on 6/30/2016.
 */

public class Circles {


    public double getAreaPub(){

        Circle cercNou = new Circle();

        System.out.println("Area of cercNou in ro.teamnet.zerotohero.oop.Circles is: " + cercNou.area());

        return 0.4;
    }

    public void getAreaDef(){

        Circle cercCircles = new Circle();

        cercCircles.fillColour();
        cercCircles.fillColour();
        cercCircles.fillColour();
    }
}
