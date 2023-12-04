package pruebasFlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;


public class FlappyBirdGame extends JFrame {

	private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int GROUND_HEIGHT = HEIGHT - 50;

    private List<ColumnArriba> columnsArriba;
    private List<ColumnAbajo> columnsAbajo;
    private Bird bird;
    private boolean inGame;

    public FlappyBirdGame() {
        setTitle("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        columnsArriba = new ArrayList<>();
        columnsAbajo = new ArrayList<>();
        bird = new Bird();
        inGame = true;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Timer timer = new Timer(20, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateGame();
                        repaint();
                    }
                });
                timer.start();
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && inGame) {
                    bird.jump();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        setFocusable(true);
        setVisible(true);
    }

    private void updateGame() {
        if (inGame) {
            bird.update();
            generateColumn();
            moveColumns();
            checkCollision();
        }
    }

    private void generateColumn() {
        if (columnsArriba.isEmpty() || columnsArriba.get(columnsArriba.size() - 1).getX() < WIDTH - 300) {
            int gapStartArriba = 0; // Comienza justo en el borde superior
            columnsArriba.add(new ColumnArriba(WIDTH, gapStartArriba, HEIGHT));
        }

        if (columnsAbajo.isEmpty() || columnsAbajo.get(columnsAbajo.size() - 1).getX() < WIDTH - 300) {
            int gapStartAbajo = GROUND_HEIGHT - ColumnAbajo.GAP_SIZE; // Comienza justo en el borde inferior
            columnsAbajo.add(new ColumnAbajo(WIDTH, gapStartAbajo, HEIGHT));
        }
    }


    private void moveColumns() {
        for (ColumnArriba column : columnsArriba) {
            column.move();
        }
        columnsArriba.removeIf(column -> column.getX() + column.getWidth() < 0);

        for (ColumnAbajo column : columnsAbajo) {
            column.move();
        }
        columnsAbajo.removeIf(column -> column.getX() + column.getWidth() < 0);
    }

    private void checkCollision() {
        for (ColumnArriba column : columnsArriba) {
            if (bird.intersects(column)) {
                inGame = false;
                JOptionPane.showMessageDialog(this, "Game Over!");
                restartGame();
                return;  // Sale del método si hay una colisión
            }
        }

        for (ColumnAbajo column : columnsAbajo) {
            if (bird.intersects(column)) {
                inGame = false;
                JOptionPane.showMessageDialog(this, "Game Over!");
                restartGame();
                return;  // Sale del método si hay una colisión
            }
        }

        if (bird.getY() + bird.getHeight() > GROUND_HEIGHT || bird.getY() < 0) {
            inGame = false;
            JOptionPane.showMessageDialog(this, "Game Over!");
            restartGame();
        }
    }

    private void restartGame() {
        bird = new Bird();
        columnsArriba.clear();
        columnsAbajo.clear();
        inGame = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (ColumnArriba column : columnsArriba) {
            column.draw(g);
        }

        for (ColumnAbajo column : columnsAbajo) {
            column.draw(g);
        }

        bird.draw(g);

        g.setColor(Color.orange);
        g.fillRect(0, GROUND_HEIGHT, WIDTH, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlappyBirdGame();
            }
        });
    }
}
	
