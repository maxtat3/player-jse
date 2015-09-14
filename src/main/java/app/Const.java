package app;

import javax.swing.*;
import java.net.URL;

/**
 * Created by max on 16.09.14.
 */
public final class Const {

    public static final String PLAYER_VERSION = "player v0.7.9";
    public static final String NONAME = "noname";
    public static final String[] EXTS = {".mp3", ".flac", ".ape"}; //поддерживаемые аудио форматы (расширения)


    /**
     * Специальные символы
     */
    public static final class SpecSym{
        public static final String DOT = ".";
        public static final String THREE_DOT = "...";
        public static final String EMPTY_STR = "";
        public static final String SEPARATOR = "/";
        public static final String NOT_TIME = "--:--";
    }

    /**
     * Свойства и имена заголовков
     * component - JLabel
     */
    public static final class LabelProps {
        public static final String PLAYER_STATE_PLAY = "PLAY";
        public static final String PLAYER_STATE_PAUSE = "PAUSE";
        public static final String PLAYER_STATE_STOP = "STOP";

        public static final String MONO = "mono";
        public static final String STEREO = "stereo";
        public static final String UNKN = "unkn";

        public static final String KHZ = " kHz";
        public static final String KBPS = " kbps";

        public static final String TITLE_HEADER = "title: ";
        public static final String AUTHOR_HEADER = "author: ";
        public static final String ALBUM_HEADER = "album: ";
        public static final String GENRE_HEADER = "genre: ";
        public static final String YEAR_HEADER = "year: ";
        public static final String COMMENT_HEADER = "comment: ";

        public static final int MAX_SONG_NAME_LENGTH = 55; // максимальная длина названия песни отображаемая в gui
        public static final int MAX_TAG_LENGTH = 45; // максимальная длина каждого из tags отображаемых в gui (inf panel)

        public static final String NOT_SONG = "This show is file name";
    }

    /**
     * Имена всех кнопок
     * component - JButton
     */
    public static final class ButtonProps {
        public static final String PLAY = "play";
        public static final String PAUSE = "pause";
        public static final String STOP = "stop";
        public static final String PREV_SONG = "prev";
        public static final String NEXT_SONG = "next";

        public static final String ADD = "add";
        public static final String REMOVE = "rm";
        public static final String UP = "up";
        public static final String DOWN = "dwn";

        public static final String RANDOM_PLAYING = "rand";
        public static final String MONO_STEREO = "mono";
        public static final String MUTE = "mute";

        public static final String SETTING = "setg";
    }


    /**
     * Свойства текстовых меток
     * component - JTextField
     */
    public static final class TextFieldProps {
        public static final String LIVE_SEARCH_DEFAULT_TEXT = "playlist live search";
        public static final String LIVE_SEARCH_NAME = "liveSearch";
    }


    /**
     * Свойства ползунков
     * component - JSlider
     */
    public static final class SliderProps {
        public static final String VOLUME_NAME = "volume";
        public static final String VOLUME_DEFAULT_TOOLTIP = "Изменение уровня громкости";
        public static final int VOLUME_DEFAULT_VALUE = 5 ;
        public static final int VOLUME_MAXVALUE = 200;

        public static final String PROGRESS_NAME = "rewindProgress";
        public static final String PROGRESS_DEFAULT_TOOLTIP = "Прокрутка композиции";
        public static final int PROGRESS_DEFAULT_VALUE = 0;
        public static final int PROGRESS_MAXVALUE = 1000;
        public static final int PROGRESS_RESOL = 1000; // разрешающая срособность ползунка перемотки песни
    }

    /**
     * Свйоства диалога для выбора файлов
     * component - JFileChooser
     */
    public static final class FileChooserProps {
        public static final String DIALOG_TITLE = "Add songs(s)";
    }

    /**
     * Свойства playlist
     * component - JList
     */
    public static final class ListProps {
        public static final String PLAYLIST_NAME = "playlist";
    }

    /**
     * Ключи для определения тегов
     */
    public static final class TagKey {
        public static final String TITLE = "title";
        public static final String AUTHOR = "author";
        public static final String ALBUM = "album";
        public static final String YEAR = "date";
        public static final String GENRE = "mp3.id3tag.genre";
        public static final String DURATION = "duration";
        public static final String COMMENT = "comment";
        public static final String SAMPLE_RATE = "audio.samplerate.hz";
        public static final String BITRATE = "bitrate";
        public static final String CHANNELS = "audio.channels";
        public static final String BYTES = "audio.length.bytes";
        public static final String TYPE = "audio.type";
    }

    /**
     * Цвета элементов gui
     */
    public static final class Color {
        public static final int GREY = 0x585858;
        public static final int GREEN = 0x04B431;
        public static final int BLUE = 0x08088A;
    }

    /**
     * Размеры элементов gui
     */
    public static final class Size {
        public static final int PANEL_INFORM_WIDTH = 350;
        public static final int PANEL_INFORM_HEIGHT = 278;
        public static final int PANEL_VOLPROGRESS_WIDTH = 350;
        public static final int PANEL_VOLPROGRESS_HEIGHT = 76;
        public static final int PANEL_PLAYLISTDIR_WIDTH = 497;
        public static final int PANEL_PLAYLISTDIR_HEIGHT = 364;

        public static final int SCROLL_PANE_WIDTH = 412;
        public static final int SCROLL_PANE_HEIGHT = 256;
    }

    /**
     * Шрифты
     */
    public static final class Font {
        public static final String DEJAVU_SANS = "DejaVu Sans";
    }

	/**
	 *
	 */
	public static final class Ico {
		public static final String PLAY = "./src/main/java/images/Play.png";
		public static final String STOP = "./src/main/java/images/stop-red-icon.png";
		public static final String PREV = "./src/main/java/images/rewind.png";
		public static final String NEXT = "./src/main/java/images/forward.png";

		public static final String MUTE = "./src/main/java/images/mute.png";

		public static final String ADD = "./src/main/java/images/open-icon.png";
		public static final String REM = "./src/main/java/images/remove_icon.png";
		public static final String SETG = "./src/main/java/images/gear_16.png";
	}

}
