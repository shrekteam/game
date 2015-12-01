


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shrek;

import byui.cit260.shrek.model.Enemy;
import byui.cit260.shrek.model.Pathway;
import byui.cit260.shrek.model.Player;
import byui.cit260.shrek.model.Target;
import byui.cit260.shrek.model.Weapon;

import byui.cit260.shrek.control.WallControl;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class Shrek {
    private static Game currentGame = null;
    private static Player player = null;
    private static  PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static  PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Shrek.logFile = logFile;
    }
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Shrek.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Shrek.inFile = inFile;
    }
    
    
    
    public static void main (String[] args) {
        
            
            
            try {
                Shrek.inFile = new BufferedReader(new InputStreamReader(System.in));
                Shrek.outFile = new PrintWriter(System.out, true);
                String filePath="log.txt";
                Shrek.logFile = new PrintWriter (filePath);
                StartProgramView startProgramView = new StartProgramView();
                startProgramView.startProgram();
            
            }
            catch (Throwable te ){
                System.out.println(te.getMessage());
                te.printStackTrace();
                //startProgramView.startProgram();
            }
            finally{
                try {
                    if(Shrek.inFile!=null)
                    Shrek.inFile.close();
                    if(Shrek.outFile!=null)
                        Shrek.outFile.close();
                } catch (IOException ex) {
                    System.out.println("Error closing files");
                    //Logger.getLogger(Shrek.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                
            }
            
    }
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Shrek.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Shrek.player = player;
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    private static void BrunoTestPlayer(){
        Player playerOne = new Player();
        playerOne.setName("Shrek2");
        playerOne.setBestTime(7.00);
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    } 
    private static void BrunoTestWeapon(){
        Weapon weaponOne = new Weapon();
        weaponOne.setName("excalibur");
        weaponOne.setDimension(12.1);
        String weaponInfo = weaponOne.toString();
        System.out.println(weaponInfo);   
    }
    private static void BrunoTestTarget(){
        Target targetOne = new Target();
        targetOne.setName("Fiona");
        targetOne.setHorizontalPosition(10.0);
        targetOne.setVerticalPosition(11.0);
        String targetInfo = targetOne.toString();
        System.out.println(targetInfo); 
    }
    private static void BrunoTestEnemy(){
        Enemy enemyOne = new Enemy();
        enemyOne.setName("Soldier");
        enemyOne.setStrength(4);
        String enemyInfo = enemyOne.toString();
        System.out.println(enemyInfo); 
        
    }
    private static void BrunoTestPathway(){
        Pathway pathwayOne = new Pathway();
        pathwayOne.setName("Bridge6");
        pathwayOne.setDimension(100.0);
        String pathwayInfo = pathwayOne.toString();
        System.out.println(pathwayInfo); 
        
    }    
    /*
    public static void main(String[] args) {
        // TODO code application logic here
        BrunoTestPlayer();
        BrunoTestWeapon();
        BrunoTestTarget();
        BrunoTestEnemy(); 
        BrunoTestPathway();
        //calcThrowArrowHeight(1,1,11);
        
    }
    */
}

