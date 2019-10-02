public class Window {
    public Window( boolean visible, boolean modal, boolean dialog ){
        this.visible = visible;
        this.modal = modal;
        this.dialog = dialog;
    }

    private boolean visible;
    private boolean modal;
    private boolean dialog;
}