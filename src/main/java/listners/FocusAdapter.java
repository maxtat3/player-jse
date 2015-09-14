package listners;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.FocusEvent;

/**
 * Created by max on 19.09.14.
 */
public class FocusAdapter extends java.awt.event.FocusAdapter {

    private MainFrame mainFrame;


    public FocusAdapter(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (!isJtf(e)){
            return;
        }

        JTextField jtf = (JTextField) e.getSource();

        if (jtf.getName().equals("liveSearch")){
            mainFrame.getJtfLiveSearch().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (!isJtf(e)){
            return;
        }

        JTextField jtf = (JTextField) e.getSource();

        if (jtf.getName().equals("liveSearch")){
            mainFrame.getJtfLiveSearch().setText("live search");
        }
    }


    private boolean isJtf(FocusEvent e) {
        if ( !(e.getSource() instanceof JTextField) ){
            return false;
        } else {
            return true;
        }
    }

}
