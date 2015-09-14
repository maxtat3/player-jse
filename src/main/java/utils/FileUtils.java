package utils;

import app.Const;
import gui.AllJComp;
import gui.MainFrameV1;
import gui.MainFrameV2;
import player.MP3;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 10.09.14.
 */
public class FileUtils {

    private AllJComp mainFrame;
    private JFileChooser jfch; // file chooser for choose audio files and add to this player


    public FileUtils(MainFrameV1 mainFrame) {
        this.mainFrame = mainFrame;
        jfch = addFileChooser();
        addFileFilter(jfch, Const.EXTS);
    }

	public FileUtils(MainFrameV2 mainFrame) {
		this.mainFrame = mainFrame;
		jfch = addFileChooser();
		addFileFilter(jfch, Const.EXTS);
	}

    /**
     * Добавление песни из диалога выбора
     */
    public void addSongToPlayList(){
        int result = jfch.showOpenDialog(mainFrame.getContentPane());
        if (result == JFileChooser.APPROVE_OPTION){

            File[] selFiles = jfch.getSelectedFiles();

            if (selFiles[0].isDirectory()){
                File[] filesInDir = selFiles[0].listFiles();
                Arrays.sort(filesInDir);
                addFilesToPlaylist(filesInDir);
            } else {
                addFilesToPlaylist(selFiles);
            }

            //преобразовуем массив фалов в коллекцию фалов
//            List<File> lfiles = new ArrayList<File>();
//            for (File f : selFiles){
//                lfiles.add(f);
//            }

            addFilesToPlaylist(selFiles);
        }
    }

    /**
     * Добавление песни через DnD в playlist
     * @param files - коллекция полученных файлов
     */
//    public void addSongToPlayList(List<File> files) {
//        addFilesToPlaylist(files);
//    }

    /**
     * Добавление песни через DnD в playlist
     * @param files - массив полученных файлов
     */
    public void addSongToPlayList(File[] files){
        addFilesToPlaylist(files);
    }


    /**
     * Добавляет фалйлы в plylist
     * @param files - добавляемые файлы
     */
//    private void addFilesToPlaylist(List<File> files){
//        for(File file : files){
//            MP3 mp3 = new MP3(file.getName(), file.getPath());
//            if ( !mainFrame.getPlayListModel().contains(mp3) ){ //если такого фала в playlist нет - добавим его
//                mainFrame.getPlayListModel().addElement(mp3);
//            }
//        }
//    }

    private void addFilesToPlaylist(File[] files) {
        for(File file : files){
            MP3 mp3 = new MP3(file.getName(), file.getPath());
            if ( !mainFrame.getPlayListModel().contains(mp3) ){ //если такого фала в playlist нет - добавим его
                mainFrame.getPlayListModel().addElement(mp3);
            }
        }
    }



    /**
     * Удаление песни из playlist (JList)
     */
    public void removeSongToPlayList(){
        int[] selSongs = mainFrame.getjList1().getSelectedIndices();
        if (selSongs.length > 0){ // если выбрана хотябы одна песня
            ArrayList<MP3> mp3ListForRem = new ArrayList<MP3>(); //сохраняем все выбранные песни для удаления из playlist
            for (int i = 0; i < selSongs.length; i++) {
                MP3 mp3 = (MP3) mainFrame.getPlayListModel().getElementAt(selSongs[i]);
                mp3ListForRem.add(mp3);
            }
            for (MP3 mp3 : mp3ListForRem){
                mainFrame.getPlayListModel().removeElement(mp3);
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
        String ext = Const.SpecSym.EMPTY_STR;
        String fileName = file.getName();

        int indexForFullName = fileName.length(); //индекс для полного имени файла включая расширение (например для music.mp3 = 9)
        int indexForDot = fileName.lastIndexOf('.'); //индекс имени файла до разделителя (точка) (например для music.mp3 = 5)

        if (indexForDot > 0) {
            ext = fileName.substring(indexForDot + 1).toLowerCase();
        }
        return ext;
    }

    /**
     * Добавляем возможность добавлять файлов при помощи диалога выбора
     * @return - диалог выбора
     */
    private JFileChooser addFileChooser() {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(true);
        fc.setDialogTitle(Const.FileChooserProps.DIALOG_TITLE);
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        return fc;
    }

    /**
     * Добавление файл фильтра к диалогу выбора файлов.
     * @param jfc - экземпляр диалог выбора файлов
     * @param exts - расширения файловЮ добавляемых к файл фильтру
     */
    public void addFileFilter(JFileChooser jfc, String[] exts){
        for (String ext : exts){
            jfc.addChoosableFileFilter(new FileFilter(ext, Const.SpecSym.EMPTY_STR));
        }
    }

}
