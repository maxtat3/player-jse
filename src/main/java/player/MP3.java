package player;

import utils.FileUtils;

import java.io.Serializable;

/**
 * Created by max on 02.09.14.
 */
public class MP3 implements Serializable{

    public static final String LOG_TAG = MP3.class.getName() + " : ";

    private String name;
    private String path;


    public MP3(String name, String path) {
        this.name = name;
        this.path = path;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return FileUtils.getFileNameWithoutExtension(name);
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof MP3) ){
//            System.out.println(LOG_TAG + "false");
            return false;
        }
        MP3 mp3 = (MP3) obj;
//        System.out.println(LOG_TAG + "true");
        return path.equals(mp3.getPath());
    }
}
