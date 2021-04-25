/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Engimon.cpp
 */
public class GameFrame extends javax.swing.JFrame {
    
    private boolean running = false;
    private Game game;
    private GamePanel playerModePanel;

    /**
     * Creates new form Frame
     */
    public GameFrame() {
        initComponents();
        gamePanel.setLayout(new BorderLayout());
        engimonImg.setLayout(new BorderLayout());
        tabPanel.removeAll();
        tabPanel.add(optionPanel, "Option");
        exitGameButton.setEnabled(running);
    }
    
    public void loadPanel() {
        tabPanel.add(gamePanel, "Game");
        tabPanel.add(activeEngimonPanel, "Active Engimon");
        tabPanel.add(inventoryPanel, "Inventory");
        tabPanel.add(breedingPanel, "Breed Engimon");
    }
    
    public void newGame() {
        loadPanel();
        game = new Game();
        playerModePanel = new GamePanel(game);
        gamePanel.add(playerModePanel);
        
        panelEngimonConfig();
    }
    
    public void panelEngimonConfig() {
        setActiveEngimonImg();
        setActiveEngimonProfile();
        setSelectActiveBtn();
        jLabel5.setText(game.getPlayer().getAllEngimonName().length + "");
        repaint();
    }
    
    public void setActiveEngimonImg(){
        engimonImg.removeAll();
        engimonImg.revalidate();
        engimonImg.add(new EngimonPanel(game.getPlayer().getActiveEngimon(), new Dimension(250,250)));
        engimonImg.repaint();
    }
    
    public void setActiveEngimonProfile() {
        JLabel label = new JLabel("Test");
        String text = "<html> "
            + "Name     : " + game.getPlayer().getActiveEngimon().getName() + "<br/>"
            + "Species  : " + game.getPlayer().getActiveEngimon().getSpecies() + "<br/>"
            + "Level    : " + game.getPlayer().getActiveEngimon().getLevel() + "<br/>"
            + "EXP      : " + game.getPlayer().getActiveEngimon().getExp() + "<br/>"
            + "Element  : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getActiveEngimon().getElements().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getActiveEngimon().getElements().get(i).getElmt().name() + "<br/>";
            }
            text = text + "Skill   : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getActiveEngimon().getSkills().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getActiveEngimon().getSkills().get(i).getSkillName() + " (lv."+ game.getPlayer().getActiveEngimon().getSkills().get(i).getMasteryLevel()  +")" + "<br/>";
            }
            text = text + "</html>";
        engimonProfile.setText(text);
        activeEngimonLabel.setVisible(true);
    }
    public void setEngimonImg(){
        engimonImg.removeAll();
        engimonImg.revalidate();
        engimonImg.add(new EngimonPanel(game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1), new Dimension(250,250)));
        engimonImg.repaint();
    }
    
    
    public void setEngimonProfile() {
        JLabel label = new JLabel("Test");
        String text = "<html> "
            + "Name     : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getName() + "<br/>"
            + "Species  : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getSpecies() + "<br/>"
            + "Level    : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getLevel() + "<br/>"
            + "EXP      : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getExp() + "<br/>"
            + "Element  : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getElements().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getElements().get(i).getElmt().name() + "<br/>";
            }
            text = text + "Skill   : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getSkills().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getSkills().get(i).getSkillName() + " (lv."+ game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getSkills().get(i).getMasteryLevel()  +")" + "<br/>";
            }
            text = text + "</html>";
        engimonProfile.setText(text);
        if(game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getActive()){
            activeEngimonLabel.setVisible(true);
        }
        else{
            activeEngimonLabel.setVisible(false);
        }
    }
    
    private void setSelectActiveBtn() {
        selectEngimon.removeAllItems();
        selectEngimon.addItem("Select Engimon");
        for (String allEngimonName : game.getPlayer().getAllEngimonName()) {
            selectEngimon.addItem(allEngimonName);
        }
        changeActiveBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        optionPanel = new javax.swing.JPanel();
        exitGameButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        gamePanel = new javax.swing.JPanel();
        activeEngimonPanel = new javax.swing.JPanel();
        engimonProfile = new javax.swing.JLabel();
        engimonImg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        changeActiveBtn = new javax.swing.JButton();
        selectEngimon = new javax.swing.JComboBox<>();
        activeEngimonLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inventoryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        breedingPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Engimon");
        setName("GameFrame"); // NOI18N
        setResizable(false);

        tabPanel.setBackground(new java.awt.Color(255, 255, 255));
        tabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabPanel.setFocusable(false);
        tabPanel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelMouseClicked(evt);
            }
        });

        optionPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        exitGameButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        exitGameButton.setText("Exit Game");
        exitGameButton.setFocusPainted(false);
        exitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameButtonActionPerformed(evt);
            }
        });

        newGameButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        newGameButton.setText("New Game");
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(exitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                    .addContainerGap(215, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(206, 206, 206)))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addComponent(exitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(optionPanelLayout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );

        tabPanel.addTab("Option", optionPanel);

        gamePanel.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        tabPanel.addTab("Game", gamePanel);

        activeEngimonPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        engimonProfile.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        engimonProfile.setText("Engimon Profile");
        engimonProfile.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout engimonImgLayout = new javax.swing.GroupLayout(engimonImg);
        engimonImg.setLayout(engimonImgLayout);
        engimonImgLayout.setHorizontalGroup(
            engimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        engimonImgLayout.setVerticalGroup(
            engimonImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("Engimon");

        changeActiveBtn.setText("Set Active");
        changeActiveBtn.setFocusPainted(false);
        changeActiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActiveBtnActionPerformed(evt);
            }
        });

        selectEngimon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectEngimon.setRequestFocusEnabled(false);
        selectEngimon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEngimonActionPerformed(evt);
            }
        });

        activeEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        activeEngimonLabel.setText("Active Engimon");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout activeEngimonPanelLayout = new javax.swing.GroupLayout(activeEngimonPanel);
        activeEngimonPanel.setLayout(activeEngimonPanelLayout);
        activeEngimonPanelLayout.setHorizontalGroup(
            activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activeEngimonPanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activeEngimonPanelLayout.createSequentialGroup()
                        .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(activeEngimonPanelLayout.createSequentialGroup()
                                .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(engimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(changeActiveBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(selectEngimon, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(engimonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(activeEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activeEngimonPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43))))
        );
        activeEngimonPanelLayout.setVerticalGroup(
            activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activeEngimonPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activeEngimonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, activeEngimonPanelLayout.createSequentialGroup()
                        .addComponent(activeEngimonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(engimonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(activeEngimonPanelLayout.createSequentialGroup()
                        .addComponent(engimonImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(selectEngimon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(changeActiveBtn)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tabPanel.addTab("Active Engimon", activeEngimonPanel);

        inventoryPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Inventory");

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        tabPanel.addTab("Inventory", inventoryPanel);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("Breed Engimon");

        javax.swing.GroupLayout breedingPanelLayout = new javax.swing.GroupLayout(breedingPanel);
        breedingPanel.setLayout(breedingPanelLayout);
        breedingPanelLayout.setHorizontalGroup(
            breedingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(breedingPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        breedingPanelLayout.setVerticalGroup(
            breedingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(breedingPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
        );

        tabPanel.addTab("Breed Engimon", breedingPanel);

        tabPanel.setSelectedComponent(optionPanel);

        titlePanel.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("ROG Fonts", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENGIMON");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabPanel)))
        );

        tabPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameButtonActionPerformed
        // TODO add your handling code here:
        newGameButton.setEnabled(running);
        exitGameButton.setEnabled(!running);
        running = false;
        game = null;
        gamePanel.removeAll();
        tabPanel.removeAll();
        tabPanel.add(optionPanel, "Option");
    }//GEN-LAST:event_exitGameButtonActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
        newGameButton.setEnabled(running);
        exitGameButton.setEnabled(!running);
        if(!running){
            newGame();
            running = true;
        }
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void selectEngimonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEngimonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==selectEngimon){
            if(selectEngimon.getSelectedItem() != null){
                if(!selectEngimon.getSelectedItem().equals("Select Engimon")){
                    setEngimonImg();
                    setEngimonProfile();
                    changeActiveBtn.setEnabled(true);
                }
                else{
                    changeActiveBtn.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_selectEngimonActionPerformed

    private void changeActiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActiveBtnActionPerformed
        // TODO add your handling code here:
        if(selectEngimon.getSelectedItem() != null){
            game.getPlayer().setActiveEngimon(game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1));
            game.getMap().at(game.getPlayer().getActiveEngimon().getPosition()).setObject(game.getPlayer().getActiveEngimon());
            panelEngimonConfig();
        }
    }//GEN-LAST:event_changeActiveBtnActionPerformed

    private void tabPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelMouseClicked
        // TODO add your handling code here:
        if(running){
            panelEngimonConfig();
        }
    }//GEN-LAST:event_tabPanelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeEngimonLabel;
    private javax.swing.JPanel activeEngimonPanel;
    private javax.swing.JPanel breedingPanel;
    private javax.swing.JButton changeActiveBtn;
    private javax.swing.JPanel engimonImg;
    private javax.swing.JLabel engimonProfile;
    private javax.swing.JButton exitGameButton;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton newGameButton;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JComboBox<String> selectEngimon;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables


}
