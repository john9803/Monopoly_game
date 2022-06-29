package engine;

import constants.Constants;
import state.GlobalState;

import javax.swing.*;
import java.util.Random;

public class Updater {
    public String[][] score = new String[Constants.FIELD_WIDTH][Constants.FIELD_HEIGHT];
    Painter painter = new Painter();
    public void player_turn(){
        Random random = new Random();
        int dice_num = (int) (Math.random() * Constants.MAX_DICE_NUM + 1) ;
        GlobalState.globalState.player.setCnt(GlobalState.globalState.player.getCnt()+ dice_num*Constants.UNIT_SIZE); // 0 + 6*
        // 확인하기
        System.out.println("Player turn");
        System.out.println(GlobalState.globalState.player.getCnt()/50);

        if (GlobalState.globalState.player.getCnt() > Constants.MAX_BOARD_CNT) { // position renew
            GlobalState.globalState.player.setCnt(GlobalState.globalState.player.getCnt() % Constants.MAX_BOARD_CNT);
            GlobalState.globalState.player.setLap_num(GlobalState.globalState.player.getLap_num() + 1);
            System.out.println("============================");
            System.out.println(GlobalState.globalState.player.getCnt()/50);
            System.out.println("Player Run "+GlobalState.globalState.player.getLap_num() + "th round complete!");
            System.out.println("============================");
        }
        switch (GlobalState.globalState.player.getCnt() / Constants.FIELD_SIZE ) {
            case 0:
                GlobalState.globalState.player.setPosition_x(GlobalState.globalState.player.getCnt());
                GlobalState.globalState.player.setPosition_y(Constants.MIN_LOCATION+Constants.FINE_PADDING);
                break;
            case 1:
                GlobalState.globalState.player.setPosition_x(Constants.MAX_LOCATION+Constants.FINE_PADDING);
                GlobalState.globalState.player.setPosition_y(GlobalState.globalState.player.getCnt() % Constants.FIELD_SIZE);
                break;
            case 2:
                GlobalState.globalState.player.setPosition_x(Constants.MAX_LOCATION - (GlobalState.globalState.player.getCnt() % Constants.FIELD_SIZE));
                GlobalState.globalState.player.setPosition_y(Constants.MAX_LOCATION+Constants.FINE_PADDING);
                break;
            case 3:
                GlobalState.globalState.player.setPosition_x(Constants.MIN_LOCATION+Constants.FINE_PADDING);
                GlobalState.globalState.player.setPosition_y(Constants.MAX_LOCATION - (GlobalState.globalState.player.getCnt() % Constants.FIELD_SIZE));
                break;
        }
        painter.update();
        if ( GlobalState.globalState.player.getLap_num() == 3){
            int player_num = JOptionPane.showConfirmDialog(null, "player win!");
            System.out.println(player_num);
            switch(player_num){
                case 0:
                    reset_units();
                    break;
                case 1:
                    reset_units();
                    break;
                case 2:
                    reset_units();
                    break;
            }
        }
    }

    public void computer_turn(){
        Random random = new Random();
        int dice_num = (int) (Math.random() * Constants.MAX_DICE_NUM + 1);
        GlobalState.globalState.computer.setCnt(GlobalState.globalState.computer.getCnt()+ dice_num*Constants.UNIT_SIZE);
        // 확인하기
        System.out.println("Computer turn");
        System.out.println(GlobalState.globalState.computer.getCnt()/50);

        if (GlobalState.globalState.computer.getCnt() > Constants.MAX_BOARD_CNT) { // position renew
            GlobalState.globalState.computer.setCnt(GlobalState.globalState.computer.getCnt() % Constants.MAX_BOARD_CNT);
            GlobalState.globalState.computer.setLap_num(GlobalState.globalState.computer.getLap_num() + 1);
            System.out.println("============================");
            System.out.println(GlobalState.globalState.computer.getCnt()/50);
            System.out.println("Computer Run "+GlobalState.globalState.computer.getLap_num() + "th round complete!");
            System.out.println("============================");
        }

        switch (GlobalState.globalState.computer.getCnt() / Constants.FIELD_SIZE) {
            case 0:
                GlobalState.globalState.computer.setPosition_x(GlobalState.globalState.computer.getCnt());
                GlobalState.globalState.computer.setPosition_y(Constants.MIN_LOCATION-Constants.FINE_PADDING);
                break;
            case 1:
                GlobalState.globalState.computer.setPosition_x(Constants.MAX_LOCATION-Constants.FINE_PADDING);
                GlobalState.globalState.computer.setPosition_y(GlobalState.globalState.computer.getCnt() % Constants.FIELD_SIZE);
                break;
            case 2:
                GlobalState.globalState.computer.setPosition_x(Constants.MAX_LOCATION - (GlobalState.globalState.computer.getCnt() % Constants.FIELD_SIZE));
                GlobalState.globalState.computer.setPosition_y(Constants.MAX_LOCATION-Constants.FINE_PADDING);
                break;
            case 3:
                GlobalState.globalState.computer.setPosition_x(Constants.MIN_LOCATION-Constants.FINE_PADDING);
                GlobalState.globalState.computer.setPosition_y(Constants.MAX_LOCATION - (GlobalState.globalState.computer.getCnt() % Constants.FIELD_SIZE));
                break;
        }
        painter.update();
        if ( GlobalState.globalState.computer.getLap_num() == 3){
            int computer_num = JOptionPane.showConfirmDialog(null, "computer win!");
            System.out.println(computer_num);
            switch(computer_num){
                case 0:
                    reset_units();
                    break;
                case 1:
                    reset_units();
                    break;
                case 2:
                    reset_units();
                    break;
            }
        }
    }
    public void reset_units(){
        //player_reset
        GlobalState.globalState.player.setPosition_x(Constants.PADDING);
        GlobalState.globalState.player.setPosition_y(Constants.PADDING+Constants.FINE_PADDING);
        GlobalState.globalState.player.setCnt(0);
        GlobalState.globalState.player.setLap_num(0);

        //computer_reset
        GlobalState.globalState.computer.setPosition_x(Constants.PADDING);
        GlobalState.globalState.computer.setPosition_y(Constants.PADDING-Constants.FINE_PADDING);
        GlobalState.globalState.computer.setCnt(0);
        GlobalState.globalState.computer.setLap_num(0);
        // repaint
        painter.update();
    }
}
