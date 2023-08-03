package Main;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.*;

public class GameWindow extends JFrame implements ActionListener, KeyListener
{
    // Control constants.
    public final static int MOVE = 0;
    public final static int RIGHT = 1;
    public final static int LEFT = 2;
    public final static int STOP = 3;

    private Driver driver;
    private Timer timer;


    public GameWindow( Driver d )
    {
        super( "Window" );
        setLocation( 0, 0 );
        setLayout( null );
        setResizable( false );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        addKeyListener( this );
        driver = d;
        timer = new Timer( 5, this );
    }

    public void startTimer()
    {
        timer.start();
    }


    public void stopTimer()
    {
        timer.stop();
    }


    public void setBackground( java.awt.Color c )
    {
        getContentPane().setBackground( c );
    }


    public int getBottomEdge()
    {
        return getHeight() - getInsets().bottom - getInsets().top;
    }


    public void setSize( int w, int h )
    {
        super.setSize( w + getInsets().left + getInsets().right,
                h + getInsets().top + getInsets().bottom );
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == timer )
        {
            driver.handleAction( MOVE );
        }
    }

    @Override
    public void keyPressed( KeyEvent k )
    {
        int key = k.getKeyCode();

        // 'J' == LEFT; 'K' == RIGHT
        if ( key == KeyEvent.VK_J )
        {
            driver.handleAction( LEFT );
        }
        else if ( key == KeyEvent.VK_K )
        {
            driver.handleAction( RIGHT );
        }
    }

    @Override
    public void keyReleased( KeyEvent k )
    {
        driver.handleAction( STOP );
    }

    @Override
    public void keyTyped( KeyEvent k )
    {
        // DOES NOTHING
    }
}