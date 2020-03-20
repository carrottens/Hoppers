/**
 * This class is responsible for:
 * the user interface,
 * game logic,
 * AND
 * communication between other classes
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.event.*;

public class Board implements ActionListener
{
    private JFrame screen = new JFrame("Hoppers!");

    private GridLayout frogPanelLayout = new GridLayout(5, 5);
    private GridLayout levelMenuLayout = new GridLayout(10, 4);
    private FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER);
    private BorderLayout bLayout = new BorderLayout();

    private JPanel frogPanel = new JPanel();
    private JPanel levelsPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel others = new JPanel();

    private JLabel messages = new JLabel("      Welcome to Hoppers!!!");
    private JLabel levelPickMessage = new JLabel("Pick a level:");
    private JButton lvlButtons[] = new JButton[40];

    private Square buttons[] = new Square[25];

    private Levels lvlSetting = new Levels();

    /**
     * This boolean keeps track if any frogs are selected
     * true - if a frog has a yellow border
     * false - if not
     * 
     */
    private boolean condition;

    /**
     * This variable keeps the index in the array of Squares
     * of the first selected to move frog
     * 
     */
    private int memorize;

    /**
     * This variable keeps the index in the array of Squares
     * of the frog in between the moving frog and its destination
     * 
     */
    private int middle;

    /*
        This constructor deals with the placement of panels and buttons
        It also adds action listener to level buttons and 
        the tiles of the gaming board
    */
    Board() 
    {
        messages.setPreferredSize(new Dimension(200, 150));

        screen.setSize(1000, 750);

        //this part specifies layouts
        levelsPanel.setLayout(levelMenuLayout);
        mainPanel.setLayout(fLayout);
        frogPanel.setLayout(frogPanelLayout);
        others.setLayout(bLayout);

        //initialises and adds the Squares to a panel
        for (int i = 0; i < 25; i++) 
        {
            buttons[i] = new Square(i, 0);
            frogPanel.add(buttons[i].getButton());
            buttons[i].getButton().addActionListener(this);
        }

        //initialises and adds the level buttons to a panel
        for (int i = 0; i < 40; i++)
        {
            lvlButtons[i] = new JButton("" + (i + 1));
            lvlButtons[i].setPreferredSize(new Dimension(50, 50));
            lvlButtons[i].addActionListener(this);
            levelsPanel.add(lvlButtons[i]);
        }

        //sets the level
        lvlSetting.levelChoice(0, buttons);

        //places the panels into one another and ensures tidy layout
        others.add("North", levelPickMessage);
        others.add("Center", levelsPanel);
        others.add("South", messages);
        mainPanel.add(frogPanel);
        mainPanel.add(others);
        
        //finishes setting screen parameters and makes the interface visable
        screen.setContentPane(mainPanel);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);

        /*  
            sets all of the variables which will be used in methods to zero
            to catch out as many errors
        */
        condition = false;
        memorize = 0;
        middle = 0;
    }


    /**
     * This method checks the validity of a frogs jump
     * @param a is the location of the frog selected to make a jump
     * @param b is the desired destination of the jump
     * @result if the jump is valid the location of the middle frog is returned,
     * however, if the jump is not possible, this method returns 0
     * 
     */
    private int  middleFrog(int a, int b)
    {
        //checks the validity of diagonal jumps down the board
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
        
        //checks the validity of diagonal jumps up the board
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

        //checks the validity of horizontal jumps from left to right
        if( (a == 0 || a == 10 || a == 20) && (a + 4 == b) )
        {
            return a + 2;
        }

        //checks the validity of horizontal jumps from right to left
        if( (a == 4 || a == 14 || a == 24) && (a - 4 == b) )
        {
            return a - 2;
        }

        //checks the validity of vertical jumps down the board
        if( (a == 0 || a == 2 || a == 4) && (a + 20 == b) )
        {
            return a + 10;
        }

        //checks the validity of vertical jumps up the board
        if( (a == 20 || a == 22 || a == 24) && (a - 20 == b) )
        {
            return a - 10;
        }

        return 0;
    } 

    /**
     * This method works with responses to the actions taken by the user
     * @param e is the action of the user pressing a button
     * 
     */
    public void actionPerformed(final ActionEvent e)
    {
        /*
            this part of action performed method sets proper reactions
            when a certain button from class Square is pressed 
            (the buttons on the gaming board)
        */
        for(int i = 0; i < 25; i++)
        {
            /*
                memorises an index in the Squares array for the frog which is selected to jump
                and marks that frog by applying a frame (changes the icon on the button)
            */
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

            /*
                filters a valid destination for a jump,
                completes the jump and takes away the frog 
                which was in the middle of the jump
            */
            if((e.getSource() == buttons[i].getButton()) && condition && (e.getSource() != buttons[memorize].getButton()) && buttons[i].checkState() == 1 && middleFrog(memorize, i) > 0 && buttons[middleFrog(memorize, i)].checkState() == 2)
            {
                middle = middleFrog(memorize, i);
                buttons[memorize].moveTo(buttons[i]);
                
                //takes away the middle frog
                buttons[middle].changeLable(1);
                lvlSetting.decreaseInFrogs();
                if(lvlSetting.numberOfFrogs() == 0)
                {
                    messages.setText("      Congratulations! You won!"); //Victory message!!!
                }

                //takes away the frame and changes the condition in order that other frogs could be selected
                condition = false;
                if(buttons[i].checkState() == 4)
                {
                    buttons[i].changeLable(2);

                }
                if(buttons[i].checkState() == 5)
                {
                    buttons[i].changeLable(3);
                }
            }

            /*
                if the jump is invalid the frog is unselected 
                for a more convenient gameplay
            */
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

        /*
            this part of action performed method sets a level environment
            responding to a level selection button lable 
            (the buttons on the right hand-side of the screen)
        */
        for (int j = 0; j < 40; j++)
        {
            if(e.getSource() == lvlButtons[j])
            {
                lvlSetting.wipeBoard(buttons);
                lvlSetting.levelChoice(j+1, buttons);
                messages.setText("      Welcome to Hoppers!!!");
            }
        }

    }
}