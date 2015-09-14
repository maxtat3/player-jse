package listners;

import app.Const;
import gui.MainFrameV1;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;


/**
 * Created by max on 26.09.14.
 */
public class TestActionListner extends EventObject implements ActionListener, ChangeListener {


    private MainFrameV1 mainFrameV1;

    public TestActionListner(MainFrameV1 mainFrameV1) {
        super(mainFrameV1.getJbtnPlay());
        this.mainFrameV1 = mainFrameV1;
//        mainFrameV1.getJbtnPlay().addActionListener(this);
//        mainFrameV1.getJbtnPlay().addActionListener(this);
//        mainFrameV1.getJslVolume().addChangeListener(this);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (mainFrameV1.getJbtnPlay().getActionCommand().equals("play")){
            System.out.println("this is play button");
        }

//        if ( !(e.getSource() instanceof JButtonM) ){
//            System.out.println("-not JButtonM");
//            return;
//        }
//        System.out.println("-is JButtonM");
//
//        JButtonM jbtn = (JButtonM)e.getSource();
//
//        if (jbtn.getActionCommand().equals(Const.ButtonProps.PLAY)){
//            System.out.println("-is JButtonModPlay");
//        }



//        if ( !(e.getSource() instanceof JButton) ){
//            System.out.println("-not JButtonM");
//            return;
//        }
//
//        JButton jbtn = (JButton) e.getSource();
//
//        if (jbtn.getActionCommand().equals(Const.ButtonProps.PAUSE)){
//            System.out.println("-is JButtonM");
//        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println("change listner - state changed");
        if (mainFrameV1.getJslVolume().getName().equals(Const.SliderProps.VOLUME_NAME)){
            System.out.println("this is volume slider");
        }
    }


}
