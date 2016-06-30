package ro.teamnet.zerotohero.oop.graphicshape;


/**
 * Created by user on 6/30/2016.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){

        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;

    }

    public Circle(int xPos){

        this.xPos = xPos;

    }

    public Circle(int xPos, int yPos){

        this.xPos = xPos;
        this.yPos = yPos;

    }

    public Circle(int xPos, int yPos, int radius){

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;

    }

    public double area() {
        System.out.println("Circle.area: ");
        return radius * radius * Math.PI;
    }

    public String toString() {
        return "Center = (" + xPos + ", " + yPos + ")" + ";" + "Radius: " + radius;
    }

    public void fillColour(){
        System.out.println(color);
    }

    public void fillColour(int color){
        super.color = color;
        System.out.println("The circle color is now: " + color);
    }

    public void fillColour(float saturation){
        super.saturation = saturation;
        System.out.println("The saturation is now: " + saturation);
    }
}
