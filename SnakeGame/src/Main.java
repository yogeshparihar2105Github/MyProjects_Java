import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setTitle("Snake Game");
        f.setBounds(10, 10, 905, 700);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.DARK_GRAY);

        GamePlay gamePlay = new GamePlay();
        f.add(gamePlay);
        f.setVisible(true);
    }
}
