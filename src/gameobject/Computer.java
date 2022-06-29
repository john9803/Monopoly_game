package gameobject;

import engine.Drawable;

import java.awt.*;

public class Computer extends Unit implements Drawable {

    private int cnt;
    private int position_x;
    private int position_y;
    private int lap_num;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public int getLap_num() {
        return lap_num;
    }

    public void setLap_num(int lap_num) {
        this.lap_num = lap_num;
    }

    public Computer(int cnt, int position_y, int position_x, int lap_num) {
        this.cnt = cnt;
        this.position_y = position_y;
        this.position_x = position_x;
        this.lap_num = lap_num;
    }
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)  g;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(this.position_x,this.position_y,10,10);
    }
}
