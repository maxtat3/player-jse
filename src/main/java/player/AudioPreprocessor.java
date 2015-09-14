package player;

import app.Const;
import gui.MainFrame;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import utils.FileUtils;
import java.util.Map;

/**
 * Created by max on 02.09.14.
 */
public class AudioPreprocessor implements BasicPlayerListener{

    private static final String LOG_TAG = AudioPreprocessor.class.getName() + ": ";

    private MainFrame mainFrame;
    private FileUtils fileUtils;
    private Player player = new Player(this);

    private long durSongSec; //длительность песни (в секундах)
    private int durSongBytes; //длительность песни (в Байтах)
    private long amountSec; // сколько прошло с момента проигрывания (секунд)
    private double positionValue; // текущая позиция для прокрутки  [0 ... 1000]
    private String songName = "";

    private boolean movJslProgressAuto = false; // флаг - передвижения ползунка автоматически при проигрывании песни
    private boolean movJslProgressMan = false; // флаг - пользователь передвигает ползунок вручную (во время проигрывания)

    private String playTimeTmp = ""; //


    public AudioPreprocessor(MainFrame mainFrame, FileUtils fileUtils) {
        this.mainFrame = mainFrame;
        this.fileUtils = fileUtils;
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
        durSongSec = Math.round( ( ( (Long)properties.get(Const.TagKey.DURATION) ).longValue() ) / 1000000 );
        durSongBytes = Math.round( ( (Integer) properties.get(Const.TagKey.BYTES) ).intValue() );

        setTagInform(properties);

        // устанавливаем имя проигрываемого файла
        if (properties.get("title") != null){
            songName = properties.get("title").toString();
        } else {
            songName = "unown name";
        }
        if (songName.length() > Const.MAX_SONG_NAME){
            songName = songName.substring(0, Const.MAX_SONG_NAME) + "...";
        }

        mainFrame.getjLabelFileName().setText(songName); // устанавливаем в gui полное время звучания

        mainFrame.getjLabelTotalTime().setText( getTotalTime(durSongSec) );
    }

    @Override
    public void progress(int bytesRead, long microseconds, byte[] bytes, Map map) {
        float progress = -1.0f;
        if ( (bytesRead > 0) && (durSongSec > 0)){
            progress = (bytesRead * 1.0f) / (durSongBytes * 1.0f);
        }

        amountSec = (long) (progress * durSongSec); // сколько прошло секунд

        if ( durSongSec != 0 ){
            if (movJslProgressMan == false){ // если пользователь не передвигает ползунок (т.е. он двигается сам)
                // устанавливаем значение, для авто передвижения во время проигрывания
                mainFrame.getJslRewindProgress().setValue( Math.round((amountSec * Const.RESOL_JSL_REWIND_PROGRESS) / durSongSec) );
            }
        }

        // формирование и вывод проигрываемого времени
        if ( !playTimeTmp.equals(getPlayTime(amountSec)) ){
            mainFrame.getjLabelPlaybackTime().setText( getPlayTime(amountSec) );
        } else {
            return;
        }
        playTimeTmp = getPlayTime(amountSec);

    }

    @Override
    public void stateUpdated(BasicPlayerEvent basicPlayerEvent) {
        int state = basicPlayerEvent.getCode();
        if (state == BasicPlayerEvent.PLAYING){ // если состояние playerа - проигрывание песни -
            movJslProgressMan = false; // - сбрасываем флаг ручного передвижения ползунка
            System.out.println("BasicPlayerEvent.PLAYING");
        } else if (state == BasicPlayerEvent.SEEKING){ // если состояние playerа - перемотка
            movJslProgressMan = true; // устанавливам флаг ручного передвижения ползунка
            System.out.println("BasicPlayerEvent.SEEKING");
        } else if (state == BasicPlayerEvent.EOM){
            System.out.println("BasicPlayerEvent.EOM");
            if (selectNextSong()){
                play();
            }
        }
    }

    @Override
    public void setController(BasicController basicController) {
    }


    public boolean selectNextSong(){
        int nextSongIndex = mainFrame.getjList1().getSelectedIndex() + 1; // nextSongIndex - индексы в jlist начинаются с нуля
        if (nextSongIndex > 0) {
            mainFrame.getjList1().setSelectedIndex(nextSongIndex);
            return true;
        }
        return false;
    }


    public boolean selectPreviousSong(){
        int previousSongIndex = mainFrame.getjList1().getSelectedIndex() - 1;
        if (previousSongIndex > 0) {
            mainFrame.getjList1().setSelectedIndex(previousSongIndex);
            return true;
        }
        return false;
    }

    public void play(){
        int[] selSongs = mainFrame.getjList1().getSelectedIndices(); // тут хранятся выбранные песни (если выбраны несколько)
        if (selSongs.length > 0){
            MP3 mp3 = (MP3) mainFrame.getPlaylistModel().getElementAt(selSongs[0]); // находим первую выбранную песню (если выделенно несколько)
            player.play(mp3.getPath());
            player.setVolume(mainFrame.getJslVolume().getValue(), mainFrame.getJslVolume().getMaximum());
        }
    }

    public void pause(){
        player.pause();
    }

    public void stop(){
        player.stop();
    }

    public void playNextSong(){
        if (selectNextSong()){
            play();
        }
    }

    public void playPreviousSong(){
        if (selectPreviousSong()){
            play();
        }
    }

    public void setVolume(int currValue, int maxValue){
        player.setVolume(currValue, maxValue);
    }

    public void jump(long bytes){
        player.jumpInCurrFile(bytes);
    }

    private void setTagInform(Map prop){
        mainFrame.getJtfTitle().setText((String) prop.get(Const.TagKey.TITLE));
        mainFrame.getJtfAlbum().setText((String) prop.get(Const.TagKey.ALBUM));
        mainFrame.getJtfYear().setText((String) prop.get(Const.TagKey.YEAR));
        mainFrame.getJtfAuthor().setText((String) prop.get(Const.TagKey.AUTHOR));
        mainFrame.getJtfGenre().setText((String) prop.get(Const.TagKey.GENRE));

        mainFrame.getjLabelSampleRate().setText( prop.get(Const.TagKey.SAMPLE_RATE).toString() + " Hz" );
        mainFrame.getjLabelBitRate().setText( div(prop.get(Const.TagKey.BITRATE).toString(), 1000) + " kbps" );

        if ( prop.get(Const.TagKey.CHANNELS).toString().equals("1") ){
            mainFrame.getjLabelMonoStereoSound().setText(Const.Txt.MONO);
        } else if (prop.get(Const.TagKey.CHANNELS).toString().equals("2")){
            mainFrame.getjLabelMonoStereoSound().setText(Const.Txt.STEREO);
        } else {
            mainFrame.getjLabelMonoStereoSound().setText(Const.Txt.UNKN);
        }

        mainFrame.getjLabelFileFormat().setText((String) prop.get(Const.TagKey.TYPE));
    }


    /**
     * Выполняет деление чисел передаваемых в строковом представлении
     * @param num - передавамое число
     * @param kDiv - делитель
     * @return - результат
     */
    private String div(String num, int kDiv){
        int numInt = Integer.parseInt(num);
        numInt /= kDiv;
        String numStr = String.valueOf(numInt);
        return numStr;
    }



    private String getTotalTime(long durationSongSec) {
        StringBuilder strbl = new StringBuilder();

        int min = (int) (durationSongSec / 60);
        int sec = (int) (durationSongSec % 60);

        strbl.append(min);
        strbl.append(":");
        if (sec/10 < 1){
            strbl.append("0");
            strbl.append(sec);
        } else {
            strbl.append(sec);
        }

        String totalTime = String.valueOf(strbl);
        return totalTime;
    }

    private String getPlayTime(long amountUs){
        StringBuilder strbl = new StringBuilder();

        int min = (int) (amountUs / 60);
        int sec = (int) (amountUs % 60);

        strbl.append(min);
        strbl.append(":");
        if (sec/10 < 1){
            strbl.append("0");
            strbl.append(sec);
        } else {
            strbl.append(sec);
        }

        String playTime = String.valueOf(strbl);
        return playTime;
    }


}
