package gui.jcompw;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by max on 27.09.14.
 */
public class JButtonW extends MainAttrAbstr {

    private JButton jbtn;

    public JButtonW(JButton jbtn) {
        this.jbtn = jbtn;
    }


    @Override
    public String getText() {
        return jbtn.getText();
    }

    @Override
    public String getName() {
        return jbtn.getName();
    }


    public void addActionListener(ActionListener a) {
        jbtn.addActionListener(a);
    }

    public String getActionCommand() {
        return jbtn.getActionCommand();
    }

}
