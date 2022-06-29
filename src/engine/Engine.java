package engine;


import state.GlobalState;

public class Engine {

    private static Engine unique_engine = new Engine();
    private InputGetter inputGetter;
    private Painter painter;
    private Updater updater;



    private Engine(){
        this.inputGetter = new InputGetter();
        this.updater = new Updater();
        this.painter = new Painter();

    }

    public static Engine getInstance(){ return unique_engine; }

    public void init() {
        GlobalState.globalState.init();
        this.painter.init();

        this.painter.switchField(this.inputGetter);

    }


}
