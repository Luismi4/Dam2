package juegoMemoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class JuegoMemoria extends JFrame {
    private ArrayList<JButton> cartas;
    private JButton primeraCarta, segundaCarta;
    private Timer temporizador;

    public JuegoMemoria() {
        setTitle("Juego de Memoria");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cartas = new ArrayList<>();
        temporizador = new Timer(1000, new EscuchaTemporizador());

        inicializarCartas();
        configurarInterfaz();

        setVisible(true);
    }

    private void inicializarCartas() {
        for (int i = 1; i <= 8; i++) {
            cartas.add(crearCarta(i));
            cartas.add(crearCarta(i));
        }
        Collections.shuffle(cartas);
    }

    private JButton crearCarta(int numero) {
        JButton carta = new JButton("");
        carta.setFont(new Font("Arial", Font.BOLD, 20));
        carta.setFocusPainted(false);
        carta.addActionListener(new EscuchaClickCarta());
        carta.putClientProperty("numero", numero);
        return carta;
    }

    private void configurarInterfaz() {
        setLayout(new GridLayout(4, 4));

        for (JButton carta : cartas) {
            add(carta);
        }
    }

    private class EscuchaClickCarta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton cartaClickeada = (JButton) e.getSource();

            if (!temporizador.isRunning() && cartaClickeada != segundaCarta) {
                revelarCarta(cartaClickeada);

                if (primeraCarta == null) {
                    primeraCarta = cartaClickeada;
                } else {
                    segundaCarta = cartaClickeada;
                    comprobarCoincidencia();
                }
            }
        }

        private void revelarCarta(JButton carta) {
            int numero = (int) carta.getClientProperty("numero");
            carta.setText(Integer.toString(numero));
        }

        private void comprobarCoincidencia() {
            if (primeraCarta != null && segundaCarta != null) {
                int primerNumero = (int) primeraCarta.getClientProperty("numero");
                int segundoNumero = (int) segundaCarta.getClientProperty("numero");

                if (primerNumero == segundoNumero) {
                    primeraCarta.setEnabled(false);
                    segundaCarta.setEnabled(false);
                    resetearCartas();
                    comprobarFinJuego();
                } else {
                    temporizador.start();
                }
            }
        }

        private void comprobarFinJuego() {
            boolean todasCoinciden = cartas.stream().noneMatch(carta -> carta.isEnabled());
            if (todasCoinciden) {
                JOptionPane.showMessageDialog(JuegoMemoria.this, "¡Has ganado!");
                reiniciarJuego();
            }
        }
    }

    private void ocultarCarta(JButton carta) {
        carta.setText("");
        carta.setEnabled(true);
    }

    private void resetearCartas() {
        primeraCarta = null;
        segundaCarta = null;
    }

    private class EscuchaTemporizador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultarCarta(primeraCarta);
            ocultarCarta(segundaCarta);
            resetearCartas();
            temporizador.stop();
        }

        private void ocultarCarta(JButton carta) {
            carta.setText("");
        }
    }

    private void reiniciarJuego() {
        for (JButton carta : cartas) {
            carta.setEnabled(true);
            ocultarCarta(carta);
        }
        Collections.shuffle(cartas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoMemoria());
    }
}
