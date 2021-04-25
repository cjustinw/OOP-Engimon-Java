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
            + output.get(1) + "</html>";
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

        activeEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        activeEngimonLabel.setText("Engimon 1");

        wildEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        wildEngimonLabel.setText("Engimon 2");

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

        battleBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        battleBtn.setText("Battle!");
        battleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battleBtnActionPerformed(evt);
            }
        });

        activeDesc.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        activeDesc.setText("Engimon 1 Desc");
        activeDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wildDesc.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        wildDesc.setText("Engimon 2 Desc");
        wildDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        result.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("Result");
        result.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        continueBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        continueBtn.setText("Continue");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeEngimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(activeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wildEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wildEngimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wildDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cancelBtn)
                        .addGap(142, 142, 142)
                        .addComponent(continueBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(battleBtn)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wildEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeEngimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wildEngimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wildDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battleBtn)
                    .addComponent(cancelBtn)
                    .addComponent(continueBtn))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void battleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battleBtnActionPerformed
        // TODO add your handling code here:
        output = game.battle();
        setResult();
        result.setVisible(true);
        continueBtn.setVisible(true);
        cancelBtn.setEnabled(false);
        battleBtn.setEnabled(false);
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
        cancelBtn.setEnabled(true);
        battleBtn.setEnabled(true);
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
