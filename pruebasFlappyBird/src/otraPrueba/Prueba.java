package otraPrueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class Bird {
    public int x;
    public int y;
    public int velocity;
    public static final int BIRD_SIZE = 30;

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

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
}

class Column {
    public int x;
    public int height;
    public boolean scored;
    public static final int WIDTH = 50;
    public static final int COLUMN_GAP = 150;
    public static final int GAP_SIZE = 150;

    public Column(int x, int height) {
        this.x = x;
        this.height = height;
        this.scored = false;
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
    
    public int getX() {
        return x;
    }
    
    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

	public int getWidth() {
		// TODO Auto-generated method stub
		return WIDTH;
	}
    
}

public class Prueba extends JFrame {
    public Bird bird;
    public List<Column> columns;
    private static final int GROUND_HEIGHT = 600;
    public int score = 0;
    


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
        checkScore();
    }
    
    private void checkScore() {
        for (Column column : columns) {
            if (!column.isScored() && column.getX() + column.getWidth() < bird.getX()) {
                // El pájaro ha pasado la columna
                score++;
                column.setScored(true);
                System.out.println("Score: " + score); // Puedes mostrar la puntuación en la consola o en otro lugar
            }
        }
    }

    private void generateColumns() {
        if (columns.isEmpty() || columns.get(columns.size() - 1).getX() < WIDTH - 300) {
            int gapStart = new Random().nextInt(GROUND_HEIGHT - Column.GAP_SIZE);
            columns.add(new Column(WIDTH, HEIGHT));
        }

        // Reiniciar el estado de puntuación al generar nuevas columnas
        for (Column column : columns) {
            column.setScored(false);
        }
    }

    public void moveColumns() {
        for (Column column : columns) {
            column.move();
        }
        columns.removeIf(column -> column.x + column.WIDTH < 0);
    }

    public void checkCollisions() {
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

    public void gameOver() {
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


