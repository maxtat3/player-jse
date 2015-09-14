package gui;

import app.Const;

import javax.swing.*;


/**
 * Created by max on 23.09.14.
 */
public class MainFrameV1 extends AllComponents {

    private JFileChooser jfch;
    private DefaultListModel playListModel;


    public MainFrameV1() {
        createJComponents();
        setJPanels();
        setJCompProps();

        jfch = addFileChooser();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Создаем все компоненты
     * JLabel
     * JButton
     * JToggleButton
     * JTextField
     * JSlider
     * JList
     * JPanel
     */
    @Override
    public void createJComponents() {
        // create JLabel
        jLabelFileName = new JLabel(); // full playing file name
        // === for informationPanel
        jLabelPlaybackTime = new JLabel();
        jLabelSepTime = new JLabel(); //разделитель
        jLabelTotalTime = new JLabel();
        jLabelPlayerState = new JLabel();
        // === from idTags
        jLabelBitRate = new JLabel();
        jLabelSampleRate = new JLabel();
        jLabelMonoStereoSound = new JLabel();
        jLabelFileFormat = new JLabel();
        // ===== advanced information from idTags
        jLabelTitle = new JLabel();
        jLabelAuthor = new JLabel();
        jLabelAlbum = new JLabel();
        jLabelGenre = new JLabel();
        jLabelYear = new JLabel();
        jLabelCommentLine1 = new JLabel();
        jLabelCommentLine2 = new JLabel();
        jLabelCommentLine3 = new JLabel();

        // create JButton
        // === playing directonary
        jbtnPlay = new JButton();
        jbtPause = new JButton();
        jbtnStop = new JButton();
        jbtnPrev = new JButton();
        jbtnNext = new JButton();
        // === playlist direction
        jbtnAdd = new JButton();
        jbtnRemove = new JButton();
        // === playlist navigation
        jbtnUp = new JButton();
        jbtnDown = new JButton();
//        jbtnDown1 = new JButton();
        // === other
        jbtnSetting = new JButton();
        jbtnTest = new JButton();

        // create JToggleButton
        jtbtnMute = new JToggleButton();
        jtbtnRandomPlaying = new JToggleButton();
        jtbtnMonoStereo = new JToggleButton();

        // create JTextField (for search songs in playlist)
        jtfLiveSearch = new JTextField();

        // create JSlider
        jslVolume = new JSlider();
        jslRewindProgress = new JSlider();

        // create JList (this is playlist)
        jList1 = new JList();
        jScrollPane1 = new JScrollPane();

        // create JPanel
        jPanelInformation = new JPanel();
        jPanelPlaylistAndDirection = new JPanel();
        jPanelVolAndProgress = new JPanel();
    }

    /**
     * Создаем панели, необходимые для размещения на них компонентов
     */
    @Override
    public void setJPanels() {
        setInformPanel(); // вывод всей информации о проигрываемой композиции
        setVolumeAndProgressPanel(); // размещение ползунков громкости и прокрутки (возм размещ доп комп)
        setDirectionPanel(); // основные элементы управления + plylist + поиск по playlist
        setGeneralPanel(); // системная компоновочная панель
    }

    /**
     * вывод всей информации о проигрываемой композиции
     */
    public void setInformPanel() {
        GroupLayout jPanelInformationLayout = new GroupLayout(jPanelInformation);
        jPanelInformation.setLayout(jPanelInformationLayout);
        jPanelInformationLayout.setHorizontalGroup(
                jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInformationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelInformationLayout.createSequentialGroup()
                                                .addComponent(jLabelPlaybackTime)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelSepTime)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelTotalTime)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelPlayerState))
                                        .addGroup(jPanelInformationLayout.createSequentialGroup()
                                                .addComponent(jLabelBitRate)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelSampleRate)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelMonoStereoSound)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelFileFormat))
                                        .addComponent(jLabelTitle)
                                        .addComponent(jLabelAuthor)
                                        .addComponent(jLabelAlbum)
                                        .addComponent(jLabelGenre)
                                        .addComponent(jLabelYear)
                                        .addComponent(jLabelCommentLine1)
                                        .addComponent(jLabelCommentLine2)
                                        .addComponent(jLabelCommentLine3))
                                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanelInformationLayout.setVerticalGroup(
                jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInformationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPlaybackTime)
                                        .addComponent(jLabelPlayerState)
                                        .addComponent(jLabelSepTime)
                                        .addComponent(jLabelTotalTime))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelBitRate)
                                        .addComponent(jLabelSampleRate)
                                        .addComponent(jLabelMonoStereoSound)
                                        .addComponent(jLabelFileFormat))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAuthor)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAlbum)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelGenre)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelYear)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCommentLine1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCommentLine2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCommentLine3)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelInformation.setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * размещение ползунков громкости и прокрутки
     * а также кнопки: моно\стерео, выкл. звук
     */
    public void setVolumeAndProgressPanel() {
        GroupLayout jPanelVolAndProgressLayout = new GroupLayout(jPanelVolAndProgress);
        jPanelVolAndProgress.setLayout(jPanelVolAndProgressLayout);
        jPanelVolAndProgressLayout.setHorizontalGroup(
                jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jslRewindProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
                                                .addComponent(jtbtnMonoStereo)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtbtnMute)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jslVolume, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelVolAndProgressLayout.setVerticalGroup(
                jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jslVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jtbtnMonoStereo)
                                                .addComponent(jtbtnMute)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jslRewindProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelVolAndProgress.setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * основные элементы управления + plylist + поиск по playlist
     */
    public void setDirectionPanel() {
        GroupLayout jPanelPlaylistAndDirectionLayout = new GroupLayout(jPanelPlaylistAndDirection);
        jPanelPlaylistAndDirection.setLayout(jPanelPlaylistAndDirectionLayout);
        jPanelPlaylistAndDirectionLayout.setHorizontalGroup(
                jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
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
                                                .addComponent(jtbtnRandomPlaying, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnSetting, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelPlaylistAndDirectionLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jtfLiveSearch, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jbtnTest, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnAdd, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnRemove, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanelPlaylistAndDirectionLayout.setVerticalGroup(
                jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jbtnSetting, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jbtnPlay, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbtPause, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbtnStop, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbtnPrev, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbtnNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jtbtnRandomPlaying, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
                                                .addComponent(jbtnAdd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnRemove, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnTest, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfLiveSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPlaylistAndDirection.setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * системная компоновочная панель
     */
    public void setGeneralPanel() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFileName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanelVolAndProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanelInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelPlaylistAndDirection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelFileName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelVolAndProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanelPlaylistAndDirection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    /**
     * Установка различных свойств для созданных графических компонентов
     * !!!!!!!!!!!!!!!!!!!! не забыть уст имена
     */
    @Override
    public void setJCompProps() {
        // -----------------
        // JLabel properties
        // -----------------
        jLabelFileName.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabelFileName.setText("Название проигрываемого файла: В.А. Моцарт - концерт №2 до-мажор.mp3"); //@_______Test

        jLabelPlaybackTime.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabelPlaybackTime.setText("125:35"); //@_______Test

        jLabelSepTime.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabelSepTime.setText(Const.LabelNames.SEPARATOR);

        jLabelTotalTime.setFont(new java.awt.Font("DejaVu Sans", 0, 20)); // NOI18N
        jLabelTotalTime.setText("135:31"); //@_______Test

        jLabelPlayerState.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabelPlayerState.setForeground(new java.awt.Color(102, 102, 102));
        jLabelPlayerState.setText(Const.LabelNames.PLAYER_STATE_PLAY); //@_______Test

        jLabelMonoStereoSound.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelMonoStereoSound.setText(Const.LabelNames.MONO); //@_______Test

        jLabelSampleRate.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelSampleRate.setText("44100 Hz"); //@_______Test

        jLabelBitRate.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelBitRate.setText("160 kbps"); //@_______Test

        jLabelFileFormat.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelFileFormat.setText("flac"); //@_______Test

        jLabelTitle.setText(Const.LabelNames.TITLE_HEADER);

        jLabelAuthor.setText(Const.LabelNames.AUTHOR_HEADER);

        jLabelAlbum.setText(Const.LabelNames.ALBUM_HEADER);

        jLabelGenre.setText(Const.LabelNames.GENRE_HEADER);

        jLabelYear.setText(Const.LabelNames.YEAR_HEADER);

        jLabelCommentLine1.setText(Const.LabelNames.COMMENT_HEADER);

        jLabelCommentLine2.setText("."); //@_______Test

        jLabelCommentLine3.setText("."); //@_______Test


        // ------------------
        // JButton properties
        // ------------------
        jbtnPlay.setText(Const.ButtonNames.PLAY);
        jbtnPlay.setName(Const.ButtonNames.PLAY);

        jbtPause.setText(Const.ButtonNames.PAUSE);
        jbtPause.setName(Const.ButtonNames.PAUSE);

        jbtnStop.setText(Const.ButtonNames.STOP);
        jbtnStop.setName(Const.ButtonNames.STOP);

        jbtnPrev.setText(Const.ButtonNames.PREV_SONG);
        jbtnPrev.setName(Const.ButtonNames.PREV_SONG);

        jbtnNext.setText(Const.ButtonNames.NEXT_SONG);
        jbtnNext.setName(Const.ButtonNames.NEXT_SONG);


        jbtnAdd.setText(Const.ButtonNames.ADD);
        jbtnAdd.setName(Const.ButtonNames.ADD);

        jbtnRemove.setText(Const.ButtonNames.REMOVE);
        jbtnRemove.setName(Const.ButtonNames.REMOVE);

        jbtnUp.setText(Const.ButtonNames.UP);
        jbtnUp.setName(Const.ButtonNames.UP);

        jbtnDown.setText(Const.ButtonNames.DOWN);
        jbtnDown.setName(Const.ButtonNames.DOWN);


        jtbtnRandomPlaying.setText(Const.ButtonNames.RANDOM_PLAYING);
        jtbtnRandomPlaying.setName(Const.ButtonNames.RANDOM_PLAYING);

        jtbtnMute.setText(Const.ButtonNames.MUTE);
        jtbtnMute.setName(Const.ButtonNames.MUTE);

        jtbtnMonoStereo.setText(Const.ButtonNames.MONO_STEREO);
        jtbtnMonoStereo.setName(Const.ButtonNames.MONO_STEREO);


        jbtnSetting.setText(Const.ButtonNames.SETTING);
        jbtnSetting.setName(Const.ButtonNames.SETTING);
        jbtnSetting.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N


        jbtnTest.setText("tst"); //@_______Test
        jbtnTest.setName("tst"); //@_______Test


        // ------------------
        // JTextfield properties
        // ------------------
        jtfLiveSearch.setText(Const.TextFieldTxt.LIVE_SEARCH_DEFAULT_TEXT);
        jtfLiveSearch.setName(Const.TextFieldTxt.LIVE_SEARCH_NAME);


        // ------------------
        // JSlider properties
        // ------------------
        jslVolume.setToolTipText(Const.SliderTxt.VOLUME_DEFAULT_TOOLTIP);
        jslVolume.setName(Const.SliderTxt.VOLUME_NAME);
        jslVolume.setMaximum(Const.SliderTxt.VOLUME_MAXVALUE);
        jslVolume.setValue(5);
        jslVolume.setMinorTickSpacing(0); // установка шага регулирования
        jslVolume.setSnapToTicks(true);

        jslRewindProgress.setToolTipText(Const.SliderTxt.REWIND_PROGRESS_DEFAULT_TOOLTIP);
        jslRewindProgress.setName(Const.SliderTxt.VOLUME_NAME);
        jslRewindProgress.setMaximum(Const.SliderTxt.REWIND_PROGRESS_MAXVALUE);
        jslRewindProgress.setValue(0); // начальное значение всегда = 0
        jslRewindProgress.setMinorTickSpacing(1); // установка шага регулирования
        jslRewindProgress.setSnapToTicks(true);


        // ------------------
        // JList properties
        // ------------------
//        jList1.setModel(new javax.swing.AbstractListModel() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public Object getElementAt(int i) { return strings[i]; }
//        });
        playListModel = new DefaultListModel();
        jList1.setModel(playListModel);
        jScrollPane1.setViewportView(jList1);



//        jbtnDown1.setText("dwn");

        pack();
    }


    /**
     * Добавляем возможность добавлять файлов при помощи диалога выбора
     */
    private JFileChooser addFileChooser() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(true);
        fc.setDialogTitle(Const.FileChooserTxt.DIALOG_TITLE);
        fc.setMultiSelectionEnabled(true);
        return fc;
    }


}
