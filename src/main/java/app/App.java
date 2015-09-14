package app;

import gui.MainFrameV1;
import listners.AllListners;
import player.AudioPreprocessor;
import utils.FileUtils;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Created by max on 02.09.14.
 */
public class App {


//    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(new NimbusLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
//
//        FileUtils fileUtils = new FileUtils(mainFrame);
//
//        AudioPreprocessor audioPreproc = new AudioPreprocessor(mainFrame, fileUtils);
//
//        new AllListners(mainFrame, audioPreproc, fileUtils);
//
//
//    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MainFrameV1 mainFrameV1 = new MainFrameV1();
        mainFrameV1.setTitle("player v0.7");
        mainFrameV1.setVisible(true);

        FileUtils fileUtils = new FileUtils(mainFrameV1);

        AudioPreprocessor audioPreproc = new AudioPreprocessor(mainFrameV1);

        new AllListners(mainFrameV1, audioPreproc, fileUtils);

    }

}
