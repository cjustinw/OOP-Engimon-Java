package com.engimon.loader;

import com.engimon.model.engimon.CreateEngimon;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.engimon.species.Charmander;
import com.engimon.model.engimon.species.Diglet;
import com.engimon.model.engimon.species.Entei;
import com.engimon.model.player.Player;

import java.awt.*;
import java.io.*;

public class GameLoader {

    private Player player;
    private PrintWriter pw;
    private BufferedReader reader;

    public GameLoader(Player nplayer) {
        player = nplayer;
    }

    public void save() throws IOException {
        Point position = player.getPosition();
        int active = player.getActiveEngimonIndex();
        int countEngimon = player.getEngimonInventory().size();
        String imagePath = player.getImagePath();

        pw = new PrintWriter(new FileWriter("state.txt"));

        pw.write(position.x+"\n");
        pw.write(position.y+"\n");
        pw.write(active+"\n");
        pw.write(imagePath+"\n");
        pw.write(countEngimon+"\n");

        for (Engimon engimon: player.getEngimonInventory() ) {
            saveEngimon(engimon);
        }

        pw.close();
    }

    private void saveEngimon(Engimon engimon) {
        int id = engimon.getId();
        String name = engimon.getName();
        int level = engimon.getLevel();
        int exp = engimon.getExp();
        Point position = engimon.getPosition();

        pw.write("---------------------------------\n");
        pw.write(id+"\n");
        pw.write(name+"\n");
        pw.write(level+"\n");
        pw.write(exp+"\n");
        pw.write(position.x+"\n");
        pw.write(position.y+"\n");
        // saveSkillEngimon
    }

    public void load() throws IOException {
        reader = new BufferedReader(new FileReader("state.txt"));

        // load player position
        Point position = new Point(Integer.parseInt(reader.readLine()),
                                    Integer.parseInt(reader.readLine()));
        player.setPosition(position);

        // load active engimon index
        int activeIndex = Integer.parseInt(reader.readLine());

        // load imagePath
        player.setImagePath(reader.readLine(), 1);

        // load engimon inventory
        int countEngimon = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countEngimon; i++){
            player.addEngimon(loadEngimon());
        }

        // set active engimon
        player.setActiveEngimon(player.getEngimonAtIndex(activeIndex));
    }

    private Engimon loadEngimon() throws IOException {
        reader.readLine();

        int id = Integer.parseInt(reader.readLine());
        String name = reader.readLine();
        int level = Integer.parseInt((reader.readLine()));

        // int exp =
           Integer.parseInt(reader.readLine());

        Point position = new Point(Integer.parseInt(reader.readLine()),
                                    Integer.parseInt(reader.readLine()));

        Engimon engimon = (new CreateEngimon()).createEngimon(id, level, position);
        engimon.setName(name);

        return engimon;
    }

    // Driver for gameloader
    public static void main(String[] args) {
        Player newPlayer= new Player(new Point(0,0));

        newPlayer.setPosition(new Point(10,10));

        newPlayer.addEngimon(new Charmander(10, new Point(1,0)));
        newPlayer.setActiveEngimon(newPlayer.getEngimonAtIndex(0));

        newPlayer.addEngimon(new Diglet(5, new Point(0,0)));
        newPlayer.addEngimon(new Entei(25, new Point(0,0)));
        newPlayer.addEngimon(new Charmander(100, new Point(5,5)));

        GameLoader gl = new GameLoader(newPlayer);

        try {
            gl.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        newPlayer = new Player(new Point(0,0));
        gl = new GameLoader(newPlayer);

        System.out.println("///////////// BEFORE LOAD /////////////");
        System.out.println(newPlayer.getEngimonInventory().size());
        System.out.println(newPlayer.getPosition().x + "," + newPlayer.getPosition().y);

        try {
            gl.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("///////////// AFTER LOAD /////////////");
        System.out.println(newPlayer.getEngimonInventory().size());
        System.out.println(newPlayer.getPosition().x + "," + newPlayer.getPosition().y);
    }
}
