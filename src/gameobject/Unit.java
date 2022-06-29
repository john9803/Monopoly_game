package gameobject;



import constants.Constants;

import java.awt.*;

public abstract class Unit {

    protected int x;
    protected int y;

    protected int dice_num;

    public Unit(){

    }

    public Unit(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void init(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Rectangle getObject() {
        return new Rectangle(
                this.x, this.y,
                Constants.UNIT_WIDTH, Constants.UNIT_HEIGHT);
    }



}
