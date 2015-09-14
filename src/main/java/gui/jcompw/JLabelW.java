package gui.jcompw;

import javax.swing.*;
import java.awt.*;

/**
 * Created by max on 27.09.14.
 */
public class JLabelW extends MainAttrAbstr {

    private JLabel jl;

    public JLabelW(JLabel jl) {
        this.jl = jl;
    }


    @Override
    public String getText() {
        return jl.getText();
    }

    @Override
    public String getName() {
        return jl.getName();
    }

    @Override
    public void setText(String text) {
        jl.setText(text);
    }

    public void setToolTipText(String toolTipText){
        jl.setToolTipText(toolTipText);
    }

    public void setForeground(Color color) {
        jl.setForeground(color);
    }

//    возможно нужно добавить слуштели


}
