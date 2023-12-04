package flappyBirdJuego;

import java.awt.Graphics;

public interface Column {
    void move();
    void draw(Graphics g);
    int getX();
    int getWidth();
}
