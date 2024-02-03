package ru.dponyashov.ant;

import java.awt.Color;

public class Ant {
    private int x;
    private int y;
    private int directionStatus;
    private final Direction[] directions = { Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN };
    private final Color whiteColor;
    private final Color blackColor;
    private final int mapSizeX;
    private final int mapSizeY;

    public Ant( Color whiteColor, Color blackColor, int mapSizeX, int mapSizeY ){
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.whiteColor = whiteColor;
        this.blackColor = blackColor;
        initAnt( );
    }

    public Color nextStep( int state ){
        Color color;
        if( state == 1 ) {
            color = this.whiteColor;
            turnLeft();
        } else {
            color = this.blackColor;
            turnRight();
        }
        move();
        return color;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    private void turnLeft(){
        directionStatus--;
        if( directionStatus < 0 ){
            directionStatus = directions.length - 1;
        }
    }

    private void turnRight(){
        directionStatus++;
        if( directionStatus > ( directions.length - 1 ) ){
            directionStatus = 0;
        }
    }

    private void move(){
        if ( directions[directionStatus] == Direction.LEFT ){
            this.y--;
            if ( this.y < 0 ) this.y = this.mapSizeX - 1;
        } else if ( directions[directionStatus] == Direction.RIGHT ) {
            this.y++;
            if ( this.y > ( this.mapSizeX - 1 ) ) this.y = 0;
        } else if ( directions[directionStatus] == Direction.UP ){
            this.x--;
            if ( this.x < 0 ) this.x = this.mapSizeY - 1;
        } else if ( directions[directionStatus] == Direction.DOWN ) {
            this.x++;
            if ( this.x > ( this.mapSizeY - 1 ) ) this.x = 0;
        }
    }

    private void initAnt(){
        this.x = (int)( Math.random() * this.mapSizeY );
        this.y = (int)( Math.random() * this.mapSizeX );
        this.directionStatus = (int)( Math.random() * directions.length );
    }
}
