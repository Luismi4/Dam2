package ejercicios;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class JuegoAdivina {
	
	private static JTextField textnum;

	private static int inte = 5;
	private static int ale = (int)(Math.random()*100);
	public static void main(String[] args) {
		
		
		
		JFrame ventana = new JFrame("Mi ventana");
		ventana.setVisible(true);
		ventana.setSize(600,400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 361);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduzca un numero: ");
		lblNewLabel.setBounds(62, 60, 130, 26);
		panel.add(lblNewLabel);
		
		textnum  = new JTextField();
		textnum.setBounds(241, 60, 99, 26);
		panel.add(textnum);
		textnum.setColumns(10);
		
		JButton btn = new JButton("Siguiente");
		btn.setBounds(251, 128, 89, 23);
		panel.add(btn);
		
		JTextArea txt = new JTextArea();
		txt.setBounds(113, 199, 289, 44);
		panel.add(txt);
		
		JButton btnre = new JButton("Reiniciar");
		btnre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn.setEnabled(true);
				btnre.setEnabled(false);
				btnre.setVisible(false);
				inte = 5;
				ale = (int)(Math.random()*100);
				
			}
		});
		btnre.setBounds(251, 276, 89, 23);
		btnre.setVisible(false);
		ventana.getContentPane().setLayout(null);
		btnre.setEnabled(false);
		panel.add(btnre);
		
		ventana.getContentPane().add(panel);
		
		
		btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textnum.getText());
                    if (num1 == ale) {
                        txt.setText("Felicidades has acertado. ");
                        txt.append("Te quedaban " + inte + " intentos");
                        btn.setEnabled(false);
                        btnre.setVisible(true);
                        btnre.setEnabled(true);
                    } else if (num1 < ale) {
                        txt.setText("El numero es mayor, ");
                        txt.append("te quedan: " + inte);
                    } else {
                        txt.setText("El numero es menor, ");
                        txt.append("te quedan: " + inte);
                    }

                    if (inte == 0) {
                        btnre.setVisible(true);
                        btnre.setEnabled(true);
                    }

                    textnum.setText("");
                    textnum.requestFocus();
                    inte--;
                } catch (NumberFormatException ex) {
                    txt.setText("Ingrese un número válido.");
                }
            }
        });
		
		
	}
}
	
		


