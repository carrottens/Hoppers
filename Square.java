/**
 * This class is responsible for creating clickable tiles with pictures
 * and managing information about these tiles 
 * (location and image displayed on it in particular)
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square
{
    private ImageIcon ic[] = new ImageIcon[6];
    private JButton sq = new JButton();

    /**
     * loc (location) refers to a particular place on the board. 
     * The value from 0 to 24
     * 
     */
    private int loc;

    /**
     * check (the picture on the button) 
     * refers to a number from 0 to 5
     * 0 - Water
     * 1 - Lily Pad
     * 2 - Green Frog
     * 3 - Red Frog
     * 4 - Green Frog with a Yellow Border
     * 5 - Red Frog with a Yellow Border
     * 
     */
    private int check;

    /**
     * Constructor takes two parameters 
     * @param location records the location of this class object on the board
     * @param piece keeps track of the image on the button
     * 
     */
    Square(int location, int piece)
    {
        ic [0] = new ImageIcon("Resources/Water.png");
        ic [1] = new ImageIcon("Resources/LilyPad.png");
        ic [2] = new ImageIcon("Resources/GreenFrog.png");
        ic [3] = new ImageIcon("Resources/RedFrog.png");

        ic [4] = new ImageIcon("Resources/GreenFrog2.png");
        ic [5] = new ImageIcon("Resources/RedFrog2.png");

        check = piece;
        loc = location;

        sq = new JButton(ic[piece]);
        sq.setPreferredSize(new Dimension(140, 140));
        sq.setIcon(ic[piece]);
    }

    /**
     * An accessor to the button created in this class
     * @return JButton 
     * 
     */
    public JButton getButton()
    {
        return sq;
    }

    /**
     * It is a method which changes the icon on the button
     * and takes note of the change in parameter check
     * @param x is the number of the desired icon 
     * @see the beginning of the document for the corelation between numbers and pictures 
     * 
     */
    public void changeLable(int x)
    {
        check = x;

        sq.setIcon(ic[x]);
    }

    /**
     * An accessor to the button created in this class
     * @return JButton 
     * 
     */
    public int giveLocation()
    {
        return loc;
    }

    /**
     * An accessor to the number representing an icon
     * on the button
     * @see the beginning of the document for the corelation between numbers and pictures
     * @return int representing an icon
     * 
     */
    public int checkState()
    {
        return check;
    }


    /**
     * A mutator which allows to record a change in the
     * squares location
     * @param n the desired location
     * 
     */
    public void changeLocation(int n)
    {
        if(n < 25)
        {
            loc = n;
        }
    }
    
    /**
     * It is a method which imitates movement of a piece
     * and takes note of the location and icon changes
     * @param q is a variable of this class indicating to which square the movement is happening
     * 
     */
    public void moveTo(Square q)
    {
        //a transitional variable for swapping values
        int sw;

        sw = check;
        changeLable(q.checkState());
        q.changeLable(sw);

        sw = loc;
        loc = q.giveLocation();
        q.changeLocation(sw);
    }
}