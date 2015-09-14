package gui.jcompw;

import javax.swing.*;
import java.awt.event.ActionListener;


/**
 * Created by max on 27.09.14.
 */
public class JToggleButtonW extends MainAttrAbstr {

    private JToggleButton jtbtn;

    public JToggleButtonW(JToggleButton jtbtn) {
        this.jtbtn = jtbtn;
    }


    @Override
    public String getText() {
        return jtbtn.getText();
    }

    @Override
    public String getName() {
        return jtbtn.getName();
    }

    public void addActionListener(ActionListener a) {
        jtbtn.addActionListener(a);
    }

    public String getActionCommand() {
        return jtbtn.getActionCommand();
    }

    public void setSelected(boolean selState){
        jtbtn.setSelected(selState);
    }

    public boolean isSelected(){
        return jtbtn.isSelected();
    }

}
