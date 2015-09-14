package app;

/**
 * Created by max on 16.09.14.
 */
public final class Const {

    public static final int MAX_SONG_NAME = 55; // максимальная длина в названии песни отображаемая в gui
    public static final  int RESOL_JSL_REWIND_PROGRESS = 1000; // разрешающая срособность ползунка перемотки песни


    /**
     * Имена всех кнопок в MainFrame
     * component - JButton
     */
    public static final class NamesGUIComp {
        public static final String PLAY = "play";
        public static final String PAUSE = "pause";
        public static final String STOP = "stop";
        public static final String PREV_SONG = "prev";
        public static final String NEXT_SONG = "next";

        public static final String ADD = "add";
        public static final String REMOVE = "rm";
        public static final String UP = "up";
        public static final String DOWN = "dwn";

        public static final String MONO_STEREO = "mono";
        public static final String MUTE = "mute";
    }


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

    public static final class Txt {
        public static final String MONO = "mono";
        public static final String STEREO = "stereo";
        public static final String UNKN = "unkn";
    }

}
