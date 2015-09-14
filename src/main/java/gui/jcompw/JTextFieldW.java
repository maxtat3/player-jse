package gui.jcompw;

import listners.FocusAdapter;
import listners.KeyListners;

import javax.swing.*;

/**
 * Created by max on 27.09.14.
 */
public class JTextFieldW extends MainAttrAbstr {

    private JTextField jtf;

    public JTextFieldW(JTextField jtf) {
        this.jtf = jtf;
    }


    @Override
    public String getText() {
        return jtf.getText();
    }

    @Override
    public void setText(String text) {
        jtf.setText(text);
    }

    @Override
    public String getName() {
        return jtf.getName();
    }


    public void addKeyListener(KeyListners keyl) {
        jtf.addKeyListener(keyl);
    }

    public void addFocusListener(FocusAdapter focus) {
        jtf.addFocusListener(focus);
    }

    public void requestFocus(){
        jtf.requestFocus();
    }

}
