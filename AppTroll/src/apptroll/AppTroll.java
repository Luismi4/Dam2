package apptroll;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppTroll {
    public static void main(String[] args) {
    	TrollVentana();
    }
    
    public static void TrollVentana() {
    	JFrame frame = new JFrame("Ventana No Cerrable y No Minimizable");
    	int num1 = (int) (Math.random()*1000)+1;
    	int num2 = (int) (Math.random()*1000)+1;
        frame.setBounds(num1, num2, num2, num1);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TrollVentana();
            }

            @Override
            public void windowIconified(WindowEvent e) {
                frame.setExtendedState(JFrame.NORMAL);
                TrollVentana();
            }
        });

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}






