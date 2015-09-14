package listners;

import app.Const;
import gui.AllJComp;
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

    private AllJComp mainFrame;
    private AudioPreprocessor audioPreproc;
    private Search srch;


    public KeyListners(AllJComp mainFrame) {
        this.mainFrame = mainFrame;
        srch = new Search(mainFrame);
    }

    public KeyListners(AllJComp mainFrame, AudioPreprocessor audioPreproc) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        srch = new Search(mainFrame);
    }


    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode(); // получаем код нажатой клавиши
//        System.out.println("key code = " + keyCode);

//        проверяем какой это компонент
        if ( e.getSource() instanceof JTextField ){
            jTextFieldKeyPressed((JTextField) e.getSource(), keyCode);
        }
//        else if (e.getSource() instanceof JList){
//            if ( ((JList)e.getSource()).getName().equals(Const.ListProps.PLAYLIST_NAME) ) {
//                if (keyCode == KeyEvent.VK_ENTER){
//                    System.out.println("press ENTER in playlist");
//                }
//            }
//        }

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
