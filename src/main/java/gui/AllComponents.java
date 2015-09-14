package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;


/**
 *
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
public abstract class AllComponents extends JFrame implements GeneralWindow {

    protected JLabel jLabelFileName; //полное имя проигрываемого файла
    public JLabel jLabelPlaybackTime; //текущее время проигрывания
    public JLabel jLabelSepTime; //разделитель
    public JLabel jLabelTotalTime; //общее время файла
    public JLabel jLabelPlayerState; //состояние (play, pause, stop)
    public JLabel jLabelBitRate;
    public JLabel jLabelSampleRate;
    public JLabel jLabelMonoStereoSound;
    public JLabel jLabelFileFormat;
    public JLabel jLabelTitle;
    public JLabel jLabelAuthor;
    public JLabel jLabelAlbum;
    public JLabel jLabelGenre;
    public JLabel jLabelYear;
    public JLabel jLabelCommentLine1; //комментарии, могут быть в виде 1, 2 ,3 строк
    public JLabel jLabelCommentLine2;
    public JLabel jLabelCommentLine3;

    public JButton jbtnPlay;
    public JButton jbtPause;
    public JButton jbtnStop;
    public JButton jbtnPrev;
    public JButton jbtnNext;
    public JButton jbtnAdd;
    public JButton jbtnRemove;
    public JButton jbtnUp;
    public JButton jbtnDown;
    public JButton jbtnSetting;
    public JButton jbtnTest;

    public JToggleButton jtbtnMonoStereo; //принудиельный переход в режим "моно"
    public JToggleButton jtbtnMute; //выкл звук
    public JToggleButton jtbtnRandomPlaying; //играть в случайном порядке

    public JTextField jtfLiveSearch; //поиск по playlist

    public JSlider jslRewindProgress; //перемотка по треку
    public JSlider jslVolume; //изменение уровня громкости

    public JList jList1; // playlist
    public JScrollPane jScrollPane1; //подключение возможности скроллинга по playlist

    public JPanel jPanelInformation;  //
    public JPanel jPanelPlaylistAndDirection; //
    public JPanel jPanelVolAndProgress; //



    @Override
    public void createJComponents() {
        System.out.println("-createJComponents");
    }

    @Override
    public void setJPanels() {
        System.out.println("-setJPanels");
    }

    @Override
    public void setJCompProps() {
        System.out.println("-setJCompProps");
    }



    public JLabel getjLabelFileName() {
        return jLabelFileName;
    }

    public JLabel getjLabelPlaybackTime() {
        return jLabelPlaybackTime;
    }

    public JLabel getjLabelSepTime() {
        return jLabelSepTime;
    }

    public JLabel getjLabelTotalTime() {
        return jLabelTotalTime;
    }

    public JLabel getjLabelPlayerState() {
        return jLabelPlayerState;
    }

    public JLabel getjLabelBitRate() {
        return jLabelBitRate;
    }

    public JLabel getjLabelSampleRate() {
        return jLabelSampleRate;
    }

    public JLabel getjLabelMonoStereoSound() {
        return jLabelMonoStereoSound;
    }

    public JLabel getjLabelFileFormat() {
        return jLabelFileFormat;
    }

    public JLabel getjLabelTitle() {
        return jLabelTitle;
    }

    public JLabel getjLabelAuthor() {
        return jLabelAuthor;
    }

    public JLabel getjLabelAlbum() {
        return jLabelAlbum;
    }

    public JLabel getjLabelGenre() {
        return jLabelGenre;
    }

    public JLabel getjLabelYear() {
        return jLabelYear;
    }

    public JLabel getjLabelCommentLine1() {
        return jLabelCommentLine1;
    }

    public JLabel getjLabelCommentLine2() {
        return jLabelCommentLine2;
    }

    public JLabel getjLabelCommentLine3() {
        return jLabelCommentLine3;
    }

    public JButton getJbtnPlay() {
        return jbtnPlay;
    }

    public JButton getJbtPause() {
        return jbtPause;
    }

    public JButton getJbtnStop() {
        return jbtnStop;
    }

    public JButton getJbtnPrev() {
        return jbtnPrev;
    }

    public JButton getJbtnNext() {
        return jbtnNext;
    }

    public JButton getJbtnAdd() {
        return jbtnAdd;
    }

    public JButton getJbtnRemove() {
        return jbtnRemove;
    }

    public JButton getJbtnUp() {
        return jbtnUp;
    }

    public JButton getJbtnDown() {
        return jbtnDown;
    }

    public JButton getJbtnSetting() {
        return jbtnSetting;
    }

    public JButton getJbtnTest() {
        return jbtnTest;
    }

    public JToggleButton getJtbtnMonoStereo() {
        return jtbtnMonoStereo;
    }

    public JToggleButton getJtbtnMute() {
        return jtbtnMute;
    }

    public JToggleButton getJtbtnRandomPlaying() {
        return jtbtnRandomPlaying;
    }

    public JTextField getJtfLiveSearch() {
        return jtfLiveSearch;
    }

    public JSlider getJslRewindProgress() {
        return jslRewindProgress;
    }

    public JSlider getJslVolume() {
        return jslVolume;
    }

    public JList getjList1() {
        return jList1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JPanel getjPanelInformation() {
        return jPanelInformation;
    }

    public JPanel getjPanelPlaylistAndDirection() {
        return jPanelPlaylistAndDirection;
    }

    public JPanel getjPanelVolAndProgress() {
        return jPanelVolAndProgress;
    }
}
