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

import com.engimon.model.map.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Engimon.cpp
 */
public class GamePanel extends JPanel implements ActionListener{
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static final int UNIT_SIZE = 30;
    static final int DELAY = 70;
    private static String mapPath = "resources/map.txt";
    private static String grassPath = "resources/sprites/map/grass.png";
    private static String seaPath = "resources/sprites/map/sea.png";
    private static String mountainPath = "resources/sprites/map/mountain.png";
    private static String tundraPath = "resources/sprites/map/tundra.png";
    private static String borderPath1 = "resources/sprites/map/1.png";
    private static String borderPath2 = "resources/sprites/map/2.png";
    private static String borderPath3 = "resources/sprites/map/3.png";
    private static String borderPath4 = "resources/sprites/map/4.png";
    private static String playerPath = "resources/sprites/player/down1.png";
    private static String aEngimonPath = "resources/sprites/pokemon/charizard.png";
    private BufferedImage grassSprite = null;
    private BufferedImage seaSprite = null;
    private BufferedImage mountainSprite = null;
    private BufferedImage tundraSprite = null;
    private BufferedImage borderSprite1 = null;
    private BufferedImage borderSprite2 = null;
    private BufferedImage borderSprite3 = null;
    private BufferedImage borderSprite4 = null;
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
    private char[][] map;
    
    GamePanel(){
//        MapBoard map = new MapBoard(mapPath);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        try {
            grassSprite = ImageIO.read(new File(grassPath));
            seaSprite = ImageIO.read(new File(seaPath));
            mountainSprite = ImageIO.read(new File(mountainPath));
            tundraSprite = ImageIO.read(new File(tundraPath));
            borderSprite1 = ImageIO.read(new File(borderPath1));
            borderSprite2 = ImageIO.read(new File(borderPath2));
            borderSprite3 = ImageIO.read(new File(borderPath3));
            borderSprite4 = ImageIO.read(new File(borderPath4));
        } catch(IOException e){
            e.printStackTrace();
        }
        loadMap();
        startGame();
    }
    
    private void loadMap() {
        map = new char[WIDTH/UNIT_SIZE][HEIGHT/UNIT_SIZE];
        try {
            File file = new File(mapPath);
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < WIDTH/UNIT_SIZE; i++){
                String str = sc.next();
                for(int j = 0; j < HEIGHT/UNIT_SIZE; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        Image grassImg = grassSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image seaImg = seaSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image mountainImg = mountainSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image tundraImg = tundraSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image borderImg1 = borderSprite1.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image borderImg2 = borderSprite2.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image borderImg3 = borderSprite3.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image borderImg4 = borderSprite4.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        
        for(int i = 0; i < WIDTH/UNIT_SIZE; i++){
            for(int j = 0; j < HEIGHT/UNIT_SIZE; j++){
                if(map[j][i] == '-'){
                    g.drawImage(grassImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == 'o'){
                    g.drawImage(seaImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '^'){
                    g.drawImage(mountainImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '~'){
                    g.drawImage(tundraImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '1'){
                    g.drawImage(borderImg1, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '2'){
                    g.drawImage(borderImg2, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '3'){
                    g.drawImage(borderImg3, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
                else if(map[j][i] == '4'){
                    g.drawImage(borderImg4, i*UNIT_SIZE, j*UNIT_SIZE, this);
                }
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
//        for(int i = 0; i < WIDTH/UNIT_SIZE; i++) {
//            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, WIDTH);
//            g.drawLine(0, i*UNIT_SIZE, WIDTH, i*UNIT_SIZE);
//        }
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
                    playerPath = "resources/sprites/player/up2.png";
                }
                else{
                    playerPath = "resources/sprites/player/up3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "D":
                ytmp = ytmp + 1;
                if(moveCounter%2 == 1){
                    playerPath = "resources/sprites/player/down2.png";
                }
                else{
                    playerPath = "resources/sprites/player/down3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "L":
                xtmp = xtmp - 1;
                if(moveCounter%2 == 1){
                    playerPath = "resources/sprites/player/left2.png";
                }
                else{
                    playerPath = "resources/sprites/player/left3.png";
                }  
                currentMove = direction;
                moveCounter++;
                break;
            case "R":
                xtmp = xtmp + 1;
                if(moveCounter%2 == 1){
                    playerPath = "resources/sprites/player/right2.png";
                }
                else{
                    playerPath = "resources/sprites/player/right3.png";
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
