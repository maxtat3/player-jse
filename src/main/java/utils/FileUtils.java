package utils;

import app.Const;
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

    private MainFrameV1 mainFrameV1;
    private utils.FileFilter ff = new utils.FileFilter("mp3", "файлы ");


    public FileUtils(MainFrameV1 mainFrameV1) {
        this.mainFrameV1 = mainFrameV1;
    }


    /**
     * Добавление песни из диалога выбора (jfilechooser) в playlist (jlist)
     */
    public void addSongToPlayList(){
        addFileFilter(mainFrameV1.getJfch(), ff);
        int result = mainFrameV1.getJfch().showOpenDialog(mainFrameV1.getContentPane());
        if (result == JFileChooser.APPROVE_OPTION){
            File[] selFiles = mainFrameV1.getJfch().getSelectedFiles();
            for (File file : selFiles){ // перебираем все выделенные файлы и добавляем их в playlist
                MP3 mp3 = new MP3(file.getName(), file.getPath());
                if ( !mainFrameV1.getPlayListModel().contains(mp3) ){ //если такого фала в playlist нет - добавим его
                    mainFrameV1.getPlayListModel().addElement(mp3);
                }
            }
        }
    }


    /**
     * Удаление песни из playlist (JList)
     */
    public void removeSongToPlayList(){
        int[] selSongs = mainFrameV1.getjList1().getSelectedIndices();
        if (selSongs.length > 0){ // если выбрана хотябы одна песня
            ArrayList<MP3> mp3ListForRem = new ArrayList<MP3>(); //сохраняем все выбранные песни для удаления из playlist
            for (int i = 0; i < selSongs.length; i++) {
                MP3 mp3 = (MP3) mainFrameV1.getPlayListModel().getElementAt(selSongs[i]);
                mp3ListForRem.add(mp3);
            }
            for (MP3 mp3 : mp3ListForRem){
                mainFrameV1.getPlayListModel().removeElement(mp3);
            }
        }
    }


    /**
     * Получение имени файла без расширения
     * @param name - полное имя файла
     * @return - имя файла без расширения
     */
    public static String getFileNameWithoutExtension(String name){
        File file = new File(name);

        int indexForFullName = file.getName().length(); //индекс для полного имени файла включая расширение (например для music.mp3 = 9)
        int indexForDot = file.getName().lastIndexOf('.'); //индекс имени файла до разделителя (точка) слева-направо (например для music.mp3 = 5)

//        if ( (indexForDot > 0) && (indexForDot <= indexForFullName - 2) ){
        // если у файла есть имя (без расширения)
        if (indexForDot > 0){
            return file.getName().substring(0, indexForDot);
        }

        return Const.NONAME;
    }

    /**
     * Получение только расширения файла
     * @param file - файл
     * @return - расширение
     */
    public static String getFileExtension(File file) {
        String ext = Const.EMPTY_STR;
        String fileName = file.getName();

        int indexForFullName = fileName.length(); //индекс для полного имени файла включая расширение (например для music.mp3 = 9)
        int indexForDot = fileName.lastIndexOf('.'); //индекс имени файла до разделителя (точка) (например для music.mp3 = 5)

        if (indexForDot > 0) {
            ext = fileName.substring(indexForDot + 1).toLowerCase();
        }
        return ext;
    }


    /**
     * Добавление файл фильтра к диалогу выбора файлов.
     * @param jfc - экземпляр диалог выбора файлов
     * @param ff - экземпляр файл фильтра
    */
    public void addFileFilter(JFileChooser jfc, FileFilter ff){
        jfc.removeChoosableFileFilter( jfc.getFileFilter() ); //убираем стандартный файл фи
        jfc.setFileFilter(ff);
    }






}
