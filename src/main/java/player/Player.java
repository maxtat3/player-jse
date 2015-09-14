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
    private String currFileName;
    private double currVolumeValue;
    private BasicPlayer basicPlayer = new BasicPlayer();


    public Player(BasicPlayerListener basicPlayerListener) {
        basicPlayer.addBasicPlayerListener(basicPlayerListener); // Добавляем слушатель к basicPlayer
    }

    public void play(String name){
        File fileNameSong = new File(name);
        try {
            basicPlayer.open(fileNameSong);
            basicPlayer.play();
            basicPlayer.setGain(currVolumeValue);
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        try {
            basicPlayer.stop();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        try {
            basicPlayer.pause();
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

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
