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

    private Levels lvlSetting = new Levels();


    Board()
    {
        screen.setSize(750,750);

        p.setLayout(gLayout);

        for (int i = 0; i < 25; i++)
        {
            buttons[i] = new Square(i, 0);
            p.add(buttons[i].getButton());
        }

        lvlSetting.levelChoice(0, buttons);

        screen.setContentPane(p);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
    }

    void vyksta()
    {
        lvlSetting.levelChoice(40, buttons);
    }
}