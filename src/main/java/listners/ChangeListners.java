package listners;

import app.Const;
import gui.MainFrameV1;
import player.AudioPreprocessor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by max on 12.09.14.
 */
public class ChangeListners implements ChangeListener {

    private static final String LOG_TAG = ChangeListners.class.getName() + ": ";
    private MainFrameV1 mainFrame;
    private AudioPreprocessor audioPreproc;


    public ChangeListners(MainFrameV1 mainFrame, AudioPreprocessor audioPreproc) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
    }


    /**
     * Изменение состояний ползунков (JSlider): для прокрутки песни и установки уровня громкости
     * @param e - событие
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if ( !(e.getSource() instanceof JSlider) ){
            return;
        }

        JSlider jsl = (JSlider)e.getSource();

        if (jsl.getName().equals(Const.SliderProps.VOLUME_NAME)){
            audioPreproc.setVolume(mainFrame.getJslVolume().getValue(), mainFrame.getJslVolume().getMaximum());
            mainFrame.getJtbtnMute().setSelected(false); // если когда нажат переключатель [mute] передвинуть этот ползунок, переключатель отжимается

        } else if (jsl.getName().equals(Const.SliderProps.REWIND_PROGRESS_NAME)){
//            System.out.println("jump in file");
            jumpInPLayingFile();
        }
    }

    private void jumpInPLayingFile(){
        if ( !mainFrame.getJslRewindProgress().getValueIsAdjusting() ){ //сработает если пользователь не трогает ползунок
            if (audioPreproc.isMovJslProgressAuto()){       //если ползунок двигается при проигрывании песни (авто)...
                audioPreproc.setMovJslProgressAuto(false);  // ...запрещаем это
                System.out.println("jump in ...");

                // устанавливаем значение, на которое
                // пользователь передвинул ползунок
                // т.е. на сколько Байт нужно перемотать назад\вперед
                audioPreproc.setPositionValue( (mainFrame.getJslRewindProgress().getValue() * 1.0) / Const.SliderProps.REWIND_PROGRESS_RESOL);

                // получаем полную длительность проигрываемой песни в Байтах
//                int fullBytes = audioPreproc.getDurSongBytes();

                try {
                    // получаем значение в Байтах на сколько нужно перемотать в главном player
                    long jumpBytes = (long) Math.round( ((long)audioPreproc.getDurSongBytes() * mainFrame.getJslRewindProgress().getValue()) / Const.SliderProps.REWIND_PROGRESS_RESOL);
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
