package com.engimon.loader;

import com.engimon.model.engimon.CreateEngimon;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.engimon.species.Charmander;
import com.engimon.model.engimon.species.Diglet;
import com.engimon.model.engimon.species.Entei;
import com.engimon.model.player.Player;
import com.engimon.model.skill.CreateSkillItem;
import com.engimon.model.skill.Skill;

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

    public void saveEngimon(Engimon engimon) {
        int id = engimon.getId();
        String name = engimon.getName();
        int level = engimon.getLevel();
        int exp = engimon.getExp();
        int cumExp = engimon.getCumulativeExp();
        Point position = engimon.getPosition();
        int skillLevel = engimon.getSkills().get(0).getMasteryLevel();

        pw.write("---------------------------------\n");
        pw.write(id+"\n");
        pw.write(name+"\n");
        pw.write(level+"\n");
        pw.write(exp+"\n");
        pw.write(cumExp+"\n");
        pw.write(position.x+"\n");
        pw.write(position.y+"\n");

        // skill bawaan yang disimpan hanyalah mastery level nya saja
        pw.write(skillLevel+"\n");
        pw.write(engimon.getSkills().size()+"\n");

        for (int i=1; i < engimon.getSkills().size(); i++) {
            saveSkillEngimon(engimon.getSkills().get(i));
        }
    }

    private void saveSkillEngimon(Skill skill) {
        int id = skill.getSkillId();
        int mastery = skill.getMasteryLevel();
        int numOfItem = skill.getNumOfItem();

        pw.write("***************\n");
        pw.write(id+"\n");
        pw.write(mastery + "\n");
        pw.write(numOfItem+"\n");
    }

    public void save(String s) {
        pw.write(s+"");
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

        int exp =
           Integer.parseInt(reader.readLine());

        int cumExp =
           Integer.parseInt(reader.readLine());

        Point position = new Point(Integer.parseInt(reader.readLine()),
                                    Integer.parseInt(reader.readLine()));

        int skillLevel = Integer.parseInt(reader.readLine());

        Engimon engimon = (new CreateEngimon()).createEngimon(id, level, position);
        engimon.setName(name);
        engimon.setExp(exp);
        engimon.setCumulativeExp(cumExp);

        int numOfSkill = Integer.parseInt(reader.readLine());

        engimon.getSkills().get(0).setMasteryLevel(skillLevel);

        for (int i = 1; i< numOfSkill; i++) {
            engimon.learnSkill(loadSkillEngimon());
        }

        assert engimon.getSkills().size() == numOfSkill;

        return engimon;
    }

    private Skill loadSkillEngimon() throws IOException {
        reader.readLine();

        int id = Integer.parseInt(reader.readLine());
        int mastery = Integer.parseInt(reader.readLine());
        int numOfItem = Integer.parseInt(reader.readLine());

        Skill skill = (new CreateSkillItem()).createSkillItem(id);
        skill.setMasteryLevel(mastery);

        for (int i = 1; i < numOfItem; i++) {
            skill.addItem();
        }

        assert skill.getNumOfItem() == numOfItem; // biar lebih yakin

        return skill;
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

        try {
            gl.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
