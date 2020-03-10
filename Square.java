import javax.swing.*;
import java.awt.*;

public class Square
{
    private ImageIcon ic[] = new ImageIcon[6];
    private JButton sq = new JButton();

    int loc;
    int check;

    Square(int a, int b)
    {
        ic [0] = new ImageIcon("Water.png");
        ic [1] = new ImageIcon("LilyPad.png");
        ic [2] = new ImageIcon("GreenFrog.png");
        ic [3] = new ImageIcon("RedFrog.png");

        ic [4] = new ImageIcon("GreenFrog2.png");
        ic [5] = new ImageIcon("RedFrog2.png");

        check = b;

        sq = new JButton(ic[b]);

        sq.setIcon(ic[b]);

        loc = a;

    }

    public JButton getButton()
    {
        return sq;
    }

    public JButton changeLable(int x)
    {
        check = x;

        sq.setIcon(ic[x]);

        return sq;
    }

    public int giveLocation()
    {
        return loc;
    }

    public int checkState()
    {
        return check;
    }
}