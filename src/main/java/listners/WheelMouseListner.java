package listners;

import app.Const;
import gui.AllJComp;
import gui.MainFrameV1;
import player.AudioPreprocessor;
import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


/**
 * Created by max on 09.10.14.
 */
public class WheelMouseListner implements MouseWheelListener {

    private static final int VOL_RESOL = 10; // значение, на которое изменяем громкость, исходя из макс. значения
    private static final int WH_UP = -1; // признак уменьшения громкости
    private static final int WH_DOWN = 1; // признак увеличения громкости

    private AllJComp mainFrame;
    private AudioPreprocessor audioPreproc;


    public WheelMouseListner(AllJComp mainFrame, AudioPreprocessor audioPreproc) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
    }

    /**
     * Обработка прокручивания колесика мыши
     * @param e - событие
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if ( !(e.getSource() instanceof JSlider) ){
            return;
        }

        JSlider slider = (JSlider) e.getSource();

        if (slider.getName().equals(Const.SliderProps.VOLUME_NAME)){

            if (e.getWheelRotation() == WH_DOWN){ //уменьшение громкости
                int val = mainFrame.getJslVolume().getValue();
                audioPreproc.setVolume(val - VOL_RESOL,  mainFrame.getJslVolume().getMaximum()); //устаноавливаем громкость
                mainFrame.getJslVolume().setValue(val - VOL_RESOL); //устанавливаем положение ползунка

            } else if (e.getWheelRotation() == WH_UP){ //увеличение громкости
                int val = mainFrame.getJslVolume().getValue();
                audioPreproc.setVolume(val + VOL_RESOL,  mainFrame.getJslVolume().getMaximum());
                mainFrame.getJslVolume().setValue(val + VOL_RESOL);
            }

        }
    }

}
