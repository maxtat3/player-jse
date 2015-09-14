package gui.jcompw;

import listners.ChangeListners;

import javax.swing.*;
import java.awt.event.MouseWheelListener;

/**
 * Created by max on 27.09.14.
 */
public class JSliderW extends MainAttrAbstr {

    private JSlider jSlider;

    public JSliderW(JSlider jSlider) {
        this.jSlider = jSlider;
    }


    @Override
    public String getName() {
        return jSlider.getName();
    }


    public void setValue(int val) {
        jSlider.setValue(val);
    }

    public int getValue() {
        return jSlider.getValue();
    }


    public int getMaximum() {
        return jSlider.getMaximum();
    }


    public void addChangeListener(ChangeListners chl) {
        jSlider.addChangeListener(chl);
    }

    public boolean getValueIsAdjusting() {
        return jSlider.getValueIsAdjusting();
    }

    public void addMouseWheelListener(MouseWheelListener mwhl){
        jSlider.addMouseWheelListener(mwhl);
    }

}
