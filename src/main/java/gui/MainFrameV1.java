package gui;

import app.Const;

import javax.swing.*;
import java.awt.*;


/**
 * Created by max on 23.09.14.
 */
public class MainFrameV1 extends AllJComp {

    public MainFrameV1() {
        createJComponents();
        setJPanels();
        setJCompProps();

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


        // create playlist model, for main playlist this player
        playListModel = new DefaultListModel();
    }

    /**
     * Создаем панели, и размещаем на них компоненты
     */
    @Override
    public void setJPanels() {
        setInformPanel(); // вывод всей информации о проигрываемой композиции
        setVolumeAndProgressPanel(); // размещение ползунков громкости и прокрутки (возм размещ доп комп)
        setDirectionPanel(); // основные элементы управления + plylist + поиск по playlist
        setGeneralPanel(); // системная компоновочная панель
    }

    /**
     * информ. панель - вывод всей информации о проигрываемой композиции
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
     * панель для размещения ползунков громкости и прокрутки
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
     * панель для размещения основных элементов управления + plylist + поиск по playlist
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
                                                        .addComponent(jScrollPane1, Const.Size.SCROLL_PANE_WIDTH, Const.Size.SCROLL_PANE_WIDTH, Const.Size.SCROLL_PANE_WIDTH))  //добавлены размеры из Const
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
                                                .addComponent(jScrollPane1, Const.Size.SCROLL_PANE_HEIGHT, Const.Size.SCROLL_PANE_HEIGHT, Const.Size.SCROLL_PANE_HEIGHT) //добавлены размеры из Const
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfLiveSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPlaylistAndDirection.setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * системная компоновочная панель
     * Здесь также добавлена аозможность изменения размеров всех панелей
     * Это делается из see {@link Const.Size}
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
                                                        .addComponent(jPanelVolAndProgress, Const.Size.PANEL_VOLPROGRESS_WIDTH, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_VOLPROGRESS_WIDTH) //добавлены размеры из Const
                                                        .addComponent(jPanelInformation, Const.Size.PANEL_INFORM_WIDTH, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_INFORM_WIDTH))  //добавлены размеры из Const
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelPlaylistAndDirection, Const.Size.PANEL_PLAYLISTDIR_WIDTH, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_PLAYLISTDIR_WIDTH) //добавлены размеры из Const
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
                                                .addComponent(jPanelInformation, Const.Size.PANEL_INFORM_HEIGHT, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_INFORM_HEIGHT) //добавлены размеры из Const
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelVolAndProgress, Const.Size.PANEL_VOLPROGRESS_HEIGHT, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_VOLPROGRESS_HEIGHT)) //добавлены размеры из Const
                                        .addComponent(jPanelPlaylistAndDirection, Const.Size.PANEL_PLAYLISTDIR_HEIGHT, GroupLayout.DEFAULT_SIZE, Const.Size.PANEL_PLAYLISTDIR_HEIGHT)) //добавлены размеры из Const
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    /**
     * Установка различных свойств для созданных графических компонентов
     */
    @Override
    public void setJCompProps() {
        // -----------------
        // JLabel properties
        // -----------------
        jLabelFileName.setFont( new Font(Const.Font.DEJAVU_SANS, Font.PLAIN, 14) ); // NOI18N
        jLabelFileName.setText(Const.LabelProps.NOT_SONG);

        jLabelPlaybackTime.setFont( new Font(Const.Font.DEJAVU_SANS, Font.PLAIN, 20) ); // NOI18N
        jLabelPlaybackTime.setText(Const.SpecSym.NOT_TIME);

        jLabelSepTime.setFont( new Font(Const.Font.DEJAVU_SANS, Font.PLAIN, 20) ); // NOI18N
        jLabelSepTime.setText(Const.SpecSym.SEPARATOR);

        jLabelTotalTime.setFont(new Font(Const.Font.DEJAVU_SANS, Font.PLAIN, 20)); // NOI18N
        jLabelTotalTime.setText(Const.SpecSym.NOT_TIME);

        jLabelPlayerState.setFont(new Font(Const.Font.DEJAVU_SANS, Font.BOLD, 18)); // NOI18N
        jLabelPlayerState.setText(Const.SpecSym.DOT);
        jLabelPlayerState.setForeground(new Color(Const.Color.GREY)); // default color

        jLabelMonoStereoSound.setFont(new Font(Const.Font.DEJAVU_SANS, Font.BOLD, 14)); // NOI18N
        jLabelMonoStereoSound.setText(Const.SpecSym.DOT);

        jLabelSampleRate.setFont(new Font(Const.Font.DEJAVU_SANS, Font.BOLD, 14)); // NOI18N
        jLabelSampleRate.setText(Const.SpecSym.DOT);

        jLabelBitRate.setFont(new Font(Const.Font.DEJAVU_SANS, Font.BOLD, 14)); // NOI18N
        jLabelBitRate.setText(Const.SpecSym.DOT);

        jLabelFileFormat.setFont(new Font(Const.Font.DEJAVU_SANS, Font.BOLD, 14)); // NOI18N
        jLabelFileFormat.setText(Const.SpecSym.DOT);

        jLabelTitle.setText(Const.LabelProps.TITLE_HEADER); //default value, view in start app

        jLabelAuthor.setText(Const.LabelProps.AUTHOR_HEADER); //default value, view in start app

        jLabelAlbum.setText(Const.LabelProps.ALBUM_HEADER); //default value, view in start app

        jLabelGenre.setText(Const.LabelProps.GENRE_HEADER); //default value, view in start app

        jLabelYear.setText(Const.LabelProps.YEAR_HEADER); //default value, view in start app

        jLabelCommentLine1.setText(Const.LabelProps.COMMENT_HEADER); //default value, view in start app

        jLabelCommentLine2.setText(Const.SpecSym.DOT);

        jLabelCommentLine3.setText(Const.SpecSym.DOT);


        // ------------------
        // JButton properties
        // ------------------
        jbtnPlay.setText(Const.ButtonProps.PLAY);
        jbtnPlay.setName(Const.ButtonProps.PLAY);

        jbtPause.setText(Const.ButtonProps.PAUSE);
        jbtPause.setName(Const.ButtonProps.PAUSE);

        jbtnStop.setText(Const.ButtonProps.STOP);
        jbtnStop.setName(Const.ButtonProps.STOP);

        jbtnPrev.setText(Const.ButtonProps.PREV_SONG);
        jbtnPrev.setName(Const.ButtonProps.PREV_SONG);

        jbtnNext.setText(Const.ButtonProps.NEXT_SONG);
        jbtnNext.setName(Const.ButtonProps.NEXT_SONG);


        jbtnAdd.setText(Const.ButtonProps.ADD);
        jbtnAdd.setName(Const.ButtonProps.ADD);

        jbtnRemove.setText(Const.ButtonProps.REMOVE);
        jbtnRemove.setName(Const.ButtonProps.REMOVE);

        jbtnUp.setText(Const.ButtonProps.UP);
        jbtnUp.setName(Const.ButtonProps.UP);

        jbtnDown.setText(Const.ButtonProps.DOWN);
        jbtnDown.setName(Const.ButtonProps.DOWN);

        // JToggleButton
        jtbtnRandomPlaying.setText(Const.ButtonProps.RANDOM_PLAYING);
        jtbtnRandomPlaying.setName(Const.ButtonProps.RANDOM_PLAYING);

        jtbtnMute.setText(Const.ButtonProps.MUTE);
        jtbtnMute.setName(Const.ButtonProps.MUTE);

        jtbtnMonoStereo.setText(Const.ButtonProps.MONO_STEREO);
        jtbtnMonoStereo.setName(Const.ButtonProps.MONO_STEREO);
        // ------------

        jbtnSetting.setText(Const.ButtonProps.SETTING);
        jbtnSetting.setName(Const.ButtonProps.SETTING);
        jbtnSetting.setFont(new Font(Const.Font.DEJAVU_SANS, Font.ITALIC, 12)); // NOI18N

        // TODO - имя для тестовой кнопки
        jbtnTest.setText("tst");
        jbtnTest.setName("tst");


        // ------------------
        // JTextfield properties
        // ------------------
        jtfLiveSearch.setText(Const.TextFieldProps.LIVE_SEARCH_DEFAULT_TEXT);
        jtfLiveSearch.setName(Const.TextFieldProps.LIVE_SEARCH_NAME);


        // ------------------
        // JSlider properties
        // ------------------
        jslVolume.setToolTipText(Const.SliderProps.VOLUME_DEFAULT_TOOLTIP);
        jslVolume.setName(Const.SliderProps.VOLUME_NAME);
        jslVolume.setMaximum(Const.SliderProps.VOLUME_MAXVALUE);
        jslVolume.setValue(Const.SliderProps.VOLUME_DEFAULT_VALUE);
        jslVolume.setMinorTickSpacing(0); // установка шага регулирования
        jslVolume.setMajorTickSpacing(50); // расстояние, через которые будут выводиться большие деления
        jslVolume.setMinorTickSpacing(10); //расстояние, через которые будут выводиться маленькие деления
        jslVolume.setPaintTicks(true); //включить прорисовку делений
        jslVolume.setPaintLabels(true); //включить прорисовку меток делений
        jslVolume.setFont(new Font("Veranda", Font.PLAIN, 8)); //шрифт для делений и меток

        jslRewindProgress.setToolTipText(Const.SliderProps.PROGRESS_DEFAULT_TOOLTIP);
        jslRewindProgress.setName(Const.SliderProps.PROGRESS_NAME);
        jslRewindProgress.setMaximum(Const.SliderProps.PROGRESS_MAXVALUE);
        jslRewindProgress.setValue(Const.SliderProps.PROGRESS_DEFAULT_VALUE); // начальное значение всегда = 0
        jslRewindProgress.setMinorTickSpacing(1); // установка шага регулирования


        // ------------------
        // JList properties
        // ------------------
        jList1.setModel(playListModel);
        jList1.setName(Const.ListProps.PLAYLIST_NAME);

        // jScrollPane1 properties
        jScrollPane1.setViewportView(jList1);


        pack();
    }



}
