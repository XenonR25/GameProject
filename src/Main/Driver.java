package Main;


import java.awt.Color;
import javax.swing.JLabel;

    public class Driver {
        // Instantiation of variables
        private GameWindow window;
        private JLabel bounces, speed;

        private Ball ball;

        public static void main(String[] args) {
            Driver d = new Driver();
            d.makeGame();
        }


        private void makeGame() {
            // Create window with animating timer and keyboard input response.
            window = new GameWindow(this);
            window.setTitle("Bounce, bounce, bounce...");
            window.setLocation(50, 50);
            window.setSize(500, 500);
            window.setBackground(Color.white);

            // Add ball and bat to window.S
            ball = new Ball(window.getWidth() / 2 - 10, window.getHeight() / 2 - 10, window);


            // add labels for speed and number of bounces
            bounces = new JLabel("Bounces: " + ball.getBounces());
            bounces.setBounds(10, 10, 150, 20);
            window.add(bounces);
            speed = new JLabel("Speed: " + ball.getSpeed());
            speed.setBounds(10, 30, 150, 20);
            window.add(speed);

            window.startTimer();
            window.repaint();
        }


        }



