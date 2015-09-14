package listners;

import app.Const;
import gui.MainFrameV1;
import player.AudioPreprocessor;
import utils.FileUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by max on 01.10.14.
 */
public class KeyDispatcher implements KeyEventDispatcher {

    private MainFrameV1 mainFrame;
    private AudioPreprocessor audioPreproc;
    private FileUtils fileUtils;


    public KeyDispatcher(MainFrameV1 mainFrame, AudioPreprocessor audioPreproc, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        this.fileUtils = fileUtils;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED){

            if (ctrl_f(e)){
                mainFrame.getJtfLiveSearch().requestFocus();

            } else if (ctrl_a(e)){
                fileUtils.addSongToPlayList();

            } else if (ctrl_z(e)){
                if (mainFrame.getJtbtnMute().isSelected()){
                    mainFrame.getJtbtnMute().setSelected(false);
                    audioPreproc.mute(false);
                } else {
                    mainFrame.getJtbtnMute().setSelected(true);
                    audioPreproc.mute(true);
                }
            } else if (ctrl_up(e)){
                int value = mainFrame.getJslVolume().getValue();
                mainFrame.getJslVolume().setValue(value + 10);
                // т.к. макс значение для volume = 200, если добавить 10
                // будет 20 шагов для регулирования

            } else if (ctrl_down(e)){
                int value = mainFrame.getJslVolume().getValue();
                mainFrame.getJslVolume().setValue(value - 10);
                // т.к. макс значение для volume = 200, если добавить 10
                // будет 20 шагов для регулирования

            } else if (ctrl_left(e)){
                rewinding(RewindDirection.LEFT);

            } else if (ctrl_right(e)){
                rewinding(RewindDirection.RIGHT);

            } else if (ctrl_1(e)){
                audioPreproc.play();

            } else if (ctrl_2(e)){
                audioPreproc.pause();

            } else if (ctrl_3(e)){
                audioPreproc.stop();

            } else if (ctrl_q(e)){
                audioPreproc.playPreviousSong();

            } else if (ctrl_w(e)){
                audioPreproc.playNextSong();

            }

        }
        return false;
    }

    private boolean ctrl_f(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_F, e);
    }

    private boolean ctrl_a(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_A, e);
    }

    private boolean ctrl_z(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_Z, e);
    }

    private boolean ctrl_up(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_UP, e);
    }

    private boolean ctrl_down(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_DOWN, e);
    }

    private boolean ctrl_left(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_LEFT, e);
    }

    private boolean ctrl_right(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_RIGHT, e);
    }

    private boolean ctrl_1(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_1, e);
    }

    private boolean ctrl_2(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_2, e);
    }

    private boolean ctrl_3(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_3, e);
    }

    private boolean ctrl_q(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_Q, e);
    }

    private boolean ctrl_w(KeyEvent e){
        return controlKeyPressed(KeyEvent.VK_W, e);
    }


    /**
     *
     * @param key
     * @param e
     * @return
     */
    private boolean controlKeyPressed(int key, KeyEvent e){
        if (e.isControlDown() && e.getKeyCode() == key){
            return true;
        } else {
            return false;
        }
    }


    private static final int STEP_OF_REWIND = 50;

    /**
     *
     * @param dir
     */
    private void rewinding(RewindDirection dir){
        int newVal = 0;
        if (dir == RewindDirection.LEFT){
            newVal = mainFrame.getJslRewindProgress().getValue() - STEP_OF_REWIND;
        } else if (dir == RewindDirection.RIGHT){
            newVal = mainFrame.getJslRewindProgress().getValue() + STEP_OF_REWIND;
        }
//          audioPreproc.setPositionValue( mainFrame.getJslRewindProgress().getValue() + 100 ); // ???????
        mainFrame.getJslRewindProgress().setValue(newVal);

        try {
            // получаем значение в Байтах на сколько нужно перемотать в главном player
            // Например jumpBytes = ((long)550 Байт * 750) / 1000 = 412500 * 750 = (long) Math.round(412,5) = 412 -> to jumpBytes
            // Формула jumpBytes = Х Байт * currJSliderValue / maxJSliderValue
            long jumpBytes = (long) Math.round( ((long)audioPreproc.getDurSongBytes() * mainFrame.getJslRewindProgress().getValue()) / Const.SliderProps.REWIND_PROGRESS_RESOL);
            audioPreproc.jump(jumpBytes); // передаем это значение в player
        } catch (Exception ex){
            ex.printStackTrace();
        }

        // сбрасываем флаг ручного передвижения ползунка
        audioPreproc.setMovJslProgressMan(false);
    }

    /**
     *
     */
    private enum RewindDirection {
        LEFT,
        RIGHT;
    }

}
