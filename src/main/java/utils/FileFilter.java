package utils;

import java.io.File;

/**
 * Created by max on 06.10.14.
 */
public class FileFilter extends javax.swing.filechooser.FileFilter {

    private String ext; // расширение файла
    private String discr; //"описание" расширения файла, которое будет отображатся в диалоге выбора типа файла

    public FileFilter(String ext, String discr) {
        this.ext = ext;
        this.discr = discr;
    }


    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getAbsolutePath().endsWith(ext);
    }

    @Override
    public String getDescription() {
        return discr + " *." + ext;
    }

}
