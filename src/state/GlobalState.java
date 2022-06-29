package state;

import constants.Constants;
import field.FieldTown;
import gameobject.Computer;
import gameobject.Player;

public class GlobalState {

    public static GlobalState globalState = new GlobalState();
    public FieldTown currentField;
    public Player player;
    public Computer computer;

    public GlobalState () {
        this.currentField = new FieldTown(
                Constants.FIELD_WIDTH,
                Constants.FIELD_HEIGHT);

        this.player = new Player(0, Constants.PADDING+Constants.FINE_PADDING, Constants.PADDING, 0);
        this.computer = new Computer(0, Constants.PADDING-Constants.FINE_PADDING, Constants.PADDING , 0);

    }

    public void init() {

    }



}
