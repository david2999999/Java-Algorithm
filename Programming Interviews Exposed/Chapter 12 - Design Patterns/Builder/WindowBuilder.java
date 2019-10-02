public class WindowBuilder {
    public WindowBuilder() {}

    public WindowBuilder setDialog( boolean flag ){
        dialog = flag;
        return this;
    }
    public WindowBuilder setModal( boolean flag ){
        modal = flag;
        return this;
    }
    public WindowBuilder setVisible( boolean flag ){
        visible = flag;
        return this;
    }
    public Window build(){
        return new Window( visible, modal, dialog );
    }
    private boolean dialog;
    private boolean modal;
    private boolean visible;
}