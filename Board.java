import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class Board
{
    private JFrame screen = new JFrame("Hoppers!");

    private GridLayout gLayout = new GridLayout(5, 5);

    private JPanel p = new JPanel();

    private Square buttons[] = new Square[25]; 

    private int l[][] = new int[40][25];

    Board()
    {
        screen.setSize(750,750);

        p.setLayout(gLayout);

        for (int i = 0; i < 25; i++)
        {
            buttons[i] = new Square(i, 0);
            p.add(buttons[i].getButton());
        }

        screen.setContentPane(p);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
    }

    void setTheLevels()
    {
        l[0][0] = 1;
        l[0][1] = 0;
        l[0][2] = 1;
        l[0][3] = 0;
        l[0][4] = 1;
        l[0][5] = 0;
        l[0][6] = 2;
        l[0][7] = 0;
        l[0][8] = 2;
        l[0][9] = 0;
        l[0][10] = 1;
        l[0][11] = 0;
        l[0][12] = 2;
        l[0][13] = 0;
        l[0][14] = 1;
        l[0][15] = 0;
        l[0][16] = 1;
        l[0][17] = 0;
        l[0][18] = 1;
        l[0][19] = 0;
        l[0][20] = 2;
        l[0][21] = 0;
        l[0][22] = 3;
        l[0][23] = 0;
        l[0][24] = 2;

    }

    void createLevel()
    {
        setTheLevels();

        for (int i  = 0; i < 25; i++)
        {
            buttons[i].changeLable(l[0][i]);
        }
    }


}