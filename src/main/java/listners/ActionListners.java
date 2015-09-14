package listners;

import app.Const;
import player.AudioPreprocessor;
import utils.FileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Используется для отработки событий нажатия на кнопки JButton
 * Created by max on 02.09.14.
 */
public class ActionListners implements ActionListener{

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
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( !(e.getSource() instanceof JButton) ){
            return;
        }

        JButton jbtn = (JButton)e.getSource();

        if (jbtn.getActionCommand().equals(Const.ButtonNames.PLAY)){
            audioPreproc.play();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.PAUSE)){
            audioPreproc.pause();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.STOP)){
            audioPreproc.stop();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.PREV_SONG)){
            audioPreproc.playPreviousSong();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.NEXT_SONG)){
            audioPreproc.playNextSong();


        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.ADD)){
//            fileUtils.addSongToPlayList();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.REMOVE)){
//            fileUtils.removeSongToPlayList();
            System.out.println("button presed = " + Const.ButtonNames.REMOVE);

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.UP)){
            audioPreproc.selectPreviousSong();

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.DOWN)){
            audioPreproc.selectNextSong();


        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.MONO_STEREO)){
            System.out.println("button presed = " + Const.ButtonNames.MONO_STEREO);

        } else if (jbtn.getActionCommand().equals(Const.ButtonNames.MUTE)){
            System.out.println("button presed = " + Const.ButtonNames.MUTE);

        }


    }
}
