/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.engimon.Engimon;
import com.engimon.model.engimon.species.Charmander;
import com.engimon.model.map.MapBoard;
import com.engimon.model.player.Player;
import java.awt.Point;

/**
 *
 * @author chris
 */
public class Game {
    private Player player;
    private MapBoard map;
    
    public Game() {
        map = new MapBoard();
        player = new Player(new Point(10,10));
        Engimon engimon = new Charmander(1, new Point(10,9));
        player.addEngimon(engimon);
        player.setActiveEngimon(engimon);
        map.at(player.getPosition()).setObject(player);
        map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public MapBoard getMap() {
        return map;
    }
    
    
}
