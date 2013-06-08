/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import components.Build;
import java.util.ArrayList;
import games.Game;

/**
 *
 * keep track of which games are picked, and the top requirements
 * for each field.
 * 
 * @author Jas0rz
 */
public class Customer {
    public ArrayList<Game> games;
    public ArrayList<Build> builds;
    public Build minBuild;
    public int topCores;
    public float topClock;
    public int topRam;
    public int topVram;
    
    public Customer() {
        games = new ArrayList<>();
        builds = new ArrayList<>();
        topCores = 0;
        topClock = 0;
        topRam = 0;
        topVram = 0;
        
        Game skyrim       = new Game("skyrim",          2, (float) 2.0, 2, 512);
        Game borderlands2 = new Game("borderlands 2",   2, (float) 2.4, 2, 256);
        Game awesomenauts = new Game("awesomenauts",    2, (float) 0,   2, 256);
        Game tf2          = new Game("team fortress 2", 1, (float) 1.7, 1, 256);
    }
    
    public void addGame(Game addedGame) {
        if (addedGame.getCores() > topCores) {
            topCores = addedGame.getCores();
        }
        if (addedGame.getClock() > topClock) {
            topClock = addedGame.getClock();
        }
        if (addedGame.getRam() > topRam) {
            topRam = addedGame.getRam();
        }
        if (addedGame.getVram() > topVram) {
            topVram = addedGame.getVram();
        }
        
        games.add(addedGame);   
    }
    
    public void addBuild(Build newBuild) {
        builds.add(newBuild);
    }
    
}
