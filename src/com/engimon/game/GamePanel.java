/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.player.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.engimon.model.map.*;
import java.awt.Point;
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
    static final int DELAY = 75;
    private static String grassPath = "resources/sprites/map/grass.png";
    private static String seaPath = "resources/sprites/map/sea.png";
    private static String mountainPath = "resources/sprites/map/mountain.png";
    private static String tundraPath = "resources/sprites/map/tundra.png";
    private static String sea_border = "resources/sprites/map/sea_border.png";
    private static String mountain_border = "resources/sprites/map/mountain_border.png";
    private static String stair = "resources/sprites/map/stair.png";
    private static String rock_wall = "resources/sprites/map/rock_wall.png";
    private static String rock_street = "resources/sprites/map/rock_street.png";
    private BufferedImage grassSprite = null;
    private BufferedImage seaSprite = null;
    private BufferedImage mountainSprite = null;
    private BufferedImage tundraSprite = null;
    private BufferedImage sea_borderSprite = null;
    private BufferedImage mountain_borderSprite = null;
    private BufferedImage stairSprite = null;
    private BufferedImage rock_wallSprite = null;
    private BufferedImage rock_streetSprite = null;
    private BufferedImage frontSprite = null;
    private boolean running = false;
    private String direction = " ";
    private String prevMove = " ";
    private String currentMove = " ";
    private int moveCounter = 1;
    private boolean gameStat = true;
    Timer timer;
    
    /* Sementara buat testing */
    
    private Game game;
    private Player player;
    private MapBoard map;
    
    GamePanel(Game game){
        panelConfig();
        readSprite();
        this.game = game;
        player = game.getPlayer();
        map = game.getMap();
        startGame();
    }
    
    private void panelConfig() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }
    
    private void readSprite() {
        try {
            grassSprite = ImageIO.read(new File(grassPath));
            seaSprite = ImageIO.read(new File(seaPath));
            mountainSprite = ImageIO.read(new File(mountainPath));
            tundraSprite = ImageIO.read(new File(tundraPath));
            sea_borderSprite = ImageIO.read(new File(sea_border));
            mountain_borderSprite = ImageIO.read(new File(mountain_border));
            stairSprite = ImageIO.read(new File(stair));
            rock_wallSprite = ImageIO.read(new File(rock_wall));
            rock_streetSprite = ImageIO.read(new File(rock_street));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        renderMap(g);
    }
    
    private void renderMap(Graphics g) {
        Image grassImg = grassSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image seaImg = seaSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image mountainImg = mountainSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image tundraImg = tundraSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image sea_borderImg = sea_borderSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image mountain_borderImg = mountain_borderSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image stairImg = stairSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image rock_wallImg = rock_wallSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Image rock_streetImg = rock_streetSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

        for(int i = 0; i < WIDTH/UNIT_SIZE; i++){
            for(int j = 0; j < HEIGHT/UNIT_SIZE; j++){
                switch (map.at(i, j).getType()) {
                    case GRASSLAND -> g.drawImage(grassImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case SEA -> g.drawImage(seaImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case MOUNTAINS -> g.drawImage(mountainImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case TUNDRA -> g.drawImage(tundraImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case SEA_BORDER -> g.drawImage(sea_borderImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case MOUNTAINS_BORDER -> g.drawImage(mountain_borderImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case ROCK_STAIR -> g.drawImage(stairImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case ROCK_WALL -> g.drawImage(rock_wallImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    case GRASSLAND_STREET -> g.drawImage(rock_streetImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    default -> {
                    }
                }
                try {
                    if(map.at(i,j).getObject() != null){
                        frontSprite = ImageIO.read(new File(map.at(i,j).getObject().getImagePath()));
                    }
                } catch (IOException e) {
                    // do nothing
                }
                if(frontSprite != null) {
                    Image frontImg = frontSprite.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    g.drawImage(frontImg, i*UNIT_SIZE, j*UNIT_SIZE, this);
                    frontSprite = null;
                }
            }
        }
    }
    
    private void renderBattle(Graphics g) {
        
    }
    
    private void move() {
        int xtmp = player.getPosition().x;
        int ytmp = player.getPosition().y;
        boolean move = true;
        if(!prevMove.equals(currentMove)){
            moveCounter = 1;
        }
        prevMove = currentMove;
        player.setImagePath(direction, moveCounter%2);
        switch(direction){
            case "U":
                ytmp = ytmp - 1;
                currentMove = direction;
                moveCounter++;
                break;
            case "D":
                ytmp = ytmp + 1;
                currentMove = direction;
                moveCounter++;
                break;
            case "L":
                xtmp = xtmp - 1;
                currentMove = direction;
                moveCounter++;
                break;
            case "R":
                xtmp = xtmp + 1;
                currentMove = direction;
                moveCounter++;
                break;
            case " ":
                move = false;
                break;
        }
        direction = " ";
        if(!checkCollisions(xtmp, ytmp)&& move){
            map.at(player.getActiveEngimon().getPosition()).setObject(null);
            player.getActiveEngimon().setPosition(player.getPosition());
            map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
            player.setPosition(new Point(xtmp, ytmp));
            map.at(player.getPosition()).setObject(player);
        }
    }
    
    private boolean checkCollisions(int xtmp, int ytmp) {
        if((xtmp < 0) || (xtmp > WIDTH/UNIT_SIZE - 1) || (ytmp < 0) || (ytmp > HEIGHT/UNIT_SIZE - 1)){
            return true;
        }
        else if(map.at(xtmp,ytmp).getType().equals(CellType.ROCK_WALL)) {
            return true;
        }
        else if(map.at(xtmp, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && currentMove.equals("L")){
            return true;
        }
        else if(xtmp - 1 > 0){
            if(map.at(xtmp-1, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && currentMove.equals("R")){
                return true;
            }
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
            if(gameStat){
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
                    case KeyEvent.VK_ESCAPE:
//                        gameStat = false;
                    
                }
            }
            else{
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        gameStat = true;
                        removeAll();
                        updateUI();
                }
            }
        }
    }
    
}
