package listners;

import gui.AllJComp;
import gui.MainFrameV1;
import player.AudioPreprocessor;
import utils.FileUtils;

import java.awt.*;


/**
 * Created by max on 11.09.14.
 */
public class AllListners {

    private AllJComp mainFrame;
    private AudioPreprocessor audioPreproc;
    private FileUtils fileUtils;


    public AllListners(AllJComp mainFrame, AudioPreprocessor audioPreproc, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.audioPreproc = audioPreproc;
        this.fileUtils = fileUtils;
        setActionListners();
        setChangeListners();
        setKeyListners();
        setFocusAdapter();
        setPlaylistDnDSupport();
        setWheelMouse();
        setMouseListner();
    }


    /**
     * Слушатели действий кнопок JButton
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

    /**
     * Обработка hot keys для главной формы
     */
    private void setKeyListners(){
        mainFrame.getJtfLiveSearch().addKeyListener(new KeyListners(mainFrame, audioPreproc));

        KeyboardFocusManager keybrdfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keybrdfm.addKeyEventDispatcher(new KeyDispatcher(mainFrame, audioPreproc, fileUtils));
    }

    /**
     * Обработка фокуса компонента
     */
    private void setFocusAdapter(){
        FocusAdapter focus = new FocusAdapter(mainFrame);

        mainFrame.getJtfLiveSearch().addFocusListener(focus);
    }

    /**
     * Поддержка drag-and-drop
     * (Используется для playlist)
     */
    private void setPlaylistDnDSupport() {
        new DnD(mainFrame.getjList1(), fileUtils);

    }

    /**
     * Изменение состояния компонента при помощи прокрутки колесика мыши
     * (Используется для изменения громкости)
     */
    private void setWheelMouse() {
        WheelMouseListner whl = new WheelMouseListner(mainFrame, audioPreproc);

        mainFrame.getJslVolume().addMouseWheelListener(whl);
    }

    private void setMouseListner(){
        MouseListner mouseList = new MouseListner(audioPreproc);

        mainFrame.getjList1().addMouseListener(mouseList);
    }

}
