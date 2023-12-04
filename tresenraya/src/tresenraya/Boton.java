package tresenraya;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    private int fila;
    private int columna;

    public Boton(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        setFont(new Font("Arial", Font.PLAIN, 40));
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
