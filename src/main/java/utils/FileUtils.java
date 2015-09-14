package utils;

import gui.MainFrameV1;
import player.MP3;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by max on 10.09.14.
 */
public class FileUtils {

    private MainFrameV1 mainFrame;

    public FileUtils(MainFrameV1 mainFrame) {
        this.mainFrame = mainFrame;
    }

//    /**
//     * добавление песни из диалога выбора (jfilechooser) в playlist (jlist)
//     */
//    public void addSongToPlayList(){
//        int result = mainFrame.getJfc().showOpenDialog(mainFrame.getContentPane());
//        if (result == JFileChooser.APPROVE_OPTION){
//            File[] selFiles = mainFrame.getJfc().getSelectedFiles();
//            for (File file : selFiles){ // перебираем все выделенные файлы и добавляем их в playlist
//                MP3 mp3 = new MP3(file.getName(), file.getPath());
//                if ( !mainFrame.getPlaylistModel().contains(mp3) ){ //если такого фала в playlist нет - добавим его
//                    mainFrame.getPlaylistModel().addElement(mp3);
//                }
//            }
//        }
//    }
//
//    /**
//     * удаление песни из playlist (JList)
//     */
//    public void removeSongToPlayList(){
//        int[] selSongs = mainFrame.getjList1().getSelectedIndices();
//        if (selSongs.length > 0){ // если выбрана хотябы одна песня
//            ArrayList<MP3> mp3ListForRem = new ArrayList<MP3>(); //сохраняем все выбранные песни для удаления из playlist
//            for (int i = 0; i < selSongs.length; i++) {
//                MP3 mp3 = (MP3) mainFrame.getPlaylistModel().getElementAt(selSongs[i]);
//                mp3ListForRem.add(mp3);
//            }
//            for (MP3 mp3 : mp3ListForRem){
//                mainFrame.getPlaylistModel().removeElement(mp3);
//            }
//        }
//        mainFrame.jComponent.get
//    }







    public static String getFileNameWithoutExtension(String name){
        File file = new File(name);

        int indexForFullName = file.getName().length(); //индекс для полного имени файла включая расширение (например для music.mp3 = 9)
        int indexForDot = file.getName().lastIndexOf('.'); //индекс имени файла до разделителя (точка) (например для music.mp3 = 5)

        // если у файла есть имя (без расширения)
        // и если
//        if ( (indexForDot > 0) && (indexForDot <= indexForFullName - 2) ){
        if (indexForDot > 0){
            return file.getName().substring(0, indexForDot);
        }
        return "noname";
    }

    public static String getFileExtension(File file) {
        String ext = "";
        String fileName = file.getName();

        int indexForFullName = fileName.length(); //индекс для полного имени файла включая расширение (например для music.mp3 = 9)
        int indexForDot = fileName.lastIndexOf('.'); //индекс имени файла до разделителя (точка) (например для music.mp3 = 5)

        if (indexForDot > 0) {
            ext = fileName.substring(indexForDot + 1).toLowerCase();
        }
        return ext;
    }


    public static void addFileFilter(JFileChooser jfc, FileFilter ff){
        // TODO
    }

}
