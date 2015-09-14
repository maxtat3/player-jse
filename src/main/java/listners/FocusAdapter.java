package listners;

import app.Const;
import gui.AllJComp;
import gui.MainFrameV1;

import javax.swing.*;
import java.awt.event.FocusEvent;

/**
 * Created by max on 19.09.14.
 */
public class FocusAdapter extends java.awt.event.FocusAdapter {

    private AllJComp mainFrame;


    public FocusAdapter(AllJComp mainFrame) {
        this.mainFrame = mainFrame;
    }


    /**
     * Выполнение действий, когда компонент в фокусе
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (!isJtf(e)){
            return;
        }

        JTextField jtf = (JTextField) e.getSource();

        if (jtf.getName().equals(Const.TextFieldProps.LIVE_SEARCH_NAME)){
            mainFrame.getJtfLiveSearch().setText(Const.SpecSym.EMPTY_STR);
        }
    }

    /**
     * Выполнение действий, когда компонент вне фокуса
     * @param e
     */
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


    /**
     * Проверка, является ли переданный компонент JTextField
     * @param e
     * @return true - да
     */
    private boolean isJtf(FocusEvent e) {
        if ( !(e.getSource() instanceof JTextField) ){
            return false;
        } else {
            return true;
        }
    }

}
