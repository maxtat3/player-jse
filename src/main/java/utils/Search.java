package utils;

import gui.AllJComp;
import gui.MainFrameV1;
import player.MP3;

import java.util.ArrayList;

/**
 * Created by max on 19.09.14.
 */
public class Search {

    private AllJComp mainFrame;


    public Search() {
    }

    public Search(AllJComp mainFrame) {
        this.mainFrame = mainFrame;
    }


    public void searchInPlayList(){
        String text = mainFrame.getJtfLiveSearch().getText();

//        если ничего не введено - выйти
        if (text.equals("") || text == null){
            return;
        }

        ArrayList<Integer> indexes = new ArrayList<Integer>(); //коллекция для индексов playlist

        for (int i = 0; i < mainFrame.getPlayListModel().size(); i++){
            MP3 mp3 = (MP3) mainFrame.getPlayListModel().getElementAt(i);
            if (mp3.getName().toUpperCase().contains(text.toUpperCase())){
                indexes.add(i);
            }
        }

        int[] selIndexes = new int[indexes.size()];

//        если ничего не найдено
//        if (selIndexes.length == 0){
//            JOptionPane.showMessageDialog(mainFrame.getContentPane(),"ничего не найдено !");
//            mainFrame.getJtfLiveSearch().requestFocus();
//            return;
//        }

//        преобразуем коллекцию в массив
        for (int i = 0; i < indexes.size(); i++){
            selIndexes[i] = indexes.get(i).intValue();
        }

//        выделяем найденный песни по их индексам а playlist
        mainFrame.getjList1().setSelectedIndices(selIndexes);
    }
}
