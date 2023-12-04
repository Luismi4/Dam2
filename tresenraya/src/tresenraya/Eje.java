package tresenraya;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Eje extends JFrame implements ActionListener {

	private Boton[][] buttons;
    private boolean turnoJugador;
    private boolean juegoTerminado;

    public Eje() {
        buttons = new Boton[3][3];
        turnoJugador = true;
        juegoTerminado = false;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("3 en Raya");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Boton(i, j);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Eje());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (juegoTerminado) {
            return; 
        }

        Boton button = (Boton) e.getSource();
        if (button.getText().equals("")) {
            button.setText("X");
            turnoJugador = !turnoJugador;

            if (haGanado()) {
                JOptionPane.showMessageDialog(this, "¡Has ganado! Esto no debería haber pasado...");
                juegoTerminado = true;
            } else if (tableroLleno()) {
                JOptionPane.showMessageDialog(this, "¡Empate!");
                juegoTerminado = true;
            } else if (!turnoJugador) {
                jugarMaquina();
            }
        }
    }

    private void jugarMaquina() {
        int[] mejorMovimiento = minimax(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        buttons[mejorMovimiento[0]][mejorMovimiento[1]].setText("O");

        turnoJugador = true;

        if (haGanado()) {
            JOptionPane.showMessageDialog(this, "¡La máquina ha ganado!");
        } else if (tableroLleno()) {
            JOptionPane.showMessageDialog(this, "¡Empate!");
        }
        reiniciarJuego();
    }

    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        juegoTerminado = false;
    }

    private int[] minimax(int alfa, int beta, int profundidad, boolean esTurnoJugador) {
        int[] mejorMovimiento = {-1, -1};
        int mejorPuntaje = esTurnoJugador ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText(esTurnoJugador ? "X" : "O");
                    int puntajeActual = minimaxRecursivo(alfa, beta, profundidad + 1, !esTurnoJugador);
                    buttons[i][j].setText("");

                    if (esTurnoJugador && puntajeActual > mejorPuntaje) {
                        mejorPuntaje = puntajeActual;
                        mejorMovimiento[0] = i;
                        mejorMovimiento[1] = j;
                        alfa = Math.max(alfa, puntajeActual);
                    } else if (!esTurnoJugador && puntajeActual < mejorPuntaje) {
                        mejorPuntaje = puntajeActual;
                        mejorMovimiento[0] = i;
                        mejorMovimiento[1] = j;
                        beta = Math.min(beta, puntajeActual);
                    }

                    if (alfa >= beta) {
                        // Poda alfa-beta
                        return mejorMovimiento;
                    }
                }
            }
        }

        return mejorMovimiento;
    }

    private int minimaxRecursivo(int alfa, int beta, int profundidad, boolean esTurnoJugador) {
        if (haGanado()) {
            return esTurnoJugador ? -1 : 1;
        } else if (tableroLleno() || profundidad >= 5) {
            return 0;
        }

        int mejorPuntaje = esTurnoJugador ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText(esTurnoJugador ? "X" : "O");
                    int puntajeActual = minimaxRecursivo(alfa, beta, profundidad + 1, !esTurnoJugador);
                    buttons[i][j].setText("");

                    if (esTurnoJugador) {
                        mejorPuntaje = Math.max(mejorPuntaje, puntajeActual);
                        alfa = Math.max(alfa, puntajeActual);
                    } else {
                        mejorPuntaje = Math.min(mejorPuntaje, puntajeActual);
                        beta = Math.min(beta, puntajeActual);
                    }

                    if (alfa >= beta) {
                        // Poda alfa-beta
                        return mejorPuntaje;
                    }
                }
            }
        }

        return mejorPuntaje;
    }

    private boolean haGanado() {
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().equals("") &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText())) {
                return true;
            }

            if (!buttons[0][i].getText().equals("") &&
                    buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText())) {
                return true; 
            }
        }

        if (!buttons[0][0].getText().equals("") &&
                buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())) {
            return true; 
        }

        return !buttons[0][2].getText().equals("") &&
                buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()); 
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false; 
                }
            }
        }
        return true;
    }
}
