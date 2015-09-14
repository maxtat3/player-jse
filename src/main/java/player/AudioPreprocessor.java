package player;

import app.Const;
import gui.MainFrameV1;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import utils.FileUtils;

import java.util.*;


/**
 * Created by max on 02.09.14.
 */
public class AudioPreprocessor implements BasicPlayerListener{

    private static final String LOG_TAG = AudioPreprocessor.class.getName() + ": ";

    private MainFrameV1 mainFrame;
    private FileUtils fileUtils;

    private Player player = new Player(this);

    private long durSongSec; //длительность песни (в секундах)
    private int durSongBytes; //длительность песни (в Байтах)
    private long amountSec; // сколько прошло с момента проигрывания (секунд)
    private double positionValue; // текущая позиция для прокрутки  [0 ... 1000]
    private String songName = Const.EMPTY_STR; // имя песни отображаемое в gui

    private boolean movJslProgressAuto = false; // флаг - передвижения ползунка автоматически при проигрывании песни
    private boolean movJslProgressMan = false; // флаг - пользователь передвигает ползунок вручную (во время проигрывания)

    private String playTimeTmp = Const.EMPTY_STR; //


    public AudioPreprocessor(MainFrameV1 mainFrame, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.fileUtils = fileUtils;
    }

    public AudioPreprocessor(MainFrameV1 mainFrame) {
        this.mainFrame = mainFrame;
    }


    public int getDurSongBytes() {
        return durSongBytes;
    }

    public void setDurSongBytes(int durSongBytes) {
        this.durSongBytes = durSongBytes;
    }


    public double getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(double positionValue) {
        this.positionValue = positionValue;
    }


    public boolean isMovJslProgressAuto() {
        return movJslProgressAuto;
    }

    public void setMovJslProgressAuto(boolean movJslProgressAuto) {
        this.movJslProgressAuto = movJslProgressAuto;
    }


    public boolean isMovJslProgressMan() {
        return movJslProgressMan;
    }

    public void setMovJslProgressMan(boolean movJslProgressMan) {
        this.movJslProgressMan = movJslProgressMan;
    }


    /**
     * Позволяет определить большинство параметров проигрвыаемого файла
     * Для этого System.out.println(properties);
     * Пример вывода коллекции map при открытии MP3 файла:
     * properties contains = {
         mp3.id3tag.track=1,
         mp3.crc=false,
         mp3.copyright=false,
         album=Un'rra All Organ con Mozart,
         audio.length.frames=28883,
         mp3.version.mpeg=1,
         mp3.channels=2,
         date=2006,
         mp3.id3tag.genre=Classical,
         author=Luigi Benedetti & Letizia Rom,
         mp3.framesize.bytes=1041,
         title=Fantasie,
         mp3.version.layer=3,
         mp3.length.frames=28883,
         mp3.vbr.scale=0,
         mp3.bitrate.nominal.bps=320000,
         mp3.version.encoding=MPEG1L3,
         audio.type=MP3,
         audio.length.bytes=30154838,
         vbr=false,
         mp3.padding=true,
         audio.framerate.fps=38.28125,
         mp3.length.bytes=30154838,
         audio.channels=2,
         mp3.framerate.fps=38.28125,
         duration=754495000,
         mp3.frequency.hz=44100,
         mp3.header.pos=0,
         basicplayer.sourcedataline=com.sun.media.sound.DirectAudioDevice$DirectSDL@4a7091c,
         bitrate=320000,
         mp3.mode=1,
         comment=,
         mp3.vbr=false,
         audio.samplerate.hz=44100.0,
         mp3.original=true
     }
     ---
     при открытии FLAC файла
     {
         audio.channels=2,
         basicplayer.sourcedataline=com.sun.media.sound.DirectAudioDevice$DirectSDL@4ce67c1e,
         audio.samplesize.bits=16,
         audio.type=FLAC,
         audio.samplerate.hz=44100.0
     }
     ---
     при открытии APE файла
     {
         genre=Classical,
         ape.formatflags=32,
         album=Beethoven Piano Concerto No.5,
         date=Tue Jan 01 00:00:00 EET 2008,
         ape.blocksperframe=73728,
         author=null,
         title=I:\Beethoven_Piano Concertos Nos.1-5_Pletnev(DG 3CD)\2&4\CDImage,
         ape.finalframeblocks=69372,
         ape.blockalign=4,
         audio.type=Monkey's Audio (ape),
         ape.compressionlevel=2000,
         audio.length.bytes=155175253,
         vbr=true,
         ape.totalblocks=99897084,
         track=null, ape.version=3990,
         ape.totalframes=1355,
         audio.samplesize.bits=16,
         copyright=null,
         ape.peaklevel=-1,
         audio.channels=2,
         duration=2265240,
         quality=10,
         basicplayer.sourcedataline=com.sun.media.sound.DirectAudioDevice$DirectSDL@356defec,
         bitrate=548,
         comment=Exact Audio Copy,
         audio.samplerate.hz=44100.0
     }
     * @param stream
     * @param properties - коллекция со тегами приоигрываемого файла
     */
    @Override
    public void opened(Object stream, Map properties) {
        durSongSec = Math.round( ((Long) properties.get(Const.TagKey.DURATION)) / 1000000 );
        durSongBytes = Math.round( ( (Integer) properties.get(Const.TagKey.BYTES) ).intValue() );

        setTagInform(properties);

//        Устанавливаем имя проигрываемого файла в label

//        ВАРИАНТ 1 , определяется не имя файла, а title
//        String songName = "";
//        if (properties.get(Const.TagKey.TITLE) != null){
//            songName = properties.get(Const.TagKey.TITLE).toString();
//        } else {
//            songName = "unknown name";
//        }
//        if (songName.length() > Const.MAX_SONG_NAME_LENGTH){
//            songName = songName.substring(0, Const.MAX_SONG_NAME_LENGTH) + "...";
//        }

//        ВАРИАНТ 2 - определяется полное имя файла
        if ( !songName.equals(Const.EMPTY_STR) ){
            doReduceLengthString(songName, Const.LabelProps.MAX_SONG_NAME_LENGTH);
        } else {
            songName = Const.LabelProps.UNKN;
        }

        mainFrame.getjLabelFileName().setText(songName);

        mainFrame.getjLabelTotalTime().setText( getMinSecTime(durSongSec) ); // устанавливаем в gui полное время звучания
    }

    /**
     * Определение параметров проигрываемого файла в динамике (при проигрывании песни)
     * @param bytesRead - сколко прочитано Байт с момента начала проигрывания песни
     * @param microseconds - скрлько прошло us с момента начала проигрывания песни
     * @param bytes -
     * @param map  - коллекция со тегами приоигрываемого файла
     */
    @Override
    public void progress(int bytesRead, long microseconds, byte[] bytes, Map map) {
        float progress = -1.0f;
        if ( (bytesRead > 0) && (durSongSec > 0)){
            progress = (bytesRead * 1.0f) / (durSongBytes * 1.0f);
        }

        amountSec = (long) (progress * durSongSec); // сколько прошло секунд

        if ( durSongSec != 0 ){
            if (!movJslProgressMan){ // если пользователь не передвигает ползунок (т.е. он двигается сам)
                // устанавливаем значение, для авто передвижения во время проигрывания
                mainFrame.getJslRewindProgress().setValue( Math.round((amountSec * Const.SliderProps.REWIND_PROGRESS_RESOL) / durSongSec) );
            }
        }

        // формирование и вывод проигрываемого времени
        // только тогда устанавливаем время в gui, когда playTimeTmp и getMinSecTime(amountSec) будут различны
        if ( !playTimeTmp.equals(getMinSecTime(amountSec)) ){
            mainFrame.getjLabelPlaybackTime().setText( getMinSecTime(amountSec) );
        } else {
            return;
        }
        playTimeTmp = getMinSecTime(amountSec);
    }

    /**
     * Считывание событий, возникающих при работе плеера
     * @param basicPlayerEvent -  доступ к кодам событий
     */
    @Override
    public void stateUpdated(BasicPlayerEvent basicPlayerEvent) {
        int state = basicPlayerEvent.getCode();

        if (state == BasicPlayerEvent.PLAYING){ // если состояние playerа - проигрывание песни ...
            movJslProgressMan = false; // ... сбрасываем флаг ручного передвижения ползунка
            mainFrame.getjLabelPlayerState().setForeground(new java.awt.Color(Const.Color.GREEN));
            mainFrame.getjLabelPlayerState().setText(Const.LabelProps.PLAYER_STATE_PLAY);

        } else if (state == BasicPlayerEvent.SEEKING){ // если состояние playerа - перемотка
            movJslProgressMan = true; // устанавливам флаг ручного передвижения ползунка
            System.out.println("BasicPlayerEvent.SEEKING");

        } else if (state == BasicPlayerEvent.EOM){
            System.out.println("BasicPlayerEvent.EOM");
            if (selectNextSong()){
                play();
            }

        } else if (state == BasicPlayerEvent.STOPPED){
            mainFrame.getjLabelPlayerState().setForeground(new java.awt.Color(Const.Color.BLUE));
            mainFrame.getjLabelPlayerState().setText(Const.LabelProps.PLAYER_STATE_STOP);
            setTagInform(emptyProp());

        } else if (state == BasicPlayerEvent.PAUSED){
            mainFrame.getjLabelPlayerState().setForeground(new java.awt.Color(Const.Color.GREY));
            mainFrame.getjLabelPlayerState().setText(Const.LabelProps.PLAYER_STATE_PAUSE);
        }
    }

    /**
     * Контроллер
     * @param basicController
     */
    @Override
    public void setController(BasicController basicController) {
    }


    /**
     * Выбор следующей песни в playlist.
     * Метод вызывается в собыеиях плеера see {@link #stateUpdated(BasicPlayerEvent)}
     * и при нажатии на кнопку next в gui
     * @return - true - дальше есть след. песня; false - дальше нет след. песни (playlist end)
     */
    public boolean selectNextSong(){
        int nextSongIndex = mainFrame.getjList1().getSelectedIndex() + 1; // nextSongIndex - индексы в jlist начинаются с нуля
        if (nextSongIndex > 0) {
            mainFrame.getjList1().setSelectedIndex(nextSongIndex);
            return true;
        }
        return false;
    }

    /**
     * Выбор предыдущей песни в playlist.
     * Метод вызывается в собыеиях плеера see {@link #stateUpdated(BasicPlayerEvent)}
     * и при нажатии на кнопку next в gui
     * @return - true - есть предыд. песня; false - нет передыд. песни (playlist end)
     */
    public boolean selectPreviousSong(){
        int previousSongIndex = mainFrame.getjList1().getSelectedIndex() - 1;
        if (previousSongIndex > 0) {
            mainFrame.getjList1().setSelectedIndex(previousSongIndex);
            return true;
        }
        return false;
    }


    /**
     * Начать воспроизведение выбранной песни в playlist
     */
    public void play(){
        // Проверяем активность случайного выбора песни.
        // генерация случайного значения в диапазоне [0, число песен в playlist -1]
        // min = 0 - потому индекс самой первой песни в playlist = 0
        // Например для того чтобы перебрать 5 песен, нужно сгенерировать числа от 0 до 4, тогда max=5-1=4
        if (mainFrame.getJtbtnRandomPlaying().isSelected()){
            int randDig = randGen(0, mainFrame.getPlayListModel().size() - 1); //генерация случайного значения
            // код -1 означает что все числа из [min, max] сгенерированиы
            if (randDig != -1){
                mainFrame.getjList1().setSelectedIndex(randDig);
            } else {
                player.stop();
                return;
            }
        }

        // Если не выбрано ни одной песни, выбираем самую первую  (с индексом = 0  в playlist)
        if (mainFrame.getjList1().getSelectedIndices().length == 0){
            mainFrame.getjList1().setSelectedIndex(0);
        }

        int[] selSongs = mainFrame.getjList1().getSelectedIndices(); // тут хранятся выбранные песни (если выбраны несколько)

        if (selSongs.length > 0){
            MP3 mp3 = (MP3) mainFrame.getPlayListModel().getElementAt(selSongs[0]); // находим первую выбранную песню (если выделенно несколько)
            songName = mp3.getName();
            player.play(mp3.getPath());
            mainFrame.setTitle( mp3.getName() ); // установка имени проигрываемой песни, полезно когда программа свернута в трей
            player.setVolume(mainFrame.getJslVolume().getValue(), mainFrame.getJslVolume().getMaximum());
        }
    }

    /**
     * Переход в состояние паузы
     * Запрос к плееру
     */
    public void pause(){
        player.pause();
    }

    /**
     * Переход в состояние стоп воспроизведения
     * Запрос к плееру
     */
    public void stop(){
        player.stop();
    }

    /**
     * Воспроизведение следующей песни
     * Запрос к плееру
     */
    public void playNextSong(){
        if (selectNextSong()){
            play();
        }
    }

    /**
     * Воспроизведение предыдущей песни
     */
    public void playPreviousSong(){
        if (selectPreviousSong()){
            play();
        }
    }

    /**
     * Установка уровня громкости
     * Запрос к плееру
     * @param currValue - устанавливаемое значение при перемещении ползунка
     * @param maxValue - максимальное значние для ползунка
     */
    public void setVolume(int currValue, int maxValue){
        player.setVolume(currValue, maxValue);
    }

    /**
     * Установка значения на которое нужно нужно перемотать внутри проигрываемой песни
     * Запрос к плееру
     * @param bytes - значение в Байтах
     */
    public void jump(long bytes){
        player.jumpInCurrFile(bytes);
    }

    /**
     * Отключение звука
     * Запрос к плееру
     * @param isMute - true - откл.; false - вкл.
     */
    public void mute(boolean isMute) {
        player.mute(isMute);
    }


    /**
     * Установка дополнительных параметров из тегов
     * @param prop - карта тегов с дополнительныйми параметрами
     */
    private void setTagInform(Map prop) {
        mainFrame.getjLabelTitle().setText(doReduceLengthString((String) prop.get(Const.TagKey.TITLE), Const.LabelProps.MAX_TAG_LENGTH));
        mainFrame.getjLabelTitle().setToolTipText(Const.LabelProps.TITLE_HEADER + prop.get(Const.TagKey.TITLE));

        mainFrame.getjLabelAlbum().setText(doReduceLengthString((String) prop.get(Const.TagKey.ALBUM), Const.LabelProps.MAX_TAG_LENGTH));
        mainFrame.getjLabelAlbum().setToolTipText(Const.LabelProps.ALBUM_HEADER + prop.get(Const.TagKey.ALBUM));

        mainFrame.getjLabelYear().setText(doReduceLengthString((String) prop.get(Const.TagKey.YEAR), Const.LabelProps.MAX_TAG_LENGTH));
        mainFrame.getjLabelYear().setToolTipText(Const.LabelProps.YEAR_HEADER + prop.get(Const.TagKey.YEAR));

        mainFrame.getjLabelAuthor().setText(doReduceLengthString((String) prop.get(Const.TagKey.AUTHOR), Const.LabelProps.MAX_TAG_LENGTH));
        mainFrame.getjLabelAuthor().setToolTipText(Const.LabelProps.AUTHOR_HEADER + prop.get(Const.TagKey.AUTHOR));

        mainFrame.getjLabelGenre().setText(doReduceLengthString((String) prop.get(Const.TagKey.GENRE), Const.LabelProps.MAX_TAG_LENGTH));
        mainFrame.getjLabelGenre().setToolTipText(Const.LabelProps.GENRE_HEADER + prop.get(Const.TagKey.GENRE));


        mainFrame.getjLabelSampleRate().setText(
                !prop.get(Const.TagKey.SAMPLE_RATE).toString().equals(Const.LabelProps.EMPTY_FIELD_DOT) ?
                        div(prop.get(Const.TagKey.SAMPLE_RATE).toString(), Format.DOUBLE, 1000) + " Hz" :
                        Const.LabelProps.EMPTY_FIELD_DOT
        );

        mainFrame.getjLabelBitRate().setText(
                !prop.get(Const.TagKey.BITRATE).toString().equals(Const.LabelProps.EMPTY_FIELD_DOT) ?
                        div(prop.get(Const.TagKey.BITRATE).toString(), Format.INT, 1000) + " kbps" :
                        Const.LabelProps.EMPTY_FIELD_DOT
        );


        if ( !prop.get(Const.TagKey.CHANNELS).toString().equals(Const.LabelProps.EMPTY_FIELD_DOT) ){
            if (prop.get(Const.TagKey.CHANNELS).toString().equals("1")) {
                mainFrame.getjLabelMonoStereoSound().setText(Const.LabelProps.MONO);
            } else if (prop.get(Const.TagKey.CHANNELS).toString().equals("2")) {
                mainFrame.getjLabelMonoStereoSound().setText(Const.LabelProps.STEREO);
            } else {
                mainFrame.getjLabelMonoStereoSound().setText(Const.LabelProps.UNKN);
            }
        } else {
            mainFrame.getjLabelMonoStereoSound().setText( Const.LabelProps.EMPTY_FIELD_DOT );
        }


        mainFrame.getjLabelFileFormat().setText((String) prop.get(Const.TagKey.TYPE));
    }


    /**
     * Выполняет деление чисел передаваемых в строковом представлении
     * @param num - передавамое число
     * @param format - формат входных данных (int, double)
     * @param kDiv - делитель
     * @return - результат
     */
    private String div(String num, Format format, int kDiv){
        if (format == Format.INT) {
            int numInt = Integer.parseInt(num);
            numInt /= kDiv;
            return String.valueOf(numInt);
        } else if (format == Format.DOUBLE) {
            double numInt = Double.parseDouble(num);
            numInt /= kDiv;
            return String.valueOf(numInt);
        }
        return null;
    }

    /**
     * Перечень входных данных для вывода дополнительной tag-информации
     * Используется методом div, see {@link #div(String, Format, int)}.
     */
    private enum Format {
        INT,
        DOUBLE;
    }


    /**
     * Преобразование  вемени в секундах
     * в формат минуты : секунды
     * @param seconds - секунды
     * @return - минуты : секунды
     */
    private String getMinSecTime(long seconds){
        StringBuilder strbl = new StringBuilder();

        int min = (int) (seconds / 60);
        int sec = (int) (seconds % 60);

        strbl.append(min);
        strbl.append(":");
        if (sec/10 < 1){
            strbl.append("0");
            strbl.append(sec);
        } else {
            strbl.append(sec);
        }

        return String.valueOf(strbl);
    }

    /**
     * Проверка длины строки, если длина строки
     * более maxLength символов, отбросить эти символы, до maxLength
     * остальное заменить символом "..."
     * @param str - проверяемая строка
     * @param maxLength - максимальная длина строки, полсе которой устанавливается символ "..."
     * @return - полная\уменьшенная строка
     */
    private String doReduceLengthString(String str, int maxLength){
        System.out.println("str = " + str);
        System.out.println("max length = " + maxLength);
        if ( str != null ){
            if (str.length() > maxLength){
                return str.substring(0, maxLength) + Const.LabelProps.EMPTY_FIELD_THREE_DOT;
            }
        }
        return str;
    }


    /**
     * Формирование пустой карт с тегами
     * @return - пустая карта с тегами
     */
    private Map<String, String> emptyProp(){
        Map<String, String> prop = new HashMap<String, String>();

        prop.put(Const.TagKey.TITLE, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.ALBUM, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.YEAR, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.AUTHOR, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.GENRE, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.SAMPLE_RATE, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.BITRATE, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.CHANNELS, Const.LabelProps.EMPTY_FIELD_DOT);
        prop.put(Const.TagKey.TYPE, Const.LabelProps.EMPTY_FIELD_DOT);

        return prop;
    }


    private List<Integer> existRands = new ArrayList<Integer>(); //хранилище, сюда попадают сгенерированные числа в диаразоне [min, max]
    private static int countDig; //счетчик, сколько цифр нужно сгенерировать
    /**
     *  Генерация случайного целого числа без повторения в заданном диапазоне
     *  по формуле:  Min + (int)(Math.random() * ((Max - Min) + 1))
     *  http://allmycircuitz.blogspot.com/2013/09/java.html
     * @param min - левая граница диапазона (min входит в диапазон)
     * @param max - правая граница диапазона (max входит в диапазон)
     * @return - случайное число в диапазоне [min, max] / код -1 т.е. все числа сгенерированы
     */
    private int randGen(int min, int max){
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        int rand;
        boolean equal; //флаг совпадения сгенерированного числа и числа которое уже есть в хранилище
        if ( existRands.isEmpty() ){
            countDig = max - min;
            rand = min + (int)(Math.random() * ((max - min) + 1));
            existRands.add(rand);
        } else {
            if (countDig == 0){
                existRands.clear();
                return -1;
            }
            do {
                equal = false;
                rand = min + (int)(Math.random() * ((max - min) + 1));
                for (Integer indecy : existRands) {
                    if (rand == indecy) {
                        equal = true;
                        break;
                    }
                }
            } while (equal);

            countDig--;
            existRands.add(rand);
        }

        return rand;
    }

}
