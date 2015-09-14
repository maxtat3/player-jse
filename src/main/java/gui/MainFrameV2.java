package gui;

import app.Const;

import javax.swing.*;
import java.awt.*;

/**
 * Created by max on 22.10.14.
 */
public class MainFrameV2 extends AllJComp {

	public MainFrameV2() {
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
	 * информ. панель - вывод основной информации о проигрываемой композиции
	 */
	private void setInformPanel() {
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
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabelSampleRate)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabelMonoStereoSound)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabelFileFormat))
										.addComponent(jLabelFileName))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelInformationLayout.setVerticalGroup(
				jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanelInformationLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelPlaybackTime)
										.addComponent(jLabelSepTime)
										.addComponent(jLabelTotalTime)
										.addComponent(jLabelPlayerState))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelBitRate)
										.addComponent(jLabelSampleRate)
										.addComponent(jLabelMonoStereoSound)
										.addComponent(jLabelFileFormat))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabelFileName)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jPanelInformation.setBorder(BorderFactory.createEtchedBorder());
	}

	/**
	 * панель для размещения ползунков громкости и прокрутки
	 * а также кнопки: моно\стерео, выкл. звук
	 */
	private void setVolumeAndProgressPanel() {
		GroupLayout jPanelVolAndProgressLayout = new GroupLayout(jPanelVolAndProgress);
		jPanelVolAndProgress.setLayout(jPanelVolAndProgressLayout);
		jPanelVolAndProgressLayout.setHorizontalGroup(
				jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jslRewindProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
												.addComponent(jtbtnMute, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jtbtnMonoStereo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jslVolume, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
								.addContainerGap())
		);
		jPanelVolAndProgressLayout.setVerticalGroup(
				jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanelVolAndProgressLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanelVolAndProgressLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jtbtnMute)
												.addComponent(jtbtnMonoStereo))
										.addComponent(jslVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jslRewindProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jPanelVolAndProgress.setBorder(BorderFactory.createEtchedBorder());
	}

	/**
	 * панель для размещения основных элементов управления + plylist + поиск по playlist
	 */
	private void setDirectionPanel() {
		GroupLayout jPanelPlaylistAndDirectionLayout = new GroupLayout(jPanelPlaylistAndDirection);
		jPanelPlaylistAndDirection.setLayout(jPanelPlaylistAndDirectionLayout);
		jPanelPlaylistAndDirectionLayout.setHorizontalGroup(
				jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1)
										.addComponent(jtfLiveSearch)
										.addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
												.addComponent(jbtnPlay, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnStop, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnPrev, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnNext, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jtbtnRandomPlaying, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
										.addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
												.addComponent(jbtnAdd, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnRemove, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbtnSetting, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap())
		);
		jPanelPlaylistAndDirectionLayout.setVerticalGroup(
				jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanelPlaylistAndDirectionLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jbtnPlay)
										.addComponent(jbtnStop)
										.addComponent(jbtnPrev)
										.addComponent(jbtnNext)
										.addComponent(jtbtnRandomPlaying))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jtfLiveSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelPlaylistAndDirectionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jbtnAdd)
										.addComponent(jbtnRemove)
										.addComponent(jbtnSetting))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jPanelPlaylistAndDirection.setBorder(BorderFactory.createEtchedBorder());
	}

	/**
	 * системная компоновочная панель
	 * Здесь также добавлена аозможность изменения размеров всех панелей
	 * Это делается из see {@link Const.Size}
	 */
	private void setGeneralPanel() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jPanelInformation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelVolAndProgress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanelPlaylistAndDirection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanelInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanelVolAndProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanelPlaylistAndDirection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

		// ------------------
		// JButton properties
		// ------------------
		jbtnPlay.setText(Const.ButtonProps.PLAY);
		jbtnPlay.setName(Const.ButtonProps.PLAY);
//		System.out.println(":: path = " + getClass().getResource( "file://home/max/player-jse/src/main/java/images/Play.png" ));
		jbtnPlay.setIcon(new ImageIcon(Const.Ico.PLAY));

		jbtnStop.setName(Const.ButtonProps.STOP);
		jbtnStop.setIcon(new ImageIcon(Const.Ico.STOP ));

		jbtnPrev.setName(Const.ButtonProps.PREV_SONG);
		jbtnPrev.setIcon(new ImageIcon(Const.Ico.PREV ));

		jbtnNext.setName(Const.ButtonProps.NEXT_SONG);
		jbtnNext.setIcon(new ImageIcon(Const.Ico.NEXT ));


		jbtnAdd.setName(Const.ButtonProps.ADD);
		jbtnAdd.setIcon(new ImageIcon(Const.Ico.ADD ));

		jbtnRemove.setName(Const.ButtonProps.REMOVE);
		jbtnRemove.setIcon(new ImageIcon(Const.Ico.REM ));


		// JToggleButton
		jtbtnRandomPlaying.setName(Const.ButtonProps.RANDOM_PLAYING);
//		jtbtnRandomPlaying.setIcon(new ImageIcon(getClass().getResource( Const.Ico.PLAY )));

		jtbtnMute.setName(Const.ButtonProps.MUTE);
		jtbtnMute.setIcon(new ImageIcon(Const.Ico.MUTE ));

		jtbtnMonoStereo.setName(Const.ButtonProps.MONO_STEREO);
//		jtbtnMonoStereo.setIcon(new ImageIcon(getClass().getResource( Const.Ico.PLAY )));
		// ------------

		jbtnSetting.setName(Const.ButtonProps.SETTING);
		jbtnSetting.setIcon(new ImageIcon(Const.Ico.SETG ));


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
