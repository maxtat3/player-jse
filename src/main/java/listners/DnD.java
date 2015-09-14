package listners;

import gui.jcompw.JListW;
import utils.FileUtils;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * Created by max on 08.10.14.
 */
public class DnD {

    private FileUtils fileUtils;


    public DnD(JListW jListW, FileUtils fileUtils) {
        this.fileUtils = fileUtils;
        jListW.setTransferHandler(handler);
    }


    /**
     * Обработчик события drag and drop
     */
    private TransferHandler handler = new TransferHandler() {

        public boolean canImport(TransferSupport support) {
            if (!support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                return false;
            }

            boolean copySupported = (COPY & support.getSourceDropActions()) == COPY;

            if (!copySupported) {
                return false;
            }

            support.setDropAction(COPY);

            return true;
        }

        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable t = support.getTransferable();

            try {
                List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                fileOrDirChecked(files);

            } catch (UnsupportedFlavorException e) {
                return false;
            } catch (IOException e) {
                return false;
            }

            return true;
        }
    };


    /**
     * Проверка, является ли полученный список файлом(файлами)\каталогом
     * Каталог, это тот же файл, но определеными свойствами
     * Если выделено несколько каталогов, то в playlist добавляется
     * самый первый
     * @param list - коллекция файлов\каталог
     */
    private void fileOrDirChecked(List<File> list){
        if (list.get(0).isDirectory()){
            File[] filesInDir = list.get(0).listFiles();
            Arrays.sort(filesInDir); //выполняем сортировку по возрастанию
            submitFiles(filesInDir);
        } else {
            File [] files = new File[list.size()];
            for (int i = 0; i < list.size(); i++) {
                files[i] = list.get(i);
            }
            submitFiles(files);
        }
    }

    /**
     * Передача файлов полученных из ФС при помощи DnD
     * Здесь должен осуществлятся вызов метода , который
     * отвечает за добавлние файлов в playlist
     * @param files - полученный массив файлов при помощи DnD
     */
    private void submitFiles(File[] files){
        fileUtils.addSongToPlayList(files);
    }

    /**
     * Передача файлов полученных из ФС при помощи DnD
     * Здесь должен осуществлятся вызов метода , который
     * отвечает за добавлние файлов в playlist
     * @param files - полученная коллекция файлов при помощи DnD
     */
//    private void submitFiles(java.util.List<File> files){
//        fileUtils.addSongToPlayList(files);
//    }

}
