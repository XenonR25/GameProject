package Main;
import javax.swing.*;
import java.awt.*;


    public class Oval extends JComponent
    {

        public Oval( int x, int y, int w, int h )
        {
            super();
            setBounds( x, y, w, h );
            setBackground( Color.black );
        }


        public void paint( Graphics g )
        {
            g.setColor( getBackground() );
            g.fillOval( 0, 0, getWidth(), getHeight() );
            paintChildren( g );
        }
    }

