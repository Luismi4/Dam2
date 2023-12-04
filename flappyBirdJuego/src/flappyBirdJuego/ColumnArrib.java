package flappyBirdJuego;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;

public class ColumnArrib implements Column {

    private static final int WIDTH = 50;
    static final int GAP_SIZE = 150;

    private int x;
    private int gapStart;

    private ImageIcon topColumnImage;

    public ColumnArrib(int x, int gapStart, int windowHeight) {
        this.x = x;
        this.gapStart = gapStart;
        this.topColumnImage = getColumnAleArri();
    }

    private ImageIcon getColumnAleArri() {
    	Random random = new Random();
        int randomIndex = random.nextInt(3) + 1; 
        return new ImageIcon("column-exportAbajo0" + randomIndex + ".png");  
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
