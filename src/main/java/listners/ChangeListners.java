package listners;

import app.Const;
import gui.MainFrame;
import player.AudioPreprocessor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by max on 12.09.14.
 */
public class ChangeListners implements ChangeListener {

    private static final String LOG_TAG = ChangeListners.class.getName() + ": ";
    private MainFrame mainFrame;
    private AudioPreprocessor audioPreproc;


    public ChangeListners(MainFrame mainFrame, AudioPreprocessor audioPreproc) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
    }


    /**
     * Изменение состояния ползунка (JSlider) для прокрутки песни
     * @param e - событие
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if ( !(e.getSource() instanceof JSlider) ){
            return;
        }

        JSlider jsl = (JSlider)e.getSource();

        if (jsl.getName().equals("Громкость")){
            audioPreproc.setVolume(mainFrame.getJslVolume().getValue(), mainFrame.getJslVolume().getMaximum());
        } else if (jsl.getName().equals("Прокрутка композиции")){
            jumpInPLayingFile();
        }
    }

    private void jumpInPLayingFile(){
        if (mainFrame.getJslRewindProgress().getValueIsAdjusting() == false){ //сработает если пользователь не трогает ползунок
            if (audioPreproc.isMovJslProgressAuto()){       //если ползунок двигается при проигрывании песни (авто)...
                audioPreproc.setMovJslProgressAuto(false);  // ...запрещаем это

                // устанавливаем значение, на которое
                // пользователь передвинул ползунок
                // т.е. на сколько Байт нужно перемотать назад\вперед
                audioPreproc.setPositionValue( (mainFrame.getJslRewindProgress().getValue() * 1.0) / Const.RESOL_JSL_REWIND_PROGRESS);

                // получаем полную длительность проигрываемой песни в Байтах
                int fullBytes = audioPreproc.getDurSongBytes();

                try {
                    // получаем значение в Байтах
                    // на сколько нужно перемотать в главном player
                    long jumpBytes = (long) Math.round( ((long)audioPreproc.getDurSongBytes() * mainFrame.getJslRewindProgress().getValue()) / Const.RESOL_JSL_REWIND_PROGRESS);
//                    System.out.println("jumpBytes = " + jumpBytes);
                    audioPreproc.jump(jumpBytes); // передаем это значение в player
                } catch (Exception ex){
                    ex.printStackTrace();
                }

                // сбрасываем флаг ручного передвижения ползунка
                audioPreproc.setMovJslProgressMan(false);
            }
        } else {
            audioPreproc.setMovJslProgressAuto(true);
            audioPreproc.setMovJslProgressMan(true);
        }
    }

}
