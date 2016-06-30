package ro.teamnet.zerotohero.oop.graphicshape;


/**
 * Created by user on 6/30/2016.
 */
public class point {

    public int xPos;
    public int yPos;

    public point(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        point point = (point) o;

        if(o instanceof point) {
            point anotherPoint = (point) o;
            // two points are equal only if their x and y positions are equal
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;

    }

}
