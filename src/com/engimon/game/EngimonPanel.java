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
 * @author chris
 */
public class EngimonPanel extends JPanel{
    private Engimon engimon;
    private BufferedImage engimonSprite;
    
    public EngimonPanel(Engimon engimon) {
        this.setPreferredSize(new Dimension(250, 250));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.engimon = engimon;
        try {
            engimonSprite = ImageIO.read(new File(engimon.getImagePath()));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void paintComponent(Graphics g) {
        Image engimonImg = engimonSprite.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        g.drawImage(engimonImg, 0, 0, this);
    }
}
