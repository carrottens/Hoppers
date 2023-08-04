/**
 * This class works with level settings
 * There are 40 level settings provided, which are initialised depending on 
 * the level choice in method levelChoice
 * 
 */

import javax.swing.*;
import java.awt.*;

public class Levels
{
    /**
     * l is an array its values record the numbers representing images 
     * and index represents the location of the Square on the board
     * @see Square class documentation for the corelation between images and numbers
     */
    private int l[] = new int[25];

    //the number of green frogs depending on the level
    int greenFrogs;

    /**
     * Constructor provides a setting for a 'clean board' 
     * sometimes also referred as the level 0
     * (board without any frogs)
     * 
     */
    Levels()
    {
        //Tiles switch between lily pads and water
        for (int i  = 0; i < 25; i++)
        {
            if(i%2 == 0)
            {
                l[i] = 1;
            }
            else
            {
                l[i] = 0;
            }
            
        }

        greenFrogs = 0;
    }

    /**
    * It is a method which changes the icons of an array of Squares
    * depending on the records made in the array
    * @param a is an array of Squares used on the board
    *
    */
    private void createLevel(Square a[])
    {
        for (int i  = 0; i < 25; i++)
        {
            a[i].changeLable(l[i]);
        }
    }

    /**
     * It is a method which resets the board to an empty one
     * @param an array of Squares which are displayed on the board
     * 
     */
    public void wipeBoard(Square a[])
    {
        for (int i  = 0; i < 25; i++)
        {
            if(i%2 == 0)
            {
                l[i] = 1;
            }
        }
        
        createLevel(a);
    }

    /**
     * This method takes a level choice and sets the level environment
     * by applying suitable lables to an array of Squares
     * It also sets the number of green frogs in each of them
     * @ param n an int from 1 to 40 which represents the level
     * @ param a is an array of Squares placed on the board 
     * It uses the same corelation between images and number like the Square class
     * @see Square class documentation for the corelation between images and numbers
     * @see the beginning of this documentation for details on usage of an array l
     * 
     */
    public void levelChoice(int n, Square a[])
    {
        if (n == 1)
        {
            l[0] = 3;
            l[6] = 2;
            greenFrogs = 1;
        }

        if(n == 2)
        {
            l[4] = 3;
            l[14] = 2;
            greenFrogs = 1;
        }

        if(n == 3)
        {
            l[8] = 2;
            l[12] = 3;
            greenFrogs = 1;
        }

        if(n == 4)
        {
            l[0] = 3;
            l[6] = 2;
            l[18] = 2;
            greenFrogs = 2;
        }

        if(n == 5)
        {
            l[2] = 2;
            l[10] = 2;
            l[20] = 3;
            greenFrogs = 2;
        }

        if(n == 6)
        {
            l[12] = 2;
            l[14] = 3;
            l[16] = 2;
            l[18] = 2;
            greenFrogs = 3;
        }

        if(n == 7)
        {
            l[2] = 2;
            l[4] = 3;
            l[10] = 2;
            l[14] = 2;
            l[22] = 2;
            greenFrogs = 4;
        }

        if(n == 8)
        {
            l[2] = 3;
            l[6] = 2;
            l[8] = 2;
            l[16] = 2;
            l[18] = 2;
            greenFrogs = 4;
        }

        if(n == 9)
        {
            l[2] = 2;
            l[6] = 2;
            l[8] = 2;
            l[12] = 3;
            l[14] = 2;
            l[18] = 2;
            greenFrogs = 5;
        }

        if(n == 10)
        {
            l[2] = 2;
            l[8] = 2;
            l[10] = 2;
            l[16] = 2;
            l[18] = 2;
            l[24] = 3;
            greenFrogs = 5;
        }

        if(n == 11)
        {
            l[0] = 3;
            l[12] = 2;
            l[18] = 2;
            greenFrogs = 2;
        }

        if(n == 12)
        {
            l[12] = 2;
            l[14] = 2;
            l[20] = 3;
            greenFrogs = 2;
        }

        if(n == 13)
        {
            l[4] = 3;
            l[6] = 2;
            l[16] = 2;
            l[22] = 2;
            greenFrogs = 3;
        }

        if(n == 14)
        {
            l[2] = 2;
            l[10] = 2;
            l[14] = 2;
            l[16] = 2;
            l[22] = 3;
            l[24] = 2;
            greenFrogs = 5;
        }

        if(n == 15)
        {
            l[0] = 2;
            l[2] = 2;
            l[14] = 2;
            l[16] = 3;
            l[18] = 2;
            greenFrogs = 4;
        }

        if(n == 16)
        {
            l[4] = 3;
            l[8] = 2;
            l[14] = 2;
            greenFrogs = 2;
        }

        if(n == 17)
        {
            l[2] = 3;
            l[12] = 2;
            l[16] = 2;
            l[18] = 2;
            l[22] = 2;
            greenFrogs = 4;
        }

        if(n == 18)
        {
            l[2] = 2;
            l[10] = 2;
            l[12] = 2;
            l[14] = 2;
            l[16] = 2;
            l[18] = 2;
            l[22] = 3;
            greenFrogs = 6;
        }

        if(n == 19)
        {
            l[0] = 2;
            l[2] = 2;
            l[8] = 2;
            l[10] = 3;
            l[16] = 2;
            l[18] = 2;
            l[22] = 2;
            greenFrogs = 6;

        }

        if(n == 20)
        {
            l[2] = 2;
            l[4] = 2;
            l[6] = 2;
            l[8] = 2;
            l[14] = 2;
            l[16] = 3;
            l[18] = 2;
            greenFrogs = 6;
        }

        if(n == 21)
        {
            l[0] = 2;
            l[6] = 2;
            l[8] = 3;
            l[12] = 2;
            l[18] = 2;
            l[24] = 2;
            greenFrogs = 5;
        }

        if(n == 22)
        {
            l[6] = 2;
            l[8] = 2;
            l[12] = 2;
            l[20] = 2;
            l[22] = 3;
            l[24] = 2;
            greenFrogs = 5;
        }

        if(n == 23)
        {
            l[4] = 2;
            l[6] = 2;
            l[8] = 2;
            l[12] = 2;
            l[16] = 2;
            l[20] = 2;
            l[24] = 3;
            greenFrogs = 6;
        }

        if(n == 24)
        {
            l[2] = 2;
            l[6] = 2;
            l[8] = 2;
            l[10] = 2;
            l[12] = 2;
            l[16] = 2;
            l[24] = 3;
            greenFrogs = 6;
        }

        if(n == 25)
        {
            l[6] = 2;
            l[8] = 2;
            l[14] = 2;
            l[16] = 2;
            l[20] = 2;
            l[24] = 3; 
            greenFrogs = 5;
        }

        if(n == 26)
        {
            l[0] = 3;
            l[2] = 2;
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[18] = 2;
            greenFrogs = 5;
        }

        if(n == 27)
        {
            l[4] = 3;
            l[10] = 2;
            l[16] = 2;
            l[20] = 2;
            l[22] = 2;
            greenFrogs = 4;
        }

        if(n == 28)
        {
            l[2] = 3;
            l[6] = 2;
            l[8] = 2;
            l[10] = 2;
            l[14] = 2;
            l[20] = 2;
            l[24] = 2;
            greenFrogs = 6;
        }

        if(n == 29)
        {
            l[2] = 3;
            l[12] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 2;
            l[24] = 2;
            greenFrogs = 5;
        }

        if(n == 30)
        {
            l[0] = 2;
            l[2] = 2;
            l[6] = 2;
            l[8] = 2;
            l[10] = 2;
            l[16] = 2;
            l[24] = 3;
            greenFrogs = 6;
        }

        if(n == 31)
        {
            l[2] = 2;
            l[4] = 3;
            l[6] = 2;
            l[12] = 2;
            l[18] = 2;
            greenFrogs = 4;
        }

        if(n == 32)
        {
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 3;
            l[22] = 2;
            greenFrogs = 6;
        }

        if(n == 33)
        {
            l[10] = 2;
            l[12] = 3;
            l[14] = 2;
            l[16] = 2;
            l[18] = 2;
            l[22] = 2;
            greenFrogs = 5;
        }

        if(n == 34)
        {
            l[2] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 2;
            l[22] = 2;
            l[24] = 3;
            greenFrogs = 5;
        }

        if(n == 35)
        {
            l[0] = 2;
            l[4] = 2;
            l[6] = 2;
            l[8] = 2;
            l[16] = 2;
            l[18] = 2;
            l[24] = 3;
            greenFrogs = 6;
        }

        if(n == 36)
        {
            l[2] = 2;
            l[6] = 2;
            l[8] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 2;
            l[24] = 3;
            greenFrogs = 6;
        }

        if(n == 37)
        {
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[18] = 2;
            l[20] = 3;
            l[22] = 2;
            greenFrogs = 6;
        }

        if(n == 38)
        {
            l[0] = 2;
            l[2] = 2;
            l[8] = 2;
            l[16] = 2;
            l[22] = 2;
            l[24] = 3;
            greenFrogs = 5;
        }

        if(n == 39)
        {
            l[0] = 3;
            l[4] = 2;
            l[8] = 2;
            l[10] = 2;
            l[12] = 2;
            l[16] = 2;
            l[22] = 2;
            greenFrogs = 6;
        }

        if(n == 40)
        {
            l[4] = 2;
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[18] = 2;
            l[20] = 3;
            l[22] = 2;
            greenFrogs = 6;
        }

        createLevel(a);
    }

    /**
     * This is an accessor to the number of frogs in the current level
     * @return greenFrogs - the current number of green frogs in current level
     * 
     */
    public int numberOfFrogs()
    {
        return greenFrogs;
    }

    /**
     * This is a mutator which decreases the recorded number of 
     * frogs in the current level
     * 
     */
    public void decreaseInFrogs()
    {
        greenFrogs--;
    }

}