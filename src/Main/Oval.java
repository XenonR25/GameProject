package Main;
import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Oval extends JComponent
    {
        private Random random;


        public Oval( int x, int y, int w, int h )
        {
            super();

            setBounds( x, y, w, h );
            setBackground( Color.black);
            random = new Random();
        }


        public void paint( Graphics g )
        {


            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g.fillOval( 0, 0, getWidth(), getHeight() );
            paintChildren( g );
        }


        }






