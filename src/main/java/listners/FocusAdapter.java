package listners;

import app.Const;
import gui.MainFrameV1;

import javax.swing.*;
import java.awt.event.FocusEvent;

/**
 * Created by max on 19.09.14.
 */
public class FocusAdapter extends java.awt.event.FocusAdapter {

    private MainFrameV1 mainFrame;


    public FocusAdapter(MainFrameV1 mainFrame) {
        this.mainFrame = mainFrame;
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (!isJtf(e)){
            return;
        }

        JTextField jtf = (JTextField) e.getSource();

        if (jtf.getName().equals(Const.TextFieldProps.LIVE_SEARCH_NAME)){
            mainFrame.getJtfLiveSearch().setText(Const.EMPTY_STR);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (!isJtf(e)){
            return;
        }

        JTextField jtf = (JTextField) e.getSource();

        if (jtf.getName().equals(Const.TextFieldProps.LIVE_SEARCH_NAME)){
            mainFrame.getJtfLiveSearch().setText(Const.TextFieldProps.LIVE_SEARCH_DEFAULT_TEXT);
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
