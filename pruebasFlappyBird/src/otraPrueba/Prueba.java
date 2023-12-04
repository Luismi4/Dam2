package otraPrueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bird {
    private int x;
    private int y;
    private int velocity;
    static final int BIRD_SIZE = 30;

    public Bird() {
        x = 100;
        y = 300;
        velocity = 0;
    }

    public void jump() {
        velocity = -10;
    }

    public void update() {
        velocity += 1;
        y += velocity;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, BIRD_SIZE, BIRD_SIZE);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, BIRD_SIZE, BIRD_SIZE);
    }

    public int getY() {
        return y;
    }
}

class Column {
    int x;
    private int height;
    static final int WIDTH = 50;
    private static final int COLUMN_GAP = 150;

    public Column(int x, int height) {
        this.x = x;
        this.height = height;
    }

    public void move() {
        x -= 5;
    }

    public boolean collidesWith(Bird bird) {
        Rectangle columnBounds = new Rectangle(x, 0, WIDTH, height);
        Rectangle gapBounds = new Rectangle(x, height + COLUMN_GAP, WIDTH, 400);
        return columnBounds.intersects(bird.getBounds()) || gapBounds.intersects(bird.getBounds());
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, 0, WIDTH, height);
        g.fillRect(x, height + COLUMN_GAP, WIDTH, 400);
    }
}

public class Prueba extends JFrame {
    private Bird bird;
    private List<Column> columns;

    public Prueba() {
        setTitle("Flappy Bird");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bird = new Bird();
        columns = new ArrayList<>();

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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
        bird.update();
        generateColumns();
        moveColumns();
        checkCollisions();
    }

    private void generateColumns() {
        if (columns.isEmpty() || columns.get(columns.size() - 1).x < getWidth() - 300) {
            int columnHeight = new Random().nextInt(getHeight() - 200) + 50;
            columns.add(new Column(getWidth(), columnHeight));
        }
    }

    private void moveColumns() {
        for (Column column : columns) {
            column.move();
        }
        columns.removeIf(column -> column.x + column.WIDTH < 0);
    }

    private void checkCollisions() {
        for (Column column : columns) {
            if (column.collidesWith(bird)) {
                gameOver();
                return;
            }
        }

        if (bird.getY() + bird.BIRD_SIZE > getHeight() || bird.getY() < 0) {
            gameOver();
        }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over!");
        bird = new Bird();
        columns.clear();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        bird.draw(g);

        for (Column column : columns) {
            column.draw(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Prueba();
            }
        });
    }
}



