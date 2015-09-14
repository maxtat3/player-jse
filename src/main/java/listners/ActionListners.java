package listners;

import app.Const;
import player.AudioPreprocessor;
import utils.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Используется для отработки событий нажатия на кнопки типа JButton
 * Created by max on 02.09.14.
 */
public class ActionListners implements ActionListener{

    private static final String LOG_TAG = ActionListners.class.getName();
    private AudioPreprocessor audioPreproc;
    private FileUtils fileUtils;


    public ActionListners() {
    }

    public ActionListners(AudioPreprocessor audioPreproc, FileUtils fileUtils) {
        this.audioPreproc = audioPreproc;
        this.fileUtils = fileUtils;
    }


    /**
     * Общий слушатель событий для всех кнопок главной формы
     * @param e - генрируемре событие нажатие на кнопку
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() instanceof JButton ){
            JButton jbtn = (JButton) e.getSource();
            jButtonAction(jbtn);
        } else if ( e.getSource() instanceof JToggleButton ){
            JToggleButton jtbtn = (JToggleButton) e.getSource();
            jToggleButtonAction(jtbtn);
        } else {
            System.out.println("is not button and toggle button");
        }

    }

    /**
     * Обработка события кнопок JButton
     * @param jbtn - кнопка, сгенерировавшая событие нажатие
     */
    private void jButtonAction(JButton jbtn){
        if (jbtn.getActionCommand().equals(Const.ButtonProps.PLAY)){
            audioPreproc.play();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.PAUSE)){
            audioPreproc.pause();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.STOP)){
            audioPreproc.stop();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.PREV_SONG)){
            audioPreproc.playPreviousSong();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.NEXT_SONG)){
            audioPreproc.playNextSong();


        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.ADD)){
            fileUtils.addSongToPlayList();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.REMOVE)){
            fileUtils.removeSongToPlayList();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.UP)){
            audioPreproc.selectPreviousSong();

        } else if (jbtn.getActionCommand().equals(Const.ButtonProps.DOWN)) {
            audioPreproc.selectNextSong();
        }
    }

    /**
     * Обработка события кнопок JToogleButton
     * @param jtbtn - кнопка с фиксированным нажатием, сгенерировавшая событие нажатие
     */
    private void jToggleButtonAction(JToggleButton jtbtn){
        if (jtbtn.getActionCommand().equals(Const.ButtonProps.MONO_STEREO)){
            System.out.println("toggle button mono presed = " + Const.ButtonProps.MONO_STEREO);
        } else if (jtbtn.getActionCommand().equals(Const.ButtonProps.MUTE)){
            if (jtbtn.isSelected()){
                audioPreproc.mute(true);
            } else {
                audioPreproc.mute(false);
            }
        }
    }
}
