/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.engimon.Engimon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Engimon.cpp
 */
public class EngimonPanel extends JPanel{
    private BufferedImage engimonSprite;
    private Dimension dimension;
    
    private Engimon engimon;
    
    public EngimonPanel(Engimon engimon, Dimension dimension) {
        this.engimon = engimon;
        this.dimension = dimension;
        this.setPreferredSize(new Dimension(dimension));
        this.setBackground(Color.white);
        this.setFocusable(true);
        try {
            engimonSprite = ImageIO.read(new File(engimon.getImagePath()));
        } catch(IOException e){
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Image engimonImg = engimonSprite.getScaledInstance(dimension.height, dimension.width, Image.SCALE_DEFAULT);
        g.drawImage(engimonImg, 0, 0, this);
    }
}
