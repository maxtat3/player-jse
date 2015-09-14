package gui;


import gui.jcompw.*;
import javax.swing.*;


/**
 * Используемые компоненты для построения gui
 * JLabel
 * JButton
 * JToggleButton
 * JTextField
 * JSlider
 * JList
 * JScrollPane
 * JPanel
 *
 * Created by max on 23.09.14.
 */
public  class AllJComp extends JFrame implements GeneralFrame {

    protected JLabel jLabelFileName; //полное имя проигрываемого файла
    protected JLabel jLabelPlaybackTime; //текущее время проигрывания
    protected JLabel jLabelSepTime; //разделитель
    protected JLabel jLabelTotalTime; //общее время файла
    protected JLabel jLabelPlayerState; //состояние (play, pause, stop)
    protected JLabel jLabelBitRate;
    protected JLabel jLabelSampleRate;
    protected JLabel jLabelMonoStereoSound;
    protected JLabel jLabelFileFormat;
    protected JLabel jLabelTitle;
    protected JLabel jLabelAuthor;
    protected JLabel jLabelAlbum;
    protected JLabel jLabelGenre;
    protected JLabel jLabelYear;
    protected JLabel jLabelCommentLine1; //комментарии, могут быть в виде 1, 2 ,3 строк
    protected JLabel jLabelCommentLine2;
    protected JLabel jLabelCommentLine3;

    protected JButton jbtnPlay;
    protected JButton jbtPause;
    protected JButton jbtnStop;
    protected JButton jbtnPrev;
    protected JButton jbtnNext;
    protected JButton jbtnAdd;
    protected JButton jbtnRemove;
    protected JButton jbtnUp;
    protected JButton jbtnDown;
    protected JButton jbtnSetting;
    protected JButton jbtnTest;

    protected JToggleButton jtbtnMonoStereo; //принудиельный переход в режим "моно"
    protected JToggleButton jtbtnMute; //выкл звук
    protected JToggleButton jtbtnRandomPlaying; //играть в случайном порядке

    protected JTextField jtfLiveSearch; //поиск по playlist

    protected JSlider jslRewindProgress; //перемотка по треку
    protected JSlider jslVolume; //изменение уровня громкости

    protected JList jList1; // playlist
    protected JScrollPane jScrollPane1; //подключение возможности скроллинга по playlist

    protected JPanel jPanelInformation;  //
    protected JPanel jPanelPlaylistAndDirection; //
    protected JPanel jPanelVolAndProgress; //

    protected DefaultListModel playListModel;


    @Override
    public void createJComponents() {
    }

    @Override
    public void setJPanels() {
    }

    @Override
    public void setJCompProps() {
    }


//    ============== JLabel ==============

    public JLabelW getjLabelFileName() {
        return new JLabelW(this.jLabelFileName);
    }

    public JLabelW getjLabelPlaybackTime() {
        return new JLabelW(this.jLabelPlaybackTime);
    }

    public JLabelW getjLabelSepTime() {
        return new JLabelW(this.jLabelSepTime);
    }

    public JLabelW getjLabelTotalTime() {
        return new JLabelW(this.jLabelTotalTime);
    }

    public JLabelW getjLabelPlayerState() {
        return new JLabelW(this.jLabelPlayerState);
    }

    public JLabelW getjLabelBitRate() {
        return new JLabelW(this.jLabelBitRate);
    }

    public JLabelW getjLabelSampleRate() {
        return new JLabelW(this.jLabelSampleRate);
    }

    public JLabelW getjLabelMonoStereoSound() {
        return new JLabelW(this.jLabelMonoStereoSound);
    }

    public JLabelW getjLabelFileFormat() {
        return new JLabelW(this.jLabelFileFormat);
    }

    public JLabelW getjLabelTitle() {
        return new JLabelW(this.jLabelTitle);
    }

    public JLabelW getjLabelAuthor() {
        return new JLabelW(this.jLabelAuthor);
    }

    public JLabelW getjLabelAlbum() {
        return new JLabelW(this.jLabelAlbum);
    }

    public JLabelW getjLabelGenre() {
        return new JLabelW(this.jLabelGenre);
    }

    public JLabelW getjLabelYear() {
        return new JLabelW(this.jLabelYear);
    }

    public JLabelW getjLabelCommentLine1() {
        return new JLabelW(this.jLabelCommentLine1);
    }

    public JLabelW getjLabelCommentLine2() {
        return new JLabelW(this.jLabelCommentLine2);
    }

    public JLabelW getjLabelCommentLine3() {
        return new JLabelW(this.jLabelCommentLine3);
    }

//    ============== JButton ==============

    public JButtonW getJbtnPlay() {
        return new JButtonW(this.jbtnPlay);
    }

    public JButtonW getJbtPause() {
        return new JButtonW(this.jbtPause);
    }

    public JButtonW getJbtnStop() {
        return new JButtonW(this.jbtnStop);
    }

    public JButtonW getJbtnPrev() {
        return new JButtonW(this.jbtnPrev);
    }

    public JButtonW getJbtnNext() {
        return new JButtonW(this.jbtnNext);
    }

    public JButtonW getJbtnAdd() {
        return new JButtonW(this.jbtnAdd);
    }

    public JButtonW getJbtnRemove() {
        return new JButtonW(this.jbtnRemove);
    }

    public JButtonW getJbtnUp() {
        return new JButtonW(this.jbtnUp);
    }

    public JButtonW getJbtnDown() {
        return new JButtonW(this.jbtnDown);
    }

    public JButtonW getJbtnSetting() {
        return new JButtonW(this.jbtnSetting);
    }

    public JButtonW getJbtnTest() {
        return new JButtonW(this.jbtnTest);
    }

//    ============== JToggleButtons ==============

    public JToggleButtonW getJtbtnMonoStereo() {
        return new JToggleButtonW(this.jtbtnMonoStereo);
    }

    public JToggleButtonW getJtbtnMute() {
        return new JToggleButtonW(this.jtbtnMute);
    }

    public JToggleButtonW getJtbtnRandomPlaying() {
        return new JToggleButtonW(this.jtbtnRandomPlaying);
    }

//    ============== JTextField ==============

    public JTextFieldW getJtfLiveSearch() {
        return new JTextFieldW(this.jtfLiveSearch);
    }

//    ============== JSlider ==============

    public JSliderW getJslRewindProgress() {
        return new JSliderW(this.jslRewindProgress);
    }

    public JSliderW getJslVolume() {
        return new JSliderW(this.jslVolume);
    }

//    ============== JList ==============

    public JListW getjList1() {
        return new JListW(this.jList1);
    }

//    ============== JScrollPane ==============

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }


//    ============== DefaultListModel ==============
    public DefaultListModel getPlayListModel() {
        return playListModel;
    }
}
