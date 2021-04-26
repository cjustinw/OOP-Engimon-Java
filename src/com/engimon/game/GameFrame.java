/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.engimon.Engimon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultListModel;

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
        breedEngimonImg1.setLayout(new BorderLayout());
        breedEngimonImg2.setLayout(new BorderLayout());
        breedEngimonImg3.setLayout(new BorderLayout());
        tabPanel.removeAll();
        tabPanel.add(optionPanel, "Option");
        exitGameButton.setEnabled(running);
        saveGameBtn.setEnabled(false);
    }
    
    public void loadPanel() {
        tabPanel.add(gamePanel, "Game");
        tabPanel.add(activeEngimonPanel, "Engimon");
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
    
    public void loadGame() {
        loadPanel();
        game = new Game(true);
        playerModePanel = new GamePanel(game);
        gamePanel.add(playerModePanel);
        panelEngimonConfig();
    }
    
    public void panelEngimonConfig() {
        setActiveEngimonImg();
        setActiveEngimonProfile();
        setSelectActiveBtn();
        setEngimonInventory();
        setSkillItemInventory();
        setEngimonList();
        useSkillItemLabel.setText("");
        
        repaint();
    }
    
    public void setActiveEngimonImg(){
        engimonImg.removeAll();
        if(game.getPlayer().getActiveEngimon() != null){
            engimonImg.revalidate();
            engimonImg.add(new EngimonPanel(game.getPlayer().getActiveEngimon(), new Dimension(250,250)));
        }
        engimonImg.repaint();
    }
    
    public void setActiveEngimonProfile() {
        activeEngimonLabel.removeAll();
        if(game.getPlayer().getActiveEngimon() != null) {
            String text = "<html> "
                + "Name     : " + game.getPlayer().getActiveEngimon().getName() + "<br/>"
                + "Species  : " + game.getPlayer().getActiveEngimon().getSpecies() + "<br/>"
                + "Level    : " + game.getPlayer().getActiveEngimon().getLevel() + "<br/>"
                + "EXP      : " + game.getPlayer().getActiveEngimon().getExp() + "/" + game.getPlayer().getActiveEngimon().getLevel()*100 + "<br/>"
                + "cEXP      : " + game.getPlayer().getActiveEngimon().getCumulativeExp() + "/" + game.getPlayer().getActiveEngimon().getMaxCumulativeExp() + "<br/>"
                + "Life     : " + game.getPlayer().getActiveEngimon().getLife() + "<br/>"
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
                text = text + "Interact  : " + game.getPlayer().getActiveEngimon().interact() + "<br/>" + "</html>";
            engimonProfile.setText(text);
            activeEngimonLabel.setVisible(true);
        }
        else{
            engimonProfile.setText("");
            activeEngimonLabel.setVisible(true);
        }
        activeEngimonLabel.repaint();
    }
    public void setEngimonImg(){
        engimonImg.removeAll();
        engimonImg.revalidate();
        engimonImg.add(new EngimonPanel(game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1), new Dimension(250,250)));
        engimonImg.repaint();
    }
    
    public void setEngimonProfile() {
        String text = "<html> "
            + "Name     : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getName() + "<br/>"
            + "Species  : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getSpecies() + "<br/>"
            + "Level    : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getLevel() + "<br/>"
            + "EXP      : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getExp() + "/" + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getLevel()*100 + "<br/>"
            + "cEXP      : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getCumulativeExp() + "/" + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getMaxCumulativeExp() + "<br/>"
            + "Life     : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).getLife() + "<br/>"
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
            text = text + "Interact  : " + game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).interact() + "<br/>" + "</html>";
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
        renameEngimon.setEnabled(false);
        renameEngimonBtn.setEnabled(false);
    }
    
    private void setEngimonInventory() {
        engimonInventory.clearSelection();
        engimonInventory.clearSelection();
        countEngimon.setText("Engimon : " + game.getPlayer().getNumOfEngimon());
        DefaultListModel<String> engimonList = new DefaultListModel<>();
        
        engimonInventory.removeAll();
        for (String allEngimonName : game.getPlayer().getAllEngimonName()) {
            engimonList.addElement(allEngimonName);
        }
        engimonInventory.setModel(engimonList);
        engimonInventory.setBackground(Color.WHITE);
        removeEngimonBtn.setEnabled(false);
        useSkillItemBtn.setEnabled(false);
    }
    
    private void setSkillItemInventory() {
        skillItemInventory.clearSelection();
        skillItemInventory.clearSelection();
        countSkillItem.setText("Skill Item : " + game.getPlayer().getNumOfSkillItem());
        DefaultListModel<String> skillItemList = new DefaultListModel<>();
        
        skillItemInventory.removeAll();
        for (String allSkillItemName : game.getPlayer().getAllSkillItemName()) {
            skillItemList.addElement(allSkillItemName);
        }
        skillItemInventory.setModel(skillItemList);
        skillItemInventory.setBackground(Color.WHITE);
        removeSkillItemBtn.setEnabled(false);
        useSkillItemBtn.setEnabled(false);
    }
    
    private void setEngimonList() {
        setEngimonList1();
        setEngimonList2();
        engimonList2.setEnabled(false);
        breedEngimonDesc1.setText("");
        breedEngimonDesc2.setText("");
        breedEngimonDesc3.setText("");
        submitBreedBtn.setEnabled(false);
        giveName.setEnabled(false);
        breedEngimonImg1.removeAll();
        breedEngimonImg2.removeAll();
        breedEngimonImg3.removeAll();
        
    }
    
    private void setEngimonList1() {
        engimonList1.removeAllItems();
        engimonList1.addItem("Select Engimon");
        for (String allEngimonName : game.getPlayer().getAllEngimonName()) {
            engimonList1.addItem(allEngimonName);
        }
    }
    
    private void setEngimonList2() {
        engimonList2.removeAllItems();
        engimonList2.addItem("Select Engimon");
        for (String allEngimonName : game.getPlayer().getAllEngimonName()) {
            engimonList2.addItem(allEngimonName);
        }
    }
    
    private void setBreedEngimonImg1() {
        breedEngimonImg1.removeAll();
        breedEngimonImg1.revalidate();
        breedEngimonImg1.add(new EngimonPanel(game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1), new Dimension(100,100)));
        breedEngimonImg1.repaint();
    }
    
    private void setBreedEngimonImg2() {
        breedEngimonImg2.removeAll();
        breedEngimonImg2.revalidate();
        breedEngimonImg2.add(new EngimonPanel(game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1), new Dimension(100,100)));
        breedEngimonImg2.repaint();
    }
    
    private void setBreedEngimonDesc1() {
        String text = "<html> "
            + "Name     : " + game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getName() + "<br/>"
            + "Species  : " + game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getSpecies() + "<br/>"
            + "Element  : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getElements().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getElements().get(i).getElmt().name() + "<br/>";
            }
            text = text + "Skill   : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getSkills().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getSkills().get(i).getSkillName() + " (lv."+ game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getSkills().get(i).getMasteryLevel()  +")" + "<br/>";
            }
            text = text + "</html>";
        breedEngimonDesc1.setText(text);
    }
    
    private void setBreedEngimonDesc2() {
        String text = "<html> "
            + "Name     : " + game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getName() + "<br/>"
            + "Species  : " + game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getSpecies() + "<br/>"
            + "Element  : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getElements().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getElements().get(i).getElmt().name() + "<br/>";
            }
            text = text + "Skill   : " +  "<br/>";
            for(int i = 0; i < game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getSkills().size(); i++) {
                text = text
                + "-    " + game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getSkills().get(i).getSkillName() + " (lv."+ game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getSkills().get(i).getMasteryLevel()  +")" + "<br/>";
            }
            text = text + "</html>";
        breedEngimonDesc2.setText(text);
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
        loadGameBtn = new javax.swing.JButton();
        saveGameBtn = new javax.swing.JButton();
        gamePanel = new javax.swing.JPanel();
        activeEngimonPanel = new javax.swing.JPanel();
        engimonProfile = new javax.swing.JLabel();
        engimonImg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        changeActiveBtn = new javax.swing.JButton();
        selectEngimon = new javax.swing.JComboBox<>();
        activeEngimonLabel = new javax.swing.JLabel();
        renameEngimon = new javax.swing.JTextField();
        renameEngimonBtn = new javax.swing.JButton();
        inventoryPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        engimonInventory = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        skillItemInventory = new javax.swing.JList<>();
        countEngimon = new javax.swing.JLabel();
        countSkillItem = new javax.swing.JLabel();
        removeEngimonBtn = new javax.swing.JButton();
        removeSkillItemBtn = new javax.swing.JButton();
        useSkillItemBtn = new javax.swing.JButton();
        useSkillItemLabel = new javax.swing.JLabel();
        breedingPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        breedEngimonImg1 = new javax.swing.JPanel();
        breedEngimonImg2 = new javax.swing.JPanel();
        breedEngimonImg3 = new javax.swing.JPanel();
        engimonList1 = new javax.swing.JComboBox<>();
        engimonList2 = new javax.swing.JComboBox<>();
        submitBreedBtn = new javax.swing.JButton();
        giveName = new javax.swing.JTextField();
        breedEngimonDesc1 = new javax.swing.JLabel();
        breedEngimonDesc2 = new javax.swing.JLabel();
        breedEngimonDesc3 = new javax.swing.JLabel();
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
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitGameButton.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        exitGameButton.setText("Exit");
        exitGameButton.setFocusPainted(false);
        exitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameButtonActionPerformed(evt);
            }
        });
        optionPanel.add(exitGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 314, 179, 48));

        newGameButton.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        newGameButton.setText("New");
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        optionPanel.add(newGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 152, 179, 48));

        loadGameBtn.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        loadGameBtn.setText("Load");
        loadGameBtn.setFocusPainted(false);

        loadGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameBtnActionPerformed(evt);
            }
        });

        optionPanel.add(loadGameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 206, 179, 48));


        saveGameBtn.setFont(new java.awt.Font("ROG Fonts", 0, 24)); // NOI18N
        saveGameBtn.setText("Save");
        saveGameBtn.setFocusPainted(false);

        saveGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(exitGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(saveGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(207, 207, 207))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );

        optionPanel.add(saveGameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 260, 179, 48));

        tabPanel.addTab("Option", optionPanel);

        gamePanel.setPreferredSize(new java.awt.Dimension(600, 600));
        gamePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabPanel.addTab("Game", gamePanel);

        activeEngimonPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        activeEngimonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        engimonProfile.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        engimonProfile.setText("Engimon Profile");
        engimonProfile.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        activeEngimonPanel.add(engimonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 114, 243, 280));

        engimonImg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        activeEngimonPanel.add(engimonImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 76, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("Engimon");
        activeEngimonPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 23, 235, 47));

        changeActiveBtn.setText("Set Active");
        changeActiveBtn.setFocusPainted(false);
        changeActiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActiveBtnActionPerformed(evt);
            }
        });
        activeEngimonPanel.add(changeActiveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 491, 223, -1));

        selectEngimon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectEngimon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEngimonActionPerformed(evt);
            }
        });
        activeEngimonPanel.add(selectEngimon, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 425, 223, -1));

        activeEngimonLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        activeEngimonLabel.setText("Active Engimon");
        activeEngimonPanel.add(activeEngimonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 143, 28));
        activeEngimonPanel.add(renameEngimon, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 425, 223, -1));

        renameEngimonBtn.setText("Rename");
        renameEngimonBtn.setFocusPainted(false);
        renameEngimonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameEngimonBtnActionPerformed(evt);
            }
        });
        activeEngimonPanel.add(renameEngimonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 491, 223, -1));

        tabPanel.addTab("Engimon", activeEngimonPanel);

        inventoryPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        inventoryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Inventory");
        inventoryPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 24, 235, 47));

        engimonInventory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        engimonInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                engimonInventoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(engimonInventory);

        inventoryPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 129, 215, 287));

        skillItemInventory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        skillItemInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skillItemInventoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(skillItemInventory);

        inventoryPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 129, 215, 287));

        countEngimon.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        countEngimon.setText("Engimon : ");
        inventoryPanel.add(countEngimon, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 99, 134, 24));

        countSkillItem.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        countSkillItem.setText("Skill Item :");
        inventoryPanel.add(countSkillItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 102, 117, -1));

        removeEngimonBtn.setText("Remove Engimon");
        removeEngimonBtn.setFocusPainted(false);
        removeEngimonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEngimonBtnActionPerformed(evt);
            }
        });
        inventoryPanel.add(removeEngimonBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 434, 215, -1));

        removeSkillItemBtn.setText("Remove Skill Item");
        removeSkillItemBtn.setFocusPainted(false);
        removeSkillItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSkillItemBtnActionPerformed(evt);
            }
        });
        inventoryPanel.add(removeSkillItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 434, 215, -1));

        useSkillItemBtn.setText("Use Skill Item");
        useSkillItemBtn.setFocusPainted(false);
        useSkillItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useSkillItemBtnActionPerformed(evt);
            }
        });
        inventoryPanel.add(useSkillItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 474, 215, -1));

        useSkillItemLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        useSkillItemLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        useSkillItemLabel.setText("result");
        inventoryPanel.add(useSkillItemLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 514, 301, -1));

        tabPanel.addTab("Inventory", inventoryPanel);

        breedingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("Breed Engimon");
        breedingPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 22, 235, 47));

        javax.swing.GroupLayout breedEngimonImg1Layout = new javax.swing.GroupLayout(breedEngimonImg1);
        breedEngimonImg1.setLayout(breedEngimonImg1Layout);
        breedEngimonImg1Layout.setHorizontalGroup(
            breedEngimonImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        breedEngimonImg1Layout.setVerticalGroup(
            breedEngimonImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        breedingPanel.add(breedEngimonImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 96, -1, -1));

        javax.swing.GroupLayout breedEngimonImg2Layout = new javax.swing.GroupLayout(breedEngimonImg2);
        breedEngimonImg2.setLayout(breedEngimonImg2Layout);
        breedEngimonImg2Layout.setHorizontalGroup(
            breedEngimonImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        breedEngimonImg2Layout.setVerticalGroup(
            breedEngimonImg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        breedingPanel.add(breedEngimonImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 265, -1, -1));

        javax.swing.GroupLayout breedEngimonImg3Layout = new javax.swing.GroupLayout(breedEngimonImg3);
        breedEngimonImg3.setLayout(breedEngimonImg3Layout);
        breedEngimonImg3Layout.setHorizontalGroup(
            breedEngimonImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        breedEngimonImg3Layout.setVerticalGroup(
            breedEngimonImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        breedingPanel.add(breedEngimonImg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 435, -1, -1));

        engimonList1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        engimonList1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        engimonList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engimonList1ActionPerformed(evt);
            }
        });
        breedingPanel.add(engimonList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 96, 159, -1));

        engimonList2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        engimonList2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        engimonList2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engimonList2ActionPerformed(evt);
            }
        });
        breedingPanel.add(engimonList2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 265, 159, -1));

        submitBreedBtn.setText("Submit");
        submitBreedBtn.setFocusPainted(false);
        submitBreedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBreedBtnActionPerformed(evt);
            }
        });
        breedingPanel.add(submitBreedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 484, 159, -1));

        giveName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        breedingPanel.add(giveName, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 435, 159, -1));

        breedEngimonDesc1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        breedEngimonDesc1.setText("engimon1 desc");
        breedEngimonDesc1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        breedingPanel.add(breedEngimonDesc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 96, 228, 156));

        breedEngimonDesc2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        breedEngimonDesc2.setText("engimon2 desc");
        breedEngimonDesc2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        breedingPanel.add(breedEngimonDesc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 265, 228, 158));

        breedEngimonDesc3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        breedEngimonDesc3.setText("engimon 3 desc");
        breedEngimonDesc3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        breedingPanel.add(breedEngimonDesc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 435, 228, 146));

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
        newGameButton.setEnabled(true);
        loadGameBtn.setEnabled(true);
        saveGameBtn.setEnabled(true);
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
        loadGameBtn.setEnabled(false);
        saveGameBtn.setEnabled(true);
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
                    renameEngimon.setEnabled(true);
                    renameEngimonBtn.setEnabled(true);
                }
                else{
                    changeActiveBtn.setEnabled(false);
                    renameEngimon.setEnabled(false);
                    renameEngimonBtn.setEnabled(false);
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

    private void renameEngimonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameEngimonBtnActionPerformed
        // TODO add your handling code here:
        if(renameEngimon.getText() != null && !renameEngimon.getText().equals("")) {
            game.getPlayer().getEngimonAtIndex(selectEngimon.getSelectedIndex()-1).setName(renameEngimon.getText());
            setEngimonProfile();
        }
        renameEngimon.setText("");
    }//GEN-LAST:event_renameEngimonBtnActionPerformed

    private void removeEngimonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEngimonBtnActionPerformed
        // TODO add your handling code here:
        if(engimonInventory.getSelectedValue() != null){
            game.getPlayer().removeEngimonAtIndex(engimonInventory.getSelectedIndex());
            setEngimonInventory();
        }
    }//GEN-LAST:event_removeEngimonBtnActionPerformed

    private void engimonInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_engimonInventoryMouseClicked
        // TODO add your handling code here:
        if(game.getPlayer().getEngimonAtIndex(engimonInventory.getSelectedIndex()) == game.getPlayer().getActiveEngimon()){
            removeEngimonBtn.setEnabled(false);
        }
        else{
            removeEngimonBtn.setEnabled(true);
        }
        
        if(skillItemInventory.getSelectedValue() != null) {
            removeSkillItemBtn.setEnabled(false);
            useSkillItemBtn.setEnabled(true);
            removeEngimonBtn.setEnabled(false);
        }
    }//GEN-LAST:event_engimonInventoryMouseClicked

    private void removeSkillItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSkillItemBtnActionPerformed
        // TODO add your handling code here:
        if(skillItemInventory.getSelectedValue() != null){
            game.getPlayer().removeSkillItemAtIndex(skillItemInventory.getSelectedIndex());
            setSkillItemInventory();
        }
    }//GEN-LAST:event_removeSkillItemBtnActionPerformed

    private void skillItemInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skillItemInventoryMouseClicked
        // TODO add your handling code here:
        removeSkillItemBtn.setEnabled(true);
        
        if(engimonInventory.getSelectedValue() != null) {
            removeEngimonBtn.setEnabled(false);
            removeSkillItemBtn.setEnabled(false);
            useSkillItemBtn.setEnabled(true);
        }
    }//GEN-LAST:event_skillItemInventoryMouseClicked

    private void useSkillItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useSkillItemBtnActionPerformed
        // TODO add your handling code here:
        useSkillItemLabel.setText(game.getPlayer().learnSkillItem(engimonInventory.getSelectedIndex(), skillItemInventory.getSelectedIndex()));
        setEngimonInventory();
        setSkillItemInventory();
    }//GEN-LAST:event_useSkillItemBtnActionPerformed

    private void saveGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameBtnActionPerformed
        // TODO add your handling code here:
        if (running) {
            game.save();
        }
    }//GEN-LAST:event_saveGameBtnActionPerformed

    private void loadGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameBtnActionPerformed
        // TODO add your handling code here:
        newGameButton.setEnabled(running);
        newGameButton.setEnabled(false);
        loadGameBtn.setEnabled(false);
        saveGameBtn.setEnabled(true);
        exitGameButton.setEnabled(!running);
        if(!running){
            loadGame();
            running = true;
        }
    }//GEN-LAST:event_loadGameBtnActionPerformed

    private void engimonList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engimonList1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==engimonList1){
            if(engimonList1.getSelectedItem() != null ){
                if(!engimonList1.getSelectedItem().equals("Select Engimon")){
                    if(game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1).getLevel() >=4 && !engimonList2.getSelectedItem().equals(engimonList1.getSelectedItem())){
                        engimonList2.setEnabled(true);
                        setBreedEngimonImg1();
                        setBreedEngimonDesc1();
                    }
                    else{
                        breedEngimonImg1.removeAll();
                        breedEngimonImg1.repaint();
                        breedEngimonDesc1.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_engimonList1ActionPerformed

    private void engimonList2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engimonList2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==engimonList2){
            if(engimonList2.getSelectedItem() != null ){
                if(!engimonList2.getSelectedItem().equals("Select Engimon")){
                    if(game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1).getLevel() >=4 && !engimonList2.getSelectedItem().equals(engimonList1.getSelectedItem())){
                        submitBreedBtn.setEnabled(true);
                        giveName.setEnabled(true);
                        setBreedEngimonImg2();
                        setBreedEngimonDesc2();
                    }
                    else{
                        breedEngimonImg2.removeAll();
                        breedEngimonImg2.repaint();
                        breedEngimonDesc2.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_engimonList2ActionPerformed

    private void submitBreedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBreedBtnActionPerformed
        // TODO add your handling code here:
        if(giveName != null){
            if(!giveName.getText().equals("")){
                Engimon E1 = game.getPlayer().getEngimonAtIndex(engimonList1.getSelectedIndex()-1);
                Engimon E2 = game.getPlayer().getEngimonAtIndex(engimonList2.getSelectedIndex()-1);
                Engimon E = game.getPlayer().breedEngimon(E1, E2);
                E.setName(giveName.getText());
                
                breedEngimonImg3.removeAll();
                breedEngimonImg3.revalidate();
                breedEngimonImg3.add(new EngimonPanel(E, new Dimension(100,100)));
                breedEngimonImg3.repaint();
                String text = "<html> "
                    + "Name     : " + E.getName() + "<br/>"
                    + "Species  : " + E.getSpecies() + "<br/>"
                    + "Element  : " +  "<br/>";
                    for(int i = 0; i < E.getElements().size(); i++) {
                        text = text
                        + "-    " + E.getElements().get(i).getElmt().name() + "<br/>";
                    }
                    text = text + "Skill   : " +  "<br/>";
                    for(int i = 0; i < E.getSkills().size(); i++) {
                        text = text
                        + "-    " + E.getSkills().get(i).getSkillName() + " (lv."+ E.getSkills().get(i).getMasteryLevel()  +")" + "<br/>";
                    }
                    text = text + "</html>";
                breedEngimonDesc3.setText(text);
                repaint();
                submitBreedBtn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_submitBreedBtnActionPerformed


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
    private javax.swing.JLabel breedEngimonDesc1;
    private javax.swing.JLabel breedEngimonDesc2;
    private javax.swing.JLabel breedEngimonDesc3;
    private javax.swing.JPanel breedEngimonImg1;
    private javax.swing.JPanel breedEngimonImg2;
    private javax.swing.JPanel breedEngimonImg3;
    private javax.swing.JPanel breedingPanel;
    private javax.swing.JButton changeActiveBtn;
    private javax.swing.JLabel countEngimon;
    private javax.swing.JLabel countSkillItem;
    private javax.swing.JPanel engimonImg;
    private javax.swing.JList<String> engimonInventory;
    private javax.swing.JComboBox<String> engimonList1;
    private javax.swing.JComboBox<String> engimonList2;
    private javax.swing.JLabel engimonProfile;
    private javax.swing.JButton exitGameButton;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JTextField giveName;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadGameBtn;
    private javax.swing.JButton newGameButton;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton removeEngimonBtn;
    private javax.swing.JButton removeSkillItemBtn;
    private javax.swing.JTextField renameEngimon;
    private javax.swing.JButton renameEngimonBtn;
    private javax.swing.JButton saveGameBtn;
    private javax.swing.JComboBox<String> selectEngimon;
    private javax.swing.JList<String> skillItemInventory;
    private javax.swing.JButton submitBreedBtn;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton useSkillItemBtn;
    private javax.swing.JLabel useSkillItemLabel;
    // End of variables declaration//GEN-END:variables


}
