package Main;

import java.awt.Color;

public class Bat
{
    // Instantiation of global instance
    // variables for bat object
    private Rectangle bat;
    private GameWindow window;
    private int batLength = 100;
    private int batHeight = 20;
    private int Right = 1;
    private int Left = 2;
    private int Direction;
    // Method for creating bat
    public Bat ( int x, int y, GameWindow window )
    {
        // Bat attributes
        bat = new Rectangle(x, y, batLength, batHeight);
        bat.setBackground(Color.blue);
        window.add(bat);
        window.repaint();
        this.window = window;
    }
    // Method for moving bat
    public void move()
    {
        // Variables for bat movement
        int x = bat.getX();
        int y = bat.getY();
        int Side = window.getWidth() - batLength;
        int batSpeed = 3;

        // Moves bat left or right
        if ((Direction == Right) && (x < Side))
        {
            bat.setLocation(x + batSpeed, y);
        }
        else if ((Direction == Left) && (x > 0))
        {
            bat.setLocation(x - batSpeed, y);
        }
    }
    // Method sets direction of bat
    public void setDirection( int dir )
    {
        Direction = dir;
    }

    // Method gets width of bat
    public int getWidth()
    {
        return batLength;
    }
    // Method gets x-coordinate of bat
    public int getX()
    {
        int x = bat.getX();
        return x;
    }

    // Method gets y-coordinate of bat
    public int getY()
    {
        int y = bat.getY();
        return y;
    }

}