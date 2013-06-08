/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package games;


/**
 *
 * @author Jas0rz
 */
public class Game {
    private String name;
    private int cores;
    private float clock;
    private int ram;
    private int vram;
    
    public Game(String inName, int inCores, float inClock, int inRam, int inVram) {
        name = inName;
        cores = inCores;
        clock = inClock;
        ram = inRam;
        vram = inVram;
    }
    
    public String getName() {
        return name;   
    }
    
    public int getCores() {
        return cores;
    }
    
    public float getClock() {
        return clock;
    }
    
    public int getRam() {
        return ram;
    }
    
    public int getVram() {
        return vram;
    }
    
    
}
