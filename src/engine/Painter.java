package engine;

import constants.Constants;
import field.FieldTown;
import state.GlobalState;

import javax.swing.*;

public class Painter extends JFrame {


    private InputGetter inputgetter;

    public Painter(){

    }

    public void init() {
        this.setTitle(Constants.MAIN_FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void switchField(InputGetter inputGetter){
        this.add(GlobalState.globalState.currentField);
        this.pack();
        GlobalState.globalState.currentField.addMouseListener(inputGetter);
        GlobalState.globalState.currentField.setFocusable(true);
        GlobalState.globalState.currentField.requestFocusInWindow();

    }

    public void update() {
        GlobalState.globalState.currentField.repaint();
    }
}
