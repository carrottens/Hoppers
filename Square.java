import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square //implements ActionListener
{
    private ImageIcon ic[] = new ImageIcon[6];
    private JButton sq = new JButton();

    private int loc;
    private int check;

    private int sw;

    private boolean highlight;

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
        //sq.addActionListener(this);

        highlight = false;
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

    public void changeLocation(int n)
    {
        if(n < 25)
        {
            loc = n;
        }
    }

    public void moveTo(Square q)
    {
            sw = check;
            changeLable(q.checkState());
            q.changeLable(sw);

            sw = loc;
            loc = q.giveLocation();
            q.changeLocation(sw);

            sw = 0;
    }

    // public boolean isHigh()
    // {
    //     return highlight;
    // }

    // public void actionPerformed(ActionEvent e)
    // {

    // }

}