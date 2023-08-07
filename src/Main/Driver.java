package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Driver extends JPanel implements KeyListener, ActionListener {

   // private Sound sound;


    private boolean play= false;
    private int score= 0;
    //final int totalBricks= 160;

    final Timer timer;

    final int delay= 8;

    private int playerX= 280;


    //public int level =1 ;

    private int ballPosX= 340;

    private int ballPosY= 500;

    private int ballXdir= -1;

    private int ballYdir= -2;

    private mapGenerator map;

    Sound sound = new Sound();
    Thread gameThread;


    public Driver(){
        map= new mapGenerator(score,12,20);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        if(true)
        {
            timer= new Timer(delay, this);
            timer.start();
        }

    }
    public void setupGame(){
        playMusic(0);
    }

    public void startGameThread(){
        gameThread = new Thread((Runnable) this);
        gameThread.start();
    }


    public void paint(Graphics g){

        g.setColor(Color.darkGray);
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);

        g.setColor(Color.ORANGE);

        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(682, 0, 3, 592);
        g.fillRect(0, 560, 692, 592);

        g.setColor(Color.magenta);
        g.setFont(new Font("Dialog", Font.BOLD, 25));
        g.drawString("Score: "+score, 10, 30);





        g.setColor(Color.CYAN);
        g.fillRect(playerX, 550, 150, 50);

        g.setColor(Color.RED);
        g.fillOval(ballPosX, ballPosY, 18, 18);

        if(false){
            play= false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString(" Congratulation , Score: "+score, 260, 500);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 470);
        }

        if(ballPosY>570){
            play= false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.green);
            g.setFont(new Font("SansSerif", Font.BOLD, 30));
            g.drawString(" Game Over, Score: "+score, 190, 500);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 470);
        }

        g.dispose();

    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(play){
            if(new Rectangle(ballPosX, ballPosY, 20,  20).intersects(new Rectangle(playerX, 550, 280, 8))){
                score+=1;


                ballYdir= -ballYdir;
            }


            A: for(int i=0 ;  i<map.map.length ; i++){
                for(int j=0 ; j<map.map[0].length ; j++){
                    if(map.map[i][j]>0){
                        int brickX = j*map.brickWidth+80;
                        int brickY = i* map.brickHeight+50;
                        int brickWidth= map.brickWidth;
                        int brickHeight= map.brickHeight;

                        Rectangle rect= new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect= new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect= rect;

                        if(ballRect.intersects(brickRect)){


                            map= new mapGenerator(score,12,20);

                            if(ballPosX+19<= brickRect.x || ballPosX+1>= brickRect.x + brickRect.width){
                                ballXdir= -ballXdir;
                            }
                            else{
                                ballYdir= -ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }
            ballPosX+= ballXdir;
            ballPosY+= ballYdir;

            if(ballPosX<0){
                ballXdir= -ballXdir;
            }
            if(ballPosY<0){
                ballYdir= -ballYdir;
            }
            if(ballPosX>670){
                ballXdir= -ballXdir;
            }

        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            if(playerX>=525){
                playerX= 525;
            }
            else{
                moveright(120);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            if(playerX<15){
                playerX= 15;
            }
            else{
                moveleft(120);
            }
        }


        if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_SPACE){
            if(!play){


                play= true;
                ballPosX=340;
                ballPosY=500;
                ballXdir=-1;
                ballYdir=-2;
                playerX=280;
                score = 0;

                map= new mapGenerator(score,12,20);


                repaint();
            }
        }
    }
    public void moveright(int x ){
        play= true;
        playerX+=x;
    }
    public void moveleft(int x ){
        play= true;
        playerX-=x;
    }
}
