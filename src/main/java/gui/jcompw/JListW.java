package gui.jcompw;

import listners.KeyListners;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * Created by max on 27.09.14.
 */
public class JListW extends MainAttrAbstr {

    private JList jList;

    public JListW(JList jList) {
        this.jList = jList;
    }


    @Override
    public String getName() {
        return jList.getName();
    }


    public int[] getSelectedIndices() {
        return jList.getSelectedIndices();
    }

    public int getSelectedIndex() {
        return jList.getSelectedIndex();
    }

    public void setSelectedIndex(int selIndex) {
        jList.setSelectedIndex(selIndex);
    }

    public void setSelectedIndices(int[] selIndexes) {
        jList.setSelectedIndices(selIndexes);
    }


    public void addKeyListener(KeyListners keyl) {
        jList.addKeyListener(keyl);
    }

    public void getTransferHandler(){
        jList.getTransferHandler();
    }

    public void setTransferHandler(TransferHandler th){
        jList.setTransferHandler(th);
    }

    public void addMouseListener(MouseListener ml){
        jList.addMouseListener(ml);
    }
}
