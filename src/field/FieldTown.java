package field;

import constants.Constants;
import engine.InputGetter;
import gameobject.Computer;
import gameobject.Player;
import state.GlobalState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class FieldTown extends JPanel {

    public FieldTown(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.ORANGE);


    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int x=0;x<Constants.FIELD_WIDTH;x+=Constants.UNIT_WIDTH){
            for (int y=0;y<Constants.FIELD_HEIGHT;y+=Constants.UNIT_WIDTH){
                if(!((x>Constants.UNIT_WIDTH-1 && x<Constants.FIELD_WIDTH-Constants.UNIT_WIDTH)
                        && (y>Constants.UNIT_WIDTH-1 && y<Constants.FIELD_WIDTH-Constants.UNIT_WIDTH))){
                    g.drawRect(x, y, Constants.UNIT_WIDTH, Constants.UNIT_HEIGHT);
                }
            }
        }
        GlobalState.globalState.player.draw(g);
        GlobalState.globalState.computer.draw(g);

        g.setColor(Color.white);
        g.fillRect(Constants.DICE_BUTTON_X,Constants.DICE_BUTTON_Y,Constants.BLOCK_SIZE,Constants.BLOCK_SIZE);

    }


}
