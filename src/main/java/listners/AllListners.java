package listners;

import gui.MainFrameV1;
import player.AudioPreprocessor;
import utils.FileUtils;

import java.awt.*;

/**
 * Created by max on 11.09.14.
 */
public class AllListners {

    private MainFrameV1 mainFrame;
    private AudioPreprocessor audioPreproc;
    private FileUtils fileUtils;

    public AllListners(MainFrameV1 mainFrame, AudioPreprocessor audioPreproc, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        this.fileUtils = fileUtils;
        setActionListners();
        setChangeListners();
        setKeyListners();
        setFocusAdapter();
    }


    /**
     * Устанавливаем слушатели действий на кнопки главной формы MainFrame
     */
    private ActionListners setActionListners() {
        ActionListners bal = new ActionListners(audioPreproc, fileUtils);

        mainFrame.getJbtnPlay().addActionListener(bal);
        mainFrame.getJbtPause().addActionListener(bal);
        mainFrame.getJbtnStop().addActionListener(bal);
        mainFrame.getJbtnPrev().addActionListener(bal);
        mainFrame.getJbtnNext().addActionListener(bal);

        mainFrame.getJbtnAdd().addActionListener(bal);
        mainFrame.getJbtnRemove().addActionListener(bal);
        mainFrame.getJbtnUp().addActionListener(bal);
        mainFrame.getJbtnDown().addActionListener(bal);
        mainFrame.getJbtnTest().addActionListener(bal);

        mainFrame.getJtbtnMonoStereo().addActionListener(bal);
        mainFrame.getJtbtnMute().addActionListener(bal);

        return bal;
    }

    /**
     * Слушатели изменения состояния (ChangeListener)
     * Это нужно для определения, состояние какого компонета было изменено
     * в слушателе событий ChangeListner
     */
    private void setChangeListners(){
        ChangeListners chl = new ChangeListners(mainFrame, audioPreproc);

        mainFrame.getJslVolume().addChangeListener(chl);
        mainFrame.getJslRewindProgress().addChangeListener(chl);
    }

    private void setKeyListners(){
        mainFrame.getJtfLiveSearch().addKeyListener(new KeyListners(mainFrame, audioPreproc));

        KeyboardFocusManager keybrdfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keybrdfm.addKeyEventDispatcher(new KeyDispatcher(mainFrame, audioPreproc, fileUtils));
    }

    private void setFocusAdapter(){
        FocusAdapter focus = new FocusAdapter(mainFrame);

        mainFrame.getJtfLiveSearch().addFocusListener(focus);
    }
}
