package flappyBirdJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Eje extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int GROUND_HEIGHT = HEIGHT - 50;

    private List<Column> columns;
    private List<ColumnArrib> column;
    private Bird bird;
    private boolean inGame;

    private Image groundImage;

    public Eje() {
        setTitle("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        columns = new ArrayList<>();
        bird = new Bird();
        inGame = true;

        // Cargar imagen del suelo
        groundImage = new ImageIcon("ground.jpg").getImage();  // Ajusta el nombre de tu imagen para el suelo

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        timer.start();

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
        if (columns.isEmpty() || columns.get(columns.size() - 1).getX() < WIDTH - 300) {
            // Selecciona aleatoriamente si se genera una columna arriba o abajo
            boolean generateTop = new Random().nextBoolean();
            int gapStart;
            if (generateTop) {
                gapStart = new Random().nextInt(GROUND_HEIGHT - ColumnArrib.GAP_SIZE);
                columns.add(new ColumnArrib(WIDTH, gapStart, HEIGHT));
            } else {
                gapStart = new Random().nextInt(GROUND_HEIGHT - ColumnAba.GAP_SIZE);
                columns.add(new ColumnAba(WIDTH, gapStart, HEIGHT));
            }
        }
    }
    private void moveColumns() {
        for (Column column : columns) {
            column.move();
        }
        columns.removeIf(column -> column.getX() + column.getWidth() < 0);
    }

    private void checkCollision() {
        for (ColumnArrib column : column) { // Utiliza el tipo correcto en el bucle
            if (bird.intersects(column)) {
                inGame = false;
                JOptionPane.showMessageDialog(this, "Game Over!");
                restartGame();
                break;
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
        columns.clear();
        inGame = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (ColumnArrib column : column) {
            column.draw(g);
        }

        bird.draw(g);

        g.setColor(Color.orange);
        g.fillRect(0, GROUND_HEIGHT, WIDTH, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Eje();
            }
        });
    }
}