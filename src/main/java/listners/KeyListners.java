package listners;

import app.Const;
import gui.MainFrameV1;
import player.AudioPreprocessor;
import utils.Search;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by max on 19.09.14.
 */
public class KeyListners extends KeyAdapter {

    private MainFrameV1 mainFrame;
    private AudioPreprocessor audioPreproc;
    private Search srch;


    public KeyListners(MainFrameV1 mainFrame) {
        this.mainFrame = mainFrame;
        srch = new Search(mainFrame);
    }

    public KeyListners(MainFrameV1 mainFrame, AudioPreprocessor audioPreproc) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        srch = new Search(mainFrame);
    }


    @Override
    public void keyPressed(KeyEvent e) {

//        определяем комбинацию нажатых клавиш
        int keyCode = e.getKeyCode();
        System.out.println("key code = " + keyCode);

//        проверяем какой это компонент
        if ( e.getSource() instanceof JTextField ){
            jTextFieldKeyPressed((JTextField) e.getSource(), keyCode);
        }

    }


    /**
     * Динамический поиск песен по playlist.
     * При вводе любой буквы в этом JTextField происходит
     * вызов метода поиска see {@link Search#searchInPlayList()} по plylist
     * @param jtf - ссылка на вызываемый компонет типа JTextField
     * @param keyCode - код нажатой клавиши
     */
    private void jTextFieldKeyPressed(JTextField jtf, int keyCode){
        if (jtf.getName().equals(Const.TextFieldProps.LIVE_SEARCH_NAME)) {
            if (keyCode == KeyEvent.VK_ENTER){
                audioPreproc.play(); // если нажата enter - воспроизв найденной песни
            } else {
                srch.searchInPlayList(); // если любая другая клаввиша (буквы, цифры) - поиск по playlist
            }
        }
    }



}
