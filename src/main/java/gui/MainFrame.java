package gui;

import javax.swing.*;

/**
 * Created by max on 02.09.14.
 */

public class MainFrame extends JFrame {

    private JLabel jLabel8;
    private JLabel jLabelBitRate;
    private JLabel jLabelFileFormat;
    private JLabel jLabelFileName;
    private JLabel jLabelMonoStereoSound;
    private JLabel jLabelPlaybackTime;
    private JLabel jLabelPlayerState;
    private JLabel jLabelSampleRate;
    private JLabel jLabelTotalTime;
    private JList jList1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JButton jbtPause;
    private JButton jbtnAdd;
    private JButton jbtnDown;
    private JButton jbtnDown1;
    private JButton jbtnNext;
    private JButton jbtnPlay;
    private JButton jbtnPrev;
    private JButton jbtnRemove;
    private JButton jbtnStop;
    private JButton jbtnTest;
    private JButton jbtnUp;
    private JSlider jslRewindProgress;
    private JSlider jslVolume;
    private JTextField jtfAlbum;
    private JTextField jtfAuthor;
    private JTextField jtfGenre;
    private JTextField jtfLiveSearch;
    private JButton jbtnMonoStereo;
    private JButton jbtnMute;
    private JTextField jtfTitle;
    private JTextField jtfYear;

    private JFileChooser jfc;
    private DefaultListModel playlistModel;


    public MainFrame() {
        initGUIComponents();
        setPropertiesForJSliders();
        setPropertiesForJtfLiveSearch();
        playlistModel = setDefaultPlayListModel();
        jfc = addFileChooser();
    }


    public JLabel getjLabel8() {
        return jLabel8;
    }

    public JLabel getjLabelBitRate() {
        return jLabelBitRate;
    }

    public JLabel getjLabelFileFormat() {
        return jLabelFileFormat;
    }

    public JLabel getjLabelFileName() {
        return jLabelFileName;
    }

    public JLabel getjLabelMonoStereoSound() {
        return jLabelMonoStereoSound;
    }

    public JLabel getjLabelPlaybackTime() {
        return jLabelPlaybackTime;
    }

    public JLabel getjLabelPlayerState() {
        return jLabelPlayerState;
    }

    public JLabel getjLabelSampleRate() {
       return jLabelSampleRate;
    }

    public JLabel getjLabelTotalTime() {
        return jLabelTotalTime;
    }

    public JList getjList1() {
        return jList1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JButton getJbtPause() {
        return jbtPause;
    }

    public JButton getJbtnAdd() {
        return jbtnAdd;
    }

    public JButton getJbtnDown() {
        return jbtnDown;
    }

    public JButton getJbtnDown1() {
        return jbtnDown1;
    }

    public JButton getJbtnNext() {
        return jbtnNext;
    }

    public JButton getJbtnPlay() {
        return jbtnPlay;
    }

    public JButton getJbtnPrev() {
        return jbtnPrev;
    }

    public JButton getJbtnRemove() {
        return jbtnRemove;
    }

    public JButton getJbtnStop() {
        return jbtnStop;
    }

    public JButton getJbtnTest() {
        return jbtnTest;
    }

    public JButton getJbtnUp() {
        return jbtnUp;
    }

    public JSlider getJslRewindProgress() {
        return jslRewindProgress;
    }

    public JSlider getJslVolume() {
        return jslVolume;
    }

    public JTextField getJtfAlbum() {
        return jtfAlbum;
    }

    public JTextField getJtfAuthor() {
        return jtfAuthor;
    }

    public JTextField getJtfGenre() {
        return jtfGenre;
    }

    public JTextField getJtfLiveSearch() {
        return jtfLiveSearch;
    }

    public JButton getJbtnMonoStereo() {
        return jbtnMonoStereo;
    }

    public JButton getJbtnMute() {
        return jbtnMute;
    }

    public JTextField getJtfTitle() {
        return jtfTitle;
    }

    public JTextField getJtfYear() {
        return jtfYear;
    }

    public JFileChooser getJfc() {
        return jfc;
    }

    public DefaultListModel getPlaylistModel() {
        return playlistModel;
    }


    /**
     * построение GUI
     * Код сгенерирован в редакторе форм NetBeans
     * v0.1
     */
    private void initGUIComponents() {
        jbtnDown1 = new JButton();
        jLabelPlaybackTime = new JLabel();
        jLabelBitRate = new JLabel();
        jLabelSampleRate = new JLabel();
        jLabelMonoStereoSound = new JLabel();
        jLabelFileFormat = new JLabel();
        jLabelFileName = new JLabel();
        jtfTitle = new JTextField();
        jtfAuthor = new JTextField();
        jtfAlbum = new JTextField();
        jtfGenre = new JTextField();
        jtfYear = new JTextField();
        jbtnMonoStereo = new JButton();
        jbtnMute = new JButton();
        jslVolume = new JSlider();
        jslRewindProgress = new JSlider();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList();
        jbtnAdd = new JButton();
        jbtnRemove = new JButton();
        jbtnPlay = new JButton();
        jbtPause = new JButton();
        jbtnStop = new JButton();
        jbtnPrev = new JButton();
        jbtnNext = new JButton();
        jtfLiveSearch = new JTextField();
        jSeparator1 = new JSeparator();
        jbtnDown = new JButton();
        jbtnUp = new JButton();
        jLabelPlayerState = new JLabel();
        jbtnTest = new JButton();
        jLabel8 = new JLabel();
        jLabelTotalTime = new JLabel();

        jbtnDown1.setText("dwn");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelPlaybackTime.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabelPlaybackTime.setText("125:35");

        jLabelBitRate.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelBitRate.setText("160 kbps");

        jLabelSampleRate.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelSampleRate.setText("44100 Hz");

        jLabelMonoStereoSound.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelMonoStereoSound.setText("stereo");

        jLabelFileFormat.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelFileFormat.setText("flac");

        jLabelFileName.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabelFileName.setText("Название проигрываемого файла: В.А. Моцарт - концерт №2 до-мажор.mp3");

        jtfTitle.setText("title");
        jtfTitle.setName("title");

        jtfAuthor.setText("author");

        jtfAlbum.setText("album");

        jtfGenre.setText("жанр");

        jtfYear.setText("year");

        jbtnMonoStereo.setText("mono");

        jbtnMute.setText("mute");

        jslVolume.setToolTipText("Громкость");

        jslRewindProgress.setToolTipText("Прокрутка композиции");

//        Этот код не будет действует когда мы переопределяем модель
//        jList1.setModel(new javax.swing.AbstractListModel() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public Object getElementAt(int i) { return strings[i]; }
//        });
        jList1.setName("jlist_playlist");
        jScrollPane1.setViewportView(jList1);

        jbtnAdd.setText("add");

        jbtnRemove.setText("rm");

        jbtnPlay.setText("play");

        jbtPause.setText("pause");

        jbtnStop.setText("stop");

        jbtnPrev.setText("prev");

        jbtnNext.setText("next");

        jtfLiveSearch.setText("Поиск по playlists");

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        jbtnDown.setText("dwn");

        jbtnUp.setText("up");

        jLabelPlayerState.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabelPlayerState.setForeground(new java.awt.Color(102, 102, 102));
        jLabelPlayerState.setText("PLAY");

        jbtnTest.setText("tst");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabel8.setText("/");

        jLabelTotalTime.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabelTotalTime.setText("135:31");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFileName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jtfYear)
                                                        .addComponent(jtfGenre)
                                                        .addComponent(jtfAlbum)
                                                        .addComponent(jtfAuthor)
                                                        .addComponent(jtfTitle, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelPlaybackTime)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelTotalTime)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabelPlayerState))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelBitRate)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelSampleRate)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelMonoStereoSound)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelFileFormat))
                                                        .addComponent(jslRewindProgress, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jbtnMonoStereo)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jbtnMute)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jslVolume, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jtfLiveSearch)
                                                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jbtnAdd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jbtnRemove, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jbtnTest, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jbtnPlay, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbtPause)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbtnStop, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbtnPrev, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jbtnNext, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelFileName)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabelPlaybackTime)
                                                                .addComponent(jLabelPlayerState)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabelTotalTime))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabelBitRate)
                                                                .addComponent(jLabelSampleRate)
                                                                .addComponent(jLabelMonoStereoSound)
                                                                .addComponent(jLabelFileFormat)))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jbtnPlay, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtPause, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnStop, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnPrev, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jtfTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtfAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtfAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtfGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jtfYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jslVolume, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jbtnMute)
                                                                                .addComponent(jbtnMonoStereo))))
                                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfLiveSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jslRewindProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbtnAdd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnRemove, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnTest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }


    /**
     * Добавляем возможность добавлять файлы при помощи диалога выбора файла
     */
    private JFileChooser addFileChooser() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(true);
        fc.setDialogTitle("Add songs(s)");
        fc.setMultiSelectionEnabled(true);
        return fc;
    }


    /**
     * Устанавливаем модель для plylist-а
     */
    private DefaultListModel setDefaultPlayListModel() {
        DefaultListModel defPlaylistModel = new DefaultListModel();
        getjList1().setModel(defPlaylistModel);
        return defPlaylistModel;
    }

    /**
     * Устанавливаем различные параметры для всех компонентов JSlider
     */
    private void setPropertiesForJSliders(){
       // для слайдера - громкость
        getJslVolume().setName("Громкость"); // имя нужно для определения слушателем, какой слайдер был вызван
        getJslVolume().setToolTipText("Изменение громкости");
        getJslVolume().setMaximum(200);
        getJslVolume().setValue(5);
        getJslVolume().setMinorTickSpacing(0); // установка шага регулирования
        getJslVolume().setSnapToTicks(true); //

        // для слайдера - прокрутка песни
        getJslRewindProgress().setName("Прокрутка композиции");
        getJslRewindProgress().setToolTipText("ползунок для прокрутки композиции");
        getJslRewindProgress().setMaximum(1000);
        getJslRewindProgress().setValue(0);
        getJslRewindProgress().setMinorTickSpacing(1);
        getJslRewindProgress().setSnapToTicks(true);
    }


    private void setPropertiesForJtfLiveSearch() {
        getJtfLiveSearch().setText("live search in playlist");
        getJtfLiveSearch().setName("liveSearch");
    }
}
