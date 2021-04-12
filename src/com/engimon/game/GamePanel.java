/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 *
 * @author Engimon.cpp
 */
public class GamePanel extends JPanel implements ActionListener{
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 30;
    static final int DELAY = 150;
    private static String grassPath = "sprites/grass.jpeg";
    private static String playerPath = "sprites/player/down1.png";
    private static String aEngimonPath = "sprites/pokemon/charizard.png";
    private BufferedImage backSprite = null;
    private BufferedImage frontSprite = null;
    private boolean running = false;
    private String direction = " ";
    private String prevMove = " ";
    private String currentMove = " ";
    private int moveCounter = 1;
    Timer timer;
    
    
    /* Sementara buat testing */
    private int x = 10;
    private int y = 10;
    private int eX = 10; 
    private int eY = 9;
    
    GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        try {
            backSprite = ImageIO.read(new File(grassPath));
        } catch(IOException e){
            e.printStackTrace();
        }
        startGame();
    }
    
    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        Image backImg = backSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        for(int i = 0; i < WIDTH/UNIT_SIZE; i++){
            for(int j = 0; j < HEIGHT/UNIT_SIZE; j++){
                g.drawImage(backImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                try {
                    if(i == x && j == y){
                        frontSprite = ImageIO.read(new File(playerPath));
                    }
                    else if (i == eX && j == eY) {
                        frontSprite = ImageIO.read(new File(aEngimonPath));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(frontSprite != null) {
                    Image frontImg = frontSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    g.drawImage(frontImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    frontSprite = null;
                }
            }
        }
        for(int i = 0; i < WIDTH/UNIT_SIZE; i++) {
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, WIDTH);
            g.drawLine(0, i*UNIT_SIZE, WIDTH, i*UNIT_SIZE);
        }
    }
    
    private void move() {
        int xtmp = x;
        int ytmp = y;
        boolean move = true;
        if(!prevMove.equals(currentMove)){
            moveCounter = 1;
        }
        prevMove = currentMove;
        switch(direction){
            case "U":
                ytmp = ytmp - 1;
                if(moveCounter%2 == 1){
                    playerPath = "sprites/player/up2.png";
                }
                else{
                    playerPath = "sprites/player/up3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "D":
                ytmp = ytmp + 1;
                if(moveCounter%2 == 1){
                    playerPath = "sprites/player/down2.png";
                }
                else{
                    playerPath = "sprites/player/down3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "L":
                xtmp = xtmp - 1;
                if(moveCounter%2 == 1){
                    playerPath = "sprites/player/left2.png";
                }
                else{
                    playerPath = "sprites/player/left3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "R":
                xtmp = xtmp + 1;
                if(moveCounter%2 == 1){
                    playerPath = "sprites/player/right2.png";
                }
                else{
                    playerPath = "sprites/player/right3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case " ":
                move = false;
                break;
        }
        direction = " ";
        if(!checkCollisions(xtmp, ytmp)&& move){
            eX = x;
            eY = y;
            x = xtmp;
            y = ytmp;
        }
    }
    
    private boolean checkCollisions(int xtmp, int ytmp) {
        if(xtmp < 0 || xtmp > WIDTH/UNIT_SIZE - 1 || ytmp < 0 || ytmp > HEIGHT/UNIT_SIZE - 1){
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
        }
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()) {
                case KeyEvent.VK_A:
                    if(!direction.equals("R")) {
                        direction = "L";
                    }
                    break;
                case KeyEvent.VK_D:
                    if(!direction.equals("L")) {
                        direction = "R";
                    }
                    break;
                case KeyEvent.VK_W:
                    if(!direction.equals("D")) {
                        direction = "U";
                    }
                    break;
                case KeyEvent.VK_S:
                    if(!direction.equals("U")) {
                        direction = "D";
                    }
                    break;
            }
        }
    }
}
