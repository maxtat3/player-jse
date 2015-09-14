package app;

import gui.MainFrameV1;
import gui.MainFrameV2;
import listners.AllListners;
import player.AudioPreprocessor;
import utils.FileUtils;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Created by max on 02.09.14.
 */
public class App {

	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


//        MainFrameV1 mainFrameV1 = new MainFrameV1();
//        mainFrameV1.setTitle(Const.PLAYER_VERSION);
//        mainFrameV1.setVisible(true);
//
//		FileUtils fileUtils = new FileUtils(mainFrameV1);
//
//        AudioPreprocessor audioPreproc = new AudioPreprocessor(mainFrameV1);
//
//        new AllListners(mainFrameV1, audioPreproc, fileUtils);




		MainFrameV2 mainFrameV2 = new MainFrameV2();
		mainFrameV2.setTitle(Const.PLAYER_VERSION);
		mainFrameV2.setVisible(true);

		FileUtils fileUtils = new FileUtils(mainFrameV2);

		AudioPreprocessor audioPreproc = new AudioPreprocessor(mainFrameV2);

		new AllListners(mainFrameV2, audioPreproc, fileUtils);



	}

}
