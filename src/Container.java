import java.awt.*;

public class Container extends Rectangle {

    public enum Form{
        x,o,n
    }

    private Form form;
    private boolean show=false;

    public boolean isShow()
    {
        return show;
    }
    public void setShow(boolean show) {
        this.show = show;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        if(form==Form.x||form==Form.o)
            this.form = form;
    }
}
