package pruebasFlappyBird;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class ColumnAbajo {

    static final int GAP_SIZE = 150;

    private int x;
    private int gapStart;

    private ImageIcon bottomColumnImage;

    public ColumnAbajo(int x, int gapStart, int windowHeight) {
        this.x = x;
        this.gapStart = gapStart;
        this.bottomColumnImage = getRandomColumnImage();
    }

    private ImageIcon getRandomColumnImage() {
        Random random = new Random();
        int randomIndex = random.nextInt(3) + 1;
        return new ImageIcon("column-export0" + randomIndex + ".png");
    }

    public void move() {
        x -= 5;
    }

    public void draw(Graphics g) {
        bottomColumnImage.paintIcon(null, g, x, gapStart + GAP_SIZE);
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return bottomColumnImage.getIconWidth();
    }

    public int getHeight() {
        return bottomColumnImage.getIconHeight();
    }

    public int getGapStart() {
        return gapStart;
    }
	
}
