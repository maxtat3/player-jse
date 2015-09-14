package listners;

import gui.MainFrame;
import player.AudioPreprocessor;
import utils.FileUtils;

/**
 * Created by max on 11.09.14.
 */
public class AllListners {

    private MainFrame mainFrame;
    private AudioPreprocessor audioPreproc;
    private FileUtils fileUtils;

    public AllListners(MainFrame mainFrame, AudioPreprocessor audioPreproc, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        this.fileUtils = fileUtils;
        setButtonsListners();
        setChangeListners();
        setKeyListners();
        setFocusAdapter();
    }


    /**
     * Устанавливаем слушатели действий на кнопки главной формы MainFrame
     */
    private ActionListners setButtonsListners(){
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

        mainFrame.getJbtnMonoStereo().addActionListener(bal);
        mainFrame.getJbtnMute().addActionListener(bal);

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
        KeyListners keyl = new KeyListners(mainFrame);

        mainFrame.getJtfLiveSearch().addKeyListener(keyl);
        mainFrame.getJtfTitle().addKeyListener(keyl);
        mainFrame.getjList1().addKeyListener(keyl);
    }

    private void setFocusAdapter(){
        FocusAdapter focus = new FocusAdapter(mainFrame);

        mainFrame.getJtfLiveSearch().addFocusListener(focus);
    }
}
