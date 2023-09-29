package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class pulsnum {

	private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pulsnum window = new pulsnum();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public pulsnum() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setForeground(new Color(255, 255, 255));
        textField.setBackground(new Color(0, 0, 255));
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char tecla = e.getKeyChar();
                try {
                    // Only allow '1', '2', or '3' to be typed into the text field
                    if (tecla != '1' && tecla != '2' && tecla != '3') {
                        e.consume();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        textField.setBounds(10, 11, 414, 42);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Pulsa 1");
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setOpaque(true);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textField.setText(textField.getText() + "1");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setBounds(174, 64, 89, 33);
        panel.add(btnNewButton);

        JButton btnPulsa = new JButton("Pulsa 2");
        btnPulsa.setForeground(new Color(255, 255, 255));
        btnPulsa.setBackground(new Color(255, 0, 0));
        btnPulsa.setOpaque(true);
        btnPulsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textField.setText(textField.getText() + "2");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnPulsa.setBounds(174, 108, 89, 33);
        panel.add(btnPulsa);

        JButton btnPulsa_1 = new JButton("Pulsa 3");
        btnPulsa_1.setForeground(new Color(255, 255, 255));
        btnPulsa_1.setBackground(new Color(255, 0, 0));
        btnPulsa_1.setOpaque(true);
        btnPulsa_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textField.setText(textField.getText() + "3");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnPulsa_1.setBounds(174, 152, 89, 33);
        panel.add(btnPulsa_1);

        JButton btnre = new JButton("Limpia");
        btnre.setBackground(new Color(255, 255, 255));
        btnre.setForeground(new Color(255, 0, 0));
        btnre.setOpaque(true);
        btnre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textField.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnre.setBounds(174, 196, 89, 33);
        panel.add(btnre);
    }
}
