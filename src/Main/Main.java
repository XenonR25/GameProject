package Main;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Driver gamePlay= new Driver();
        obj.setBounds(10, 10 , 700, 600);
        obj.setTitle("Pong Game Developed by Farzine and Rahik, swe-20,SUST");
        obj.setResizable(false);
        obj.setVisible(true);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        obj.add(gamePlay);
        gamePlay.setupGame();
        gamePlay.startGameThread();
    }
}