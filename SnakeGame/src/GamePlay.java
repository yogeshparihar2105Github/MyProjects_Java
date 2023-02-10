import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXLen = new int[750];
    private int[] snakeYLen = new int[750];

    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightMouth;
    private ImageIcon leftMouth;
    private ImageIcon upMouth;
    private ImageIcon downMouth;
    private ImageIcon snakeImage;

    private Timer timer;
    private int delay = 100;

    private int lenghtOfSnake = 3;
    private int  moves = 0;
    private ImageIcon titleImage;

    public GamePlay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics g)
    {
        if(moves == 0)
        {
            snakeXLen[0] = 100;
            snakeXLen[1] = 75;
            snakeXLen[2] = 50;

            snakeYLen[0] = 100;
            snakeYLen[1] = 100;
            snakeYLen[2] = 100;
        }
        
        //border of title image
        g.setColor(Color.white);
        g.drawRect(24,10, 851,55);

        titleImage = new ImageIcon("assets/snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);

        //border of gamePlay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        //painting snake
        rightMouth = new ImageIcon("assets/rightmouth.png");
        rightMouth.paintIcon(this, g, snakeXLen[0], snakeYLen[0]);

        for(int i = 0; i < lenghtOfSnake; i++)
        {
            if(i == 0 && right)
            {
                rightMouth = new ImageIcon("assets/rightmouth.png");
                rightMouth.paintIcon(this, g, snakeXLen[i], snakeYLen[i]);
            }
            if(i == 0 && left)
            {
                leftMouth = new ImageIcon("assets/leftmouth.png");
                leftMouth.paintIcon(this, g, snakeXLen[i], snakeYLen[i]);
            }
            if(i == 0 && up)
            {
                upMouth = new ImageIcon("assets/upmouth.png");
                upMouth.paintIcon(this, g, snakeXLen[i], snakeYLen[i]);
            }
            if(i == 0 && down)
            {
                downMouth = new ImageIcon("assets/downmouth.png");
                downMouth.paintIcon(this, g, snakeXLen[i], snakeYLen[i]);
            }

            if(i != 0)
            {
                snakeImage = new ImageIcon("assets/snakeimage.png");
                snakeImage.paintIcon(this, g, snakeXLen[i], snakeYLen[i]);
            }
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(right)
        {
            for(int i = lenghtOfSnake - 1; i >= 0; i--)
            {
                snakeYLen[i+1] = snakeYLen[i];
            }
            for(int i = lenghtOfSnake; i >= 0; i--)
            {
                if(i==0)
                {
                    snakeXLen[i] = snakeXLen[i] + 25;
                }
                else
                {
                    snakeXLen[i] = snakeXLen[i-1];
                }
                if(snakeXLen[i] > 850)
                {
                    snakeXLen[i] = 25;
                }
            }
            repaint();
        }
        if(left)
        {
            for(int i = lenghtOfSnake - 1; i >= 0; i--)
            {
                snakeYLen[i+1] = snakeYLen[i];
            }
            for(int i = lenghtOfSnake; i >= 0; i--)
            {
                if(i==0)
                {
                    snakeXLen[i] = snakeXLen[i] - 25;
                }
                else
                {
                    snakeXLen[i] = snakeXLen[i-1];
                }
                if(snakeXLen[i] < 25)
                {
                    snakeXLen[i] = 850;
                }
            }
            repaint();
        }

        if(up)
        {
            for(int i = lenghtOfSnake - 1; i >= 0; i--)
            {
                snakeXLen[i+1] = snakeXLen[i];
            }
            for(int i = lenghtOfSnake; i >= 0; i--)
            {
                if(i==0)
                {
                    snakeYLen[i] = snakeYLen[i] - 25;
                }
                else
                {
                    snakeYLen[i] = snakeYLen[i-1];
                }
                if(snakeYLen[i] < 75)
                {
                    snakeYLen[i] = 625;
                }
            }
            repaint();
        }
        if(down)
        {
            for(int i = lenghtOfSnake - 1; i >= 0; i--)
            {
                snakeXLen[i+1] = snakeXLen[i];
            }
            for(int i = lenghtOfSnake; i >= 0; i--)
            {
                if(i==0)
                {
                    snakeYLen[i] = snakeYLen[i] + 25;
                }
                else
                {
                    snakeYLen[i] = snakeYLen[i-1];
                }
                if(snakeYLen[i] > 625)
                {
                    snakeYLen[i] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //right move
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            moves++;
            if(left != true)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        //left move
        if(e.getKeyCode()== KeyEvent.VK_LEFT)
        {
            moves++;
            if(right != true)
            {
                left = true;
            }
            else
            {
                right = true;
                left = false;
            }
            up = false;
            down = false;
        }

        //up move
        if(e.getKeyCode()== KeyEvent.VK_UP)
        {
            moves++;
            if(down != true)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        //down move
        if(e.getKeyCode()== KeyEvent.VK_DOWN)
        {
            moves++;
            if(up != true)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
