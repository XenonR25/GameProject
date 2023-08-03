/**
 * Draws a simple graphical rectangle.
 *
 * @author Dave Riley
 * @author M. Allen
 */
import javax.swing.*;
import java.awt.*;

@SuppressWarnings( "serial" )
public class Rectangle extends JComponent
{
    /**
     * post: getX() == x and getY() == y and getWidth() == w and getHeight() ==
     * h and getBackground() == Color.black
     */
    public Rectangle( int x, int y, int w, int h )
    {
        super();
        setBounds( x, y, w, h );
        setBackground( Color.black );
    }


}