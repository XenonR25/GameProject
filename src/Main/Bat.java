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



}