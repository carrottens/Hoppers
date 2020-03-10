/*
        It's a class which works with level setting
        There are 40 level settings provided
        Constructor provides a 'clean board' - board without frogs
*/

import javax.swing.*;
import java.awt.*;

public class Levels
{
    private int l[] = new int[25];
    int level;

    //Constructor provides a 'clean board' - board without frogs
    Levels()
    {
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
            
            level = 0;
        }
    }

    //changes images of buttons
    private void createLevel(Square a[])
    {
        for (int i  = 0; i < 25; i++)
        {
            a[i].changeLable(l[i]);
        }
    }

    //takes a level choice (n) from 1 to 40 and a set of squares (a)
    //this method sets the level environment - 
    //changes the lables of buttons accordingly to the level standard
    public void levelChoice(int n, Square a[])
    {
        if (n == 1)
        {
            l[0] = 3;
            l[6] = 2;
        }

        if(n == 2)
        {
            l[4] = 3;
            l[14] = 2;
        }

        if(n == 3)
        {
            l[8] = 2;
            l[12] = 3;
        }

        if(n == 4)
        {
            l[0] = 3;
            l[6] = 2;
            l[18] = 2;
        }

        if(n == 5)
        {
            l[2] = 2;
            l[10] = 2;
            l[20] = 3;
        }

        if(n == 6)
        {
            l[12] = 2;
            l[14] = 3;
            l[16] = 2;
            l[18] = 2;
        }

        if(n == 7)
        {
            l[2] = 2;
            l[4] =3;
            l[10] = 2;
            l[14] = 2;
            l[22] = 2;
        }

        if(n == 8)
        {
            l[2] = 3;
            l[6] = 2;
            l[8] = 2;
            l[16] = 2;
            l[18] = 2;
        }

        if(n == 9)
        {
            l[2] = 2;
            l[6] = 2;
            l[8] = 2;
            l[12] = 3;
            l[14] = 2;
            l[18] = 2;
        }

        if(n == 10)
        {
            l[2] = 2;
            l[8] = 2;
            l[10] = 2;
            l[16] = 2;
            l[18] = 2;
            l[24] = 3;
        }

        if(n == 11)
        {
            l[0] = 3;
            l[12] = 2;
            l[18] = 2;
        }

        if(n == 12)
        {
            l[12] = 2;
            l[14] = 2;
            l[20] = 3;
        }

        if(n == 13)
        {
            l[4] = 3;
            l[6] = 2;
            l[16] = 2;
            l[22] = 2;
        }

        if(n == 14)
        {
            l[2] = 2;
            l[10] = 2;
            l[14] = 2;
            l[16] = 2;
            l[22] = 3;
            l[24] = 2;
        }

        if(n == 15)
        {
            l[0] = 2;
            l[2] = 2;
            l[14] = 2;
            l[16] = 3;
            l[18] = 2;
        }

        if(n == 16)
        {
            l[4] = 3;
            l[8] = 2;
            l[14] = 2;
        }

        if(n == 17)
        {
            l[2] = 3;
            l[12] = 2;
            l[16] = 2;
            l[18] = 2;
            l[22] = 2;
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
        }

        if(n == 21)
        {
            l[0] = 2;
            l[6] = 2;
            l[8] = 3;
            l[12] = 2;
            l[18] = 2;
            l[24] = 2;
        }

        if(n == 22)
        {
            l[6] = 2;
            l[8] = 2;
            l[12] = 2;
            l[20] = 2;
            l[22] = 3;
            l[24] = 2;
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
        }

        if(n == 25)
        {
            l[6] = 2;
            l[8] = 2;
            l[14] = 2;
            l[16] = 2;
            l[20] = 2;
            l[24] = 3; 
        }

        if(n == 26)
        {
            l[0] = 3;
            l[2] = 2;
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[18] = 2;
        }

        if(n == 27)
        {
            l[4] = 3;
            l[10] = 2;
            l[16] = 2;
            l[20] = 2;
            l[22] = 2;
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
        }

        if(n == 29)
        {
            l[2] = 3;
            l[12] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 2;
            l[24] = 2;
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
        }

        if(n == 31)
        {
            l[2] = 2;
            l[4] = 3;
            l[6] = 2;
            l[12] = 2;
            l[18] = 2;
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
        }

        if(n == 33)
        {
            l[10] = 2;
            l[12] = 3;
            l[14] = 2;
            l[16] = 2;
            l[18] = 2;
            l[22] = 2;
        }

        if(n == 34)
        {
            l[2] = 2;
            l[16] = 2;
            l[18] = 2;
            l[20] = 2;
            l[22] = 2;
            l[24] = 3;
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
        }

        if(n == 37)
        {
            l[6] = 2;
            l[10] = 2;
            l[12] = 2;
            l[18] = 2;
            l[20] = 3;
            l[22] = 2;
        }

        if(n == 38)
        {
            l[0] = 2;
            l[2] = 2;
            l[8] = 2;
            l[16] = 2;
            l[22] = 2;
            l[24] = 3;
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
        }

        createLevel(a);
    }

}