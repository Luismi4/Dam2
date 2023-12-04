package pruebasFlappyBird;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class ColumnArriba {

    static final int GAP_SIZE = 150;

    private int x;
    private int gapStart;

    private ImageIcon topColumnImage;


    public ColumnArriba(int x, int gapStart, int windowHeight) {
        this.x = x;
        this.gapStart = gapStart;
        this.topColumnImage = getColumnAleArri();
    }

    private ImageIcon getColumnAleArri() {
        int gapStart = new Random().nextInt((int) (GAP_SIZE)); // Ajusta según tus necesidades
        return new ImageIcon("column-exportAbajo0.png"); // Cambia por el nombre de tu imagen
    }


    public void move() {
        x -= 5;
    }

    public void draw(Graphics g) {
        topColumnImage.paintIcon(null, g, x, 0);
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return topColumnImage.getIconWidth(); // Usa topColumnImage para obtener el ancho
    }

    public int getHeight() {
        return topColumnImage.getIconHeight(); // Usa topColumnImage para obtener la altura
    }

    public int getGapStart() {
        return gapStart;
    }

    public int getGapSize() {
        return GAP_SIZE;
    }
	
}
