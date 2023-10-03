package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CambVen1 {

	private static JFrame ventanaPrincipal;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearVentanaPrincipal();
            }
        });
    }

    private static void crearVentanaPrincipal() {
        ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(300, 200);
        ventanaPrincipal.setLayout(new BorderLayout());

        JButton botonAbrirSegundaVentana = new JButton("Abrir Segunda Ventana");
        botonAbrirSegundaVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirSegundaVentana();
            }
        });

        ventanaPrincipal.add(botonAbrirSegundaVentana, BorderLayout.CENTER);
        ventanaPrincipal.setVisible(true);
    }

    private static void abrirSegundaVentana() {
        JFrame segundaVentana = new JFrame("Segunda Ventana");
        segundaVentana.setBounds(100, 100, 150, 150);
        segundaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        segundaVentana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                ventanaPrincipal.setEnabled(true);
            }
        });

        JButton botonVolver = new JButton("Volver a la Primera Ventana");
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                segundaVentana.setVisible(false);
                ventanaPrincipal.setEnabled(true);
            }
        });

        segundaVentana.add(botonVolver, BorderLayout.CENTER);
        segundaVentana.setVisible(true);

        ventanaPrincipal.setEnabled(false);
    }
}
