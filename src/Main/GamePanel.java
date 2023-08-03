package Main;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {
     private int xDelta=100, yDelta=100;
     private int frames = 0;
     private long lastCheck = 0;

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }
    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }
    public  void  setRectPos(int x,int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 100){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS:" + frames);
            frames=0;        }
        g.fillRect(xDelta,yDelta,200,50);
    }
}
