package flappyBirdJuego;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class ColumnAba implements Column {
	private static final int WIDTH = 50;
    static final int GAP_SIZE = 150;

    private int x;
    private int gapStart;


    private ImageIcon bottomColumnImage;

    public ColumnAba(int x, int gapStart, int windowHeight) {
        this.x = x;
        this.gapStart = gapStart;

        this.bottomColumnImage = getColumnAleAba();
    }

    private ImageIcon getColumnAleAba() {
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

    public int getGapStart() {
        return gapStart;
    }

    public int getGapSize() {
        return GAP_SIZE;
    }

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
