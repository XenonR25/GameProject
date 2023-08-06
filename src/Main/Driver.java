package Main;


import java.awt.Color;
import javax.swing.*;

public class Driver {
        // Instantiation of variables
        private GameWindow window;
        private JLabel bounces, speed;

        private Bat bat;
        private Ball ball;

        public static void main(String[] args) {
            Driver d = new Driver();
            d.makeGame();
        }


        private void makeGame() {

            window = new GameWindow(this);
            window.setTitle("PONG");
            window.setLocation(50, 50);
            window.setSize(500, 500);
            window.setBackground(Color.lightGray);

            ball = new Ball(window.getWidth() / 2 - 10, window.getHeight() / 2 - 10, window);
            bat  = new Bat( window.getWidth()/ 2 - 50, window.getHeight() - 50, window);


            bounces = new JLabel("Bounces: " + ball.getBounces());
            bounces.setBounds(10, 10, 150, 20);
            window.add(bounces);
            speed = new JLabel("Speed: " + ball.getSpeed());
            speed.setBounds(420, 10, 150, 20);
            window.add(speed);

            window.startTimer();
            window.repaint();
        }
        public void handleAction( int action )
        {
            if ( action == GameWindow.MOVE )
            {
                ball.checkBatHit( bat );
                ball.move();
                ball.checkBatHit( bat );
                bat.move();
                ball.checkBatHit( bat );
                bounces.setText( "Bounces: " + ball.getBounces() );
                speed.setText( "Speed: " + ball.getSpeed() );
            }
            else
            {
                bat.setDirection( action );
            }
        }


        }



