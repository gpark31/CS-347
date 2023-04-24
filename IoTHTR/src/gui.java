import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    public static JFrame frame;
    public static void startGui(){
        frame = new JFrame("IoT HTR Control Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700,700);
        frame.setLayout(null);
    }
    public static void endGui(){
        frame.dispose();
    }
    public static void addImage(String s){
        ImageIcon im;
        JLabel label = new JLabel();
        if(s.equals("warning")){
            im = new ImageIcon("/Users/gayou/IdeaProjects/IoTHTR/src/warning.png");
            label = new JLabel(im);
            label.setBounds(550, 50, 100, 100);
        }
        else if(s.equals("emergency")){
            im = new ImageIcon("/Users/gayou/IdeaProjects/IoTHTR/src/emergency.png");
            label = new JLabel(im);
            label.setBounds(550, 250, 100, 100);
        }
        else if(s.equals("honk")){
            im = new ImageIcon("/Users/gayou/IdeaProjects/IoTHTR/src/honk.png");
            label = new JLabel(im);
            label.setBounds(550, 500, 100, 100);
        }
        frame.add(label);
    }
}
