package Calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejecalc {

	private JFrame frame;
	private JTextField textField;

	private static int num1 = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejecalc window = new ejecalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ejecalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 11, 345, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CALCULADORA");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 23));
		lblNewLabel.setBounds(406, 11, 204, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "1");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton.setBounds(71, 65, 95, 61);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "4");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1.setBounds(71, 137, 95, 61);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("7");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "7");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1.setBounds(71, 209, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("8");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "8");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1.setBounds(176, 209, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("5");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "5");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1_1.setBounds(176, 137, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("2");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "2");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(176, 65, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("3");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "3");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1_1_1_1.setBounds(281, 65, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("6");
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "6");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setBounds(281, 137, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1_1 = new JButton("9");
		btnNewButton_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "9");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_1_1_1_1_1_1_1_1.setBounds(281, 209, 95, 61);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_2 = new JButton("0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textField.setText(textField.getText() + "0");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton_2.setBounds(176, 281, 95, 61);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				
			}
		});
		btnNewButton_3.setBounds(406, 65, 204, 43);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("-");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(406, 119, 204, 43);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("X");
		btnNewButton_5.setBounds(406, 173, 204, 43);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("÷");
		btnNewButton_6.setBounds(406, 228, 204, 43);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("=");
		btnNewButton_7.setBounds(406, 281, 204, 43);
		frame.getContentPane().add(btnNewButton_7);
	}
}
