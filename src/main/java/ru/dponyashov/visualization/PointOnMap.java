package ru.dponyashov.visualization;

import java.awt.*;

public class PointOnMap {
    private Color color;
    private int state;

    public PointOnMap(Color color){
        this.color = color;
        this.state = 0;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void invertState(){
        this.state++;
        if( this.state > 1) {
            this.state = 0;
        }
    }
    public Color getColor(){
        return this.color;
    }
    public int getState(){
        return this.state;
    }
}
