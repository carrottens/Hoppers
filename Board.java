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

    private int middle;

    private boolean moved;

    Board() 
    {
        lvlTracker = 0;

        screen.setSize(750, 750);

        p.setLayout(gLayout);

        for (int i = 0; i < 25; i++) {
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
        lvlTracker = 0;
        middle = 0;
        moved = false;
    }

    public void levelSetting() 
    {
        lvlSetting.levelChoice(40, buttons);
    }

    public int  middleFrog(int a, int b)
    {
        if(a < 15)
        {
            if( (a + 4 == 6 && a + 8 == b) || (a + 6 == 6 && a + 12 == b) )
            {
                return 6;
            }

            if( (a + 4 == 8 && a + 8 == b) || (a + 6 == 8 && a + 12 == b) )
            {
                return 8;
            }

            if( (a + 4 == 12 && a + 8 == b) || (a + 6 == 12 && a + 12 == b) )
            {
                return 12;
            }

            if( (a + 4 == 16 && a + 8 == b) || (a + 6 == 16 && a + 12 == b) )
            {
                return 16;
            }

            if( (a + 4 == 18 && a + 8 == b) || (a + 6 == 18 && a + 12 == b) )
            {
                return 18;
            }
        }
        
        if(a > 9)
        {
            if( (a - 4 == 6 && a - 8 == b) || (a - 6 == 6 && a - 12 == b) )
            {
                return 6;
            }

            if( (a - 4 == 8 && a - 8 == b) || (a - 6 == 8 && a - 12 == b) )
            {
                return 8;
            }

            if( (a - 4 == 12 && a - 8 == b) || (a - 6 == 12 && a - 12 == b) )
            {
                return 12;
            }

            if( (a - 4 == 16 && a - 8 == b) || (a - 6 == 16 && a - 12 == b) )
            {
                return 16;
            }

            if( (a - 4 == 18 && a - 8 == b) || (a - 6 == 18 && a - 12 == b) )
            {
                return 18;
            }
        }

        if( (a == 0 || a == 10 || a == 20) && (a + 4 == b) )
        {
            return a + 2;
        }

        if( (a == 4 || a == 14 || a == 24) && (a - 4 == b) )
        {
            return a - 2;
        }

        if( (a == 0 || a == 2 || a == 4) && (a + 20 == b) )
        {
            return a + 10;
        }

        if( (a == 20 || a == 22 || a == 24) && (a - 20 == b) )
        {
            return a - 10;
        }

        return 0;
    } 

    public void actionPerformed(final ActionEvent e)
    {
        for(int i = 0; i < 25; i++)
        {
            if((e.getSource() == buttons[i].getButton()) && (condition == false))
            {
                memorize = i;

                if(buttons[i].checkState() == 2)
                {
                    buttons[i].changeLable(4);
                    condition = true;
                }

                if(buttons[i].checkState() == 3)
                {
                    buttons[i].changeLable(5);
                    condition = true;
                }

            }

            if((e.getSource() == buttons[i].getButton()) && condition && (e.getSource() != buttons[memorize].getButton()) && buttons[i].checkState() == 1 && middleFrog(memorize, i) > 0 && buttons[middleFrog(memorize, i)].checkState() == 2)
            {
                middle = middleFrog(memorize, i);
                buttons[memorize].moveTo(buttons[i]);
                moved = true;
                condition = false;

                buttons[middle].changeLable(1);

                if(buttons[i].checkState() == 4)
                {
                    buttons[i].changeLable(2);

                }
                if(buttons[i].checkState() == 5)
                {
                    buttons[i].changeLable(3);
                }
            }

            if((e.getSource() == buttons[i].getButton()) && buttons[middleFrog(memorize, i)].checkState() != 2 && (e.getSource() != buttons[memorize].getButton()))
            {
                if(buttons[memorize].checkState() == 4)
                {
                    buttons[memorize].changeLable(2);

                }
                if(buttons[memorize].checkState() == 5)
                {
                    buttons[memorize].changeLable(3);
                }

                condition = false;
            }

        }

    }
}