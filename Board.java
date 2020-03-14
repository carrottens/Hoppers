import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.event.*;

public class Board implements ActionListener
{
    private JFrame screen = new JFrame("Hoppers!");

    private GridLayout gLayout = new GridLayout(5, 5);

    private JPanel p = new JPanel();

    private Square buttons[] = new Square[25];

    private Levels lvlSetting = new Levels();

    private int lvlTracker;

    private boolean condition;

    private int memorize;

    Board()
    {
        lvlTracker = 0;

        screen.setSize(750,750);

        p.setLayout(gLayout);

        for (int i = 0; i < 25; i++)
        {
            buttons[i] = new Square(i, 0);
            p.add(buttons[i].getButton());
            buttons[i].getButton().addActionListener(this);
        }

        lvlSetting.levelChoice(0, buttons);

        screen.setContentPane(p);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);

        condition = false;
        memorize = 0;
    }

    public void levelSetting()
    {
        lvlSetting.levelChoice(40, buttons);
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 25; i++)
        {
            if((e.getSource() == buttons[i]) && (condition == false))
            {
                condition = buttons[i].isHigh();
                if(buttons[i].isHigh())
                {
                    memorize = i;
                }
            }
            if((e.getSource() == buttons[i]) && condition)
            {
                buttons[memorize].moveTo(buttons[i]);
            }

        }

    }
    // void checkTheStuff()
    // {
    //     for (int i = 0; i < 25; i++)
    //     {
    //         System.out.println( buttons[i].giveLocation() + " square, it's occupied by " + buttons[i].checkState());
    //     }
    // }
}