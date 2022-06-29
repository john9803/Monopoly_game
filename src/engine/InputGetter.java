package engine;

import constants.Constants;
import field.FieldTown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class InputGetter extends JPanel implements MouseListener {
    private int mouse_x;
    private int mouse_y;
    Updater updater = new Updater();

    public InputGetter(){}
    
    public void init(Updater updater){this.updater = updater;}
    

    @Override
    public void mouseClicked(MouseEvent e) {
        this.mouse_x = e.getX();
        this.mouse_y = e.getY();
        if (((mouse_x >= Constants.DICE_BUTTON_X) && (mouse_x <= (Constants.DICE_BUTTON_X + Constants.BLOCK_SIZE)))
                && ((mouse_y >= Constants.DICE_BUTTON_Y) && (mouse_y <= (Constants.DICE_BUTTON_Y + Constants.BLOCK_SIZE)))) {
//            System.out.println("X_col: "+mouse_x + " " +"Y_col: "+ mouse_y);
//            System.out.println("Click the rolling button");
//            System.out.println("random number: " + dice_num);
        }
        this.updater.player_turn();
        this.updater.computer_turn();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}
