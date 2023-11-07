package ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Act1 {

    public static void main(String[] args) {
        Map<String, Double> notas;
        notas = new HashMap<>();

        JFrame frame = new JFrame("Gestión de Notas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("Nombre del estudiante:");
        JTextField nombreField = new JTextField(20);
        JLabel notaLabel = new JLabel("Nota:");
        JTextField notaField = new JTextField(5);

        JButton agregarButton = new JButton("Agregar Nota");
        JButton verButton = new JButton("Ver Notas");
        JButton corregirButton = new JButton("Corregir Nota");
        JButton eliminarButton = new JButton("Eliminar Nota");

        panel.add(label);
        panel.add(nombreField);
        panel.add(notaLabel);
        panel.add(notaField);
        panel.add(agregarButton);
        panel.add(verButton);
        panel.add(corregirButton);
        panel.add(eliminarButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    double nota = Double.parseDouble(notaField.getText());
                    notas.put(nombre, nota);
                    JOptionPane.showMessageDialog(frame, "Nota agregada con éxito.");
                    nombreField.setText("");
                    notaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese una nota válida.");
                }
            }
        });

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder notasStr = new StringBuilder("Notas de Estudiantes:\n");
                for (Map.Entry<String, Double> entry : notas.entrySet()) {
                    notasStr.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, notasStr.toString());
            }
        });

        corregirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    double nota = Double.parseDouble(notaField.getText());
                    if (notas.containsKey(nombre)) {
                        notas.put(nombre, nota);
                        JOptionPane.showMessageDialog(frame, "Nota corregida con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "El estudiante no existe en la lista de notas.");
                    }
                    nombreField.setText("");
                    notaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese una nota válida.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    if (notas.containsKey(nombre)) {
                        notas.remove(nombre);
                        JOptionPane.showMessageDialog(frame, "Nota eliminada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "El estudiante no existe en la lista de notas.");
                    }
                    nombreField.setText("");
                    notaField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese una nota válida.");
                }
            }
        });

        frame.setVisible(true);
    }
}