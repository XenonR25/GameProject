package Main;

import javax.swing.*;
import java.awt.*;

    public class Rectangle extends JComponent
    {

        public Rectangle(int x, int y, int w, int h )
        {
            super();
            setBounds( x, y, w, h );
            setBackground( Color.BLACK );
        }

        public void paint( Graphics g )
        {
            g.setColor( getBackground() );
            g.fillRect( 0, 0, getWidth(), getHeight() );
            paintChildren( g );
        }
    }

