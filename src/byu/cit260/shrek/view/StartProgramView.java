/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.shrek.view;

import byui.cit260.shrek.control.ProgramControl;
import byui.cit260.shrek.model.Player;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class StartProgramView { 
    public void displayBanner(){
        System.out.println("*                         *"
                +"\n* This is Shrek adventure's game"
                +"\n* You can choose among user stories"
                +"\n* It will be a wonderful game"
        );
        
        //String playersName =this.getPlayersName();
        
}
public void startProgram(){
    this.displayBanner();
    String playersName=this.getPlayersName();
    Player player = ProgramControl.createPlayer(playersName);
    this.displayWelcomeMessage(player);
    MainMenuView mainMenu=new MainMenuView();
    mainMenu.displayMenu();
}

private String getPlayersName() {
        //To change body of generated methods, choose Tools | Templates.
        boolean valid=false;
        String playersName=null;
        Scanner keyboard = new Scanner(System.in);
        while(!valid){
            System.out.println("Enter the player's name");
            playersName=keyboard.nextLine();
            playersName=playersName.trim();
            if(playersName.length()<2) {
                System.out.println("Invalid name-it must not be blank");
                continue;}
            break;
            }
        return playersName;
        }

    private void displayWelcomeMessage(Player player) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("\n\n============================================");
        System.out.println("\t Welcome to the game  "+player.getName());
        System.out.println("\t We hope you have a lot of fun!");
        System.out.println("================================================");
    }
    }
