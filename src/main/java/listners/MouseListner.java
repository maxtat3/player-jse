package listners;

import app.Const;
import player.AudioPreprocessor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

/**
 * Created by max on 19.10.14.
 */
public class MouseListner extends MouseAdapter {

    private static final Logger LOG = Logger.getLogger(MouseListner.class.getName());
    private AudioPreprocessor audioPreproc;


    public MouseListner(AudioPreprocessor audioPreproc) {
        this.audioPreproc = audioPreproc;
    }


    /**
     * Обработка нажатия кнопок мыши
     * @param e - событие
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if ( !(e.getSource() instanceof JList) ){
            return;
        }

        JList list = (JList) e.getSource();

        if (list.getName().equals(Const.ListProps.PLAYLIST_NAME)){
            if (e.getClickCount() == 2){
                LOG.info("play");
                audioPreproc.play();
            }
        }
    }
}
