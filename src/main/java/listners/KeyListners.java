package listners;

import gui.MainFrame;
import utils.Search;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by max on 19.09.14.
 */
public class KeyListners extends KeyAdapter {

    private static final String JTF_NAME_CONST = "w4jn4erf6rlsn";
    private static final String JLIST_NAME_CONST = "jsdkjdskk3fw";

    private MainFrame mainFrame;
    private Search srch;
    private JTextField jtf;
    private JList jList;


    public KeyListners(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        srch = new Search(mainFrame);
    }


//    @Override
//    public void keyPressed(KeyEvent e) {
//        if ( !(e.getSource() instanceof JTextField) ){
//            return;
//        }
//
//        int keyCode = e.getKeyCode();
//        System.out.println("key code = " + keyCode);
//
//        JTextField jtf = (JTextField)e.getSource();
//
//        if (jtf.getName().equals("liveSearch")){
//            srch.searchInPlayList();
//        }
//    }




    @Override
    public void keyPressed(KeyEvent e) {
        jtf = new JTextField();
        jList = new JList();
        jtf.setName(JTF_NAME_CONST);
        jList.setName(JLIST_NAME_CONST);

//        проверяем какой это компонент
        if ( e.getSource() instanceof JTextField ){
             jtf = (JTextField)e.getSource();
            System.out.println("-jtf");
        } else if ( e.getSource() instanceof JList){
            System.out.println("-jlist");
             jList = (JList) e.getSource();
        } else {
            System.out.println("not");
        }

//        определяем комбинацию нажатых клавиш
        int keyCode = e.getKeyCode();
        System.out.println("key code = " + keyCode);


//        выбираем из нескольких компонентов (если их несколько) какой именно был нажат
        if (jtf.getName().equals("liveSearch")){
            System.out.println("jtf - livesearch");

        } else if (jList.getName().equals("jlist_playlist")){
            if ( e.isControlDown() && (keyCode == KeyEvent.VK_P) ) {
                System.out.println("jlist - playlist");
            }
        } else if (jtf.getName().equals("title")){
            System.out.println("jtf - title");
        }

        jtf = null;
        jList = null;
    }
}
