/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.game.Game.State;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Engimon.cpp
 */
public class BattlePanel extends javax.swing.JPanel {
  
    private Game game;
    private List<String> output;
    /**
     * Creates new form BattlePanel
     */
    public BattlePanel() {
        initComponents();
        activeEngimonImg.setLayout(new BorderLayout());
        wildEngimonImg.setLayout(new BorderLayout());
        result.setVisible(false);
        continueBtn.setVisible(false);
    }
    
    public void battle(Game game) {
        this.game = game;
        
        activeEngimonImg.removeAll();
        wildEngimonImg.removeAll();
        activeEngimonLabel.removeAll();
        wildEngimonLabel.removeAll();
        activeDesc.removeAll();
        wildDesc.removeAll();
        
        if(game.getPlayer().getActiveEngimon() != null){
            activeEngimonLabel.setText(game.getPlayer().getActiveEngimon().getName());
            activeEngimonImg.add(new EngimonPanel(game.getPlayer().getActiveEngimon() , new Dimension(100,100)));
        }
        else{
            activeEngimonLabel.setText("");
        }
        
        wildEngimonLabel.setText(game.getCurrentWildEngimon().getName());
        wildEngimonImg.add(new EngimonPanel(game.getCurrentWildEngimon(), new Dimension(100,100)));
        setWildEngimonProfile();
        setActiveEngimonProfile();
        
        activeEngimonLabel.repaint();
        wildEngimonLabel.repaint();
        activeEngimonImg.repaint();
        wildEngimonImg.repaint();
        activeEngimonLabel.revalidate();
        wildEngimonLabel.revalidate();
        activeEngimonImg.revalidate();
        wildEngimonImg.revalidate();
 
        repaint();
    }
    
    public void setActiveEngimonProfile() {
        if(game.getPlayer().getActiveEngimon() != null) {
            String text = "<html> "
               + "Species  : " + game.getPlayer().getActiveEngimon().getSpecies() + "<br/>"
               + "Level    : " + game.getPlayer().getActiveEngimon().getLevel() + "<br/>"
               + "EXP      : " + game.getPlayer().getActiveEngimon().getExp() + "/" + game.getPlayer().getActiveEngimon().getLevel()*100 + "<br/>"
               + "cEXP      : " + game.getPlayer().getActiveEngimon().getCumulativeExp() + "/" + game.getPlayer().getActiveEngimon().getMaxCumulativeExp() + "<br/>"
               + "Life      : " + game.getPlayer().getActiveEngimon().getLife() + "<br/>"
               + "Element  : " +  "<br/>";
               for(int i = 0; i < game.getPlayer().getActiveEngimon().getElements().size(); i++) {
                   text = text
                   + "-    " + game.getPlayer().getActiveEngimon().getElements().get(i).getElmt().name() + "<br/>";
               }
               text = text + "Skill   : " +  "<br/>";
               for(int i = 0; i < game.getPlayer().getActiveEngimon().getSkills().size(); i++) {
                   text = text
                   + "-    " + game.getPlayer().getActiveEngimon().getSkills().get(i).getSkillName() + " (lv."+ game.getPlayer().getActiveEngimon().getSkills().get(i).getMasteryLevel()  +") " + game.getPlayer().getActiveEngimon().getSkills().get(i).getSkillDamage() + "<br/>";
               }
               text = text + "<br/>" + "Total Power: " + game.getPlayer().getActiveEngimon().getPower(game.getCurrentWildEngimon());
               text = text + "</html>";
            activeDesc.setText(text);
        }
        else{
            activeDesc.setText("");
        }
        activeDesc.repaint();
        repaint();
    }
    
    public void setWildEngimonProfile() {
        String text = "<html> "
            + "Species  : " + game.getCurrentWildEngimon().getSpecies() + "<br/>"
            + "Level    : " + game.getCurrentWildEngimon().getLevel() + "<br/>"
            + "EXP      : " + game.getCurrentWildEngimon().getExp() + "/" + game.getCurrentWildEngimon().getLevel()*100 + "<br/>"
            + "cEXP      : " + game.getCurrentWildEngimon().getCumulativeExp() + "/" + game.getCurrentWildEngimon().getMaxCumulativeExp() + "<br/>"
            + "Life      : " + game.getCurrentWildEngimon().getLife() + "<br/>"
            + "Element  : " +  "<br/>";
            for(int i = 0; i < game.getCurrentWildEngimon().getElements().size(); i++) {
                text = text
                + "-    " + game.getCurrentWildEngimon().getElements().get(i).getElmt().name() + "<br/>";
            }
            text = text + "Skill   : " +  "<br/>";
            for(int i = 0; i < game.getCurrentWildEngimon().getSkills().size(); i++) {
                text = text
                + "-    " + game.getCurrentWildEngimon().getSkills().get(i).getSkillName() + " (lv."+ game.getCurrentWildEngimon().getSkills().get(i).getMasteryLevel()  +") " + game.getCurrentWildEngimon().getSkills().get(i).getSkillDamage() + "<br/>";
            }
            if(game.getPlayer().getActiveEngimon() != null){
                text = text + "<br/>" + "Total Power: " + game.getCurrentWildEngimon().getPower(game.getPlayer().getActiveEngimon());
            }
            text = text + "</html>";
        wildDesc.setText(text);
        wildDesc.repaint();
        repaint();
    }
    
    public void setResult() {
        String text = "<html> "
            + output.get(0) + "<br/>"
            + output.get(1) + "<br/>";
        if(output.size() == 3){
            text = text + output.get(2) + "</html>";
        }
        result.setText(text);
        repaint();
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activeEngimonLabel = new javax.swing.JLabel();
        wildEngimonLabel = new javax.swing.JLabel();
        activeEngimonImg = new javax.swing.JPanel();
        wildEngimonImg = new javax.swing.JPanel();
        battleBtn = new javax.swing.JButton();
        activeDesc = new javax.swing.JLabel();
        wildDesc = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        result = new javax.swing.JLabel();
        continueBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(575, 535));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activeEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        activeEngimonLabel.setText("Engimon 1");
        add(activeEngimonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 25, 113, 26));

        wildEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        wildEngimonLabel.setText("Engimon 2");
        add(wildEngimonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 25, 122, 26));

        javax.swing.GroupLayout activeEngimonImgLayout = new javax.swing.GroupLayout(activeEngimonImg);
        activeEngimonImg.setLayout(activeEngimonImgLayout);
        activeEngimonImgLayout.setHorizontalGroup(
            activeEngimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        activeEngimonImgLayout.setVerticalGroup(
            activeEngimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(activeEngimonImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 69, -1, -1));

        javax.swing.GroupLayout wildEngimonImgLayout = new javax.swing.GroupLayout(wildEngimonImg);
        wildEngimonImg.setLayout(wildEngimonImgLayout);
        wildEngimonImgLayout.setHorizontalGroup(
            wildEngimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        wildEngimonImgLayout.setVerticalGroup(
            wildEngimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(wildEngimonImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 69, -1, -1));

        battleBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        battleBtn.setText("Battle!");
        battleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battleBtnActionPerformed(evt);
            }
        });
        add(battleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 489, -1, -1));

        activeDesc.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        activeDesc.setText("Engimon 1 Desc");
        activeDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(activeDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 187, 166, 238));

        wildDesc.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        wildDesc.setText("Engimon 2 Desc");
        wildDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(wildDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 187, 175, 238));

        cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 489, -1, -1));

        result.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("Result");
        result.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 431, 305, 52));

        continueBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        continueBtn.setText("Continue");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });
        add(continueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 489, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void battleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battleBtnActionPerformed
        // TODO add your handling code here:
        output = game.battle();
        setResult();
        result.setVisible(true);
        continueBtn.setVisible(true);
        cancelBtn.setVisible(false);
        battleBtn.setVisible(false);
        repaint();
    }//GEN-LAST:event_battleBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        game.setState(State.RUNNING);
        game.pauseWildEngimonMovement(false);
        repaint();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        // TODO add your handling code here:
        game.setState(State.RUNNING);
        game.pauseWildEngimonMovement(false);
        result.setVisible(false);
        continueBtn.setVisible(false);
        cancelBtn.setVisible(true);
        battleBtn.setVisible(true);
        repaint();
    }//GEN-LAST:event_continueBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeDesc;
    private javax.swing.JPanel activeEngimonImg;
    private javax.swing.JLabel activeEngimonLabel;
    private javax.swing.JButton battleBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton continueBtn;
    private javax.swing.JLabel result;
    private javax.swing.JLabel wildDesc;
    private javax.swing.JPanel wildEngimonImg;
    private javax.swing.JLabel wildEngimonLabel;
    // End of variables declaration//GEN-END:variables
}
