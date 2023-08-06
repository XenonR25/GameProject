package Main;
import Main.Oval;

import java.awt.Color;
import javax.swing.JLabel;

public class Ball
{

    private Oval ball;
    private JLabel end;
    private int ballSize = 20;
    private int batLength = 100;
    private int ballSpeed = 1;
    private int upRight = 1;
    private int upLeft = 2;
    private int downRight = 3;
    private int downLeft = 4;
    private int Counter;
    private int Direction;
    private int winSize = 500;
    private int gameOver = 100;
    private GameWindow window;


    public Ball ( int x, int y, GameWindow window )
    {
        ball = new Oval(x, y, ballSize, ballSize);
        ball.setBackground(Color.red);
        window.add(ball);
        window.repaint();
        this.window = window;
        Direction = (int)(Math.random() * 2 + 1);
    }

    public void move()
    {
       
        int x = ball.getX();
        int y = ball.getY();
        int Right = window.getWidth() - ballSize;
        int Base = window.getBottomEdge();

        if (Direction == upRight)
        {
            ball.setLocation(x + ballSpeed, y - ballSpeed);
        }

        // Movement is up and to the left
        else if (Direction == upLeft)
        {
            ball.setLocation(x - ballSpeed, y - ballSpeed);
        }

        // Movement is down and to the right
        else if (Direction == downRight)
        {
            ball.setLocation(x + ballSpeed, y + ballSpeed);
        }

        // Movement is down and to the left
        else if (Direction == downLeft)
        {
            ball.setLocation(x - ballSpeed, y + ballSpeed);
        }

        if ((x <= 0) && (y <= 0))
        {
            Direction = downRight;
        }

        // upRight and hitting right corner of window
        else if ((x >= Right) && (y <= 0))
        {
            Direction = downLeft;
        }

        else if ((Direction == upRight) && (x >= Right))
        {
            Direction = upLeft;
        }

        // upLeft and hitting left side of window
        else if ((Direction == upLeft) && (x <= 0))
        {
            Direction = upRight;
        }

        else if ((Direction == downRight) && (x >= Right))
        {
            Direction = downLeft;
        }

        else if ((Direction == downLeft) && (x <= 0))
        {
            Direction = downRight;
        }

        else if ((Direction == upRight) && (y <= 0))
        {
            Direction = downRight;
        }

        else if ((Direction == upLeft) && (y <= 0))
        {
            Direction = downLeft;
        }

        else if ((Direction == downRight || Direction == downLeft) && (y >= Base))
        {
            window.stopTimer();
            end = new JLabel( "Game Over");
            end.setBackground(Color.RED);
            end.setBounds( (winSize/2 - gameOver/3), (winSize/2 - gameOver/3), gameOver, gameOver);
            window.add( end );
            window.repaint();
        }

    }

    public void checkBatHit( Bat b )
    {
        // Instantiation of variables for collision
        int batX = b.getX();
        int batY = b.getY();
        int ballX = ball.getX();
        int ballY = ball.getY();

        if ((Direction == downRight) && (ballY >= batY - ballSize) && (ballY <= batY - ballSize + ballSpeed) && (ballX >= batX) && (ballX <= batX + batLength))
        {
            Counter++;

            if (Counter % 5 == 0)
            {
                ballSpeed++;
            }

            Direction = upRight;
        }


        else if ((Direction == downLeft) && (ballY >= batY - ballSize) && (ballY <= batY - ballSize + ballSpeed) && (ballX >= batX) && (ballX <= batX + batLength))
        {
            Counter++;

            if (Counter % 5 == 0)
            {
                ballSpeed++;
            }

            Direction = upLeft;
        }

    }

    public int getBounces()
    {
        return Counter;
    }

    public int getSpeed()
    {
        return ballSpeed;
    }

}