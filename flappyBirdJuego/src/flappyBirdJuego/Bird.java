package flappyBirdJuego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bird {

	private int x;
    private int y;
    private int velocity;

    private ImageIcon birdImage;

    public Bird() {
        x = 100;
        y = 300;
        velocity = 0;
        int birdWidth = 50;
        int birdHeight = 50;
        birdImage = new ImageIcon(new ImageIcon("bird.png").getImage().getScaledInstance(birdWidth, birdHeight, Image.SCALE_DEFAULT));
        if (birdImage.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error al cargar la imagen del pájaro.");
        }
    }

    public void jump() {
        velocity = -10;
    }

    public void update() {
        velocity += 1;
        y += velocity;
    }

    public void draw(Graphics g) {
        birdImage.paintIcon(null, g, x, y);
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return birdImage.getIconHeight();
    }

    public boolean intersects(ColumnArrib column) {
        Rectangle birdRect = new Rectangle(x, y, birdImage.getIconWidth(), birdImage.getIconHeight());
        Rectangle columnRect = new Rectangle(column.getX(), 0, column.getWidth(), column.getGapStart());
        Rectangle lowerColumnRect = new Rectangle(column.getX(), column.getGapStart() + column.getGapSize(), column.getWidth(), column.getHeight() - column.getGapStart() - column.getGapSize());
        return birdRect.intersects(columnRect) || birdRect.intersects(lowerColumnRect);
    }
	
}
