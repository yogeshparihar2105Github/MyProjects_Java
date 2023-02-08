import javax.swing.*;
import java.awt.*;
public class GamePlay extends JPanel {

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
}
