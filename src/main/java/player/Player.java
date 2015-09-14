package player;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import java.io.File;


/**
 * Created by max on 09.09.14.
 */
public class Player extends BasicPlayer {

    private static final String LOG_TAG = Player.class.getName() + ": ";

    private String currFilePath; // полный путь к файлу (включая имя файла)
    private double currVolumeValue; // текцщий уровень громкости
    private BasicPlayer basicPlayer = new BasicPlayer();


    public Player(BasicPlayerListener basicPlayerListener) {
        basicPlayer.addBasicPlayerListener(basicPlayerListener); // Добавляем слушатель к basicPlayer
    }


    /**
     * Проигрывание выделенное в playlist песни
     * @param path - полный путь к файлу (включая имя файла)
     */
    public void play(String path){
        try {
            if (basicPlayer.getStatus() == BasicPlayer.PAUSED){
                basicPlayer.resume();
                return;
            }

            currFilePath = path;
            File filePathSong = new File(path);

            basicPlayer.open(filePathSong);
            basicPlayer.play();
            basicPlayer.setGain(currVolumeValue);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
        // TODO - установка на паузу раюотает, но есть проблема зависания и существует при переходе на паузу
    }

    /**
     * Остановка проигрывания песни
     */
    public void stop(){
        try {
            basicPlayer.stop();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Установка проигрываемой песни на паузу
     */
    public void pause(){
        try {
            basicPlayer.pause();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Установка громкости
     * @param currValue - текущее значние ползунка
     * @param maxValue - максимальное значние ползунка
     */
    public void setVolume(int currValue, int maxValue) {
        currVolumeValue = currValue;
        try {
            if (currVolumeValue == 0) {
                basicPlayer.setGain(0);
            } else {
                basicPlayer.setGain(volumeCalculate(currValue, maxValue));
            }
        } catch (BasicPlayerException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Позволяет отключить звук во время проигрывания.
     * При переходе из состояний вкл.звук\без звука
     * предыдущее значение громкомти сохраняется.
     * @param isMute - состояние в которое нужно  перейти: true - откл.; false - вкл.
     */
    private double memVol; // временное сохранение громкости при входе в режим "без звука" [mute]
    public void mute(boolean isMute){
        if (isMute){
            memVol = currVolumeValue;
            try {
                basicPlayer.setGain(0); //откл. звук
            } catch (BasicPlayerException e) {
                e.printStackTrace();
            }
        } else {
            try {
                basicPlayer.setGain(memVol); //вкл + восстанаавливаем предыдущее состояние громкости
            } catch (BasicPlayerException e) {
                e.printStackTrace();
            }
            memVol = 0f;
        }
    }

    /**
     * Перемотка в текущей песне
     * @param bytes - переход в Байтах
     */
    public void jumpInCurrFile(long bytes){
        try {
            System.out.println(LOG_TAG + "seek = " + bytes);
            basicPlayer.seek(bytes);
            basicPlayer.setGain(currVolumeValue);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Вычисление значения громкости из слайдера для BasicPlayer
     * @param currVal - текущее значение громкости
     * @param maxVal - максимальное значение для слайдера
     * @return - вычисленное значение громкости [0 ... 1.0]
     */
    private double volumeCalculate(int currVal, int maxVal){
        currVolumeValue = (double)currVal / (double)maxVal;
        return currVolumeValue;
    }





}
