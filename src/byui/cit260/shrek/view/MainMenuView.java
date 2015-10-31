/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import static byui.cit260.shrek.view.GameMenuView.gameMenu;
import byui.cit260.shrek.control.GameControl;
import byui.cit260.shrek.view.MainMenuView;
import java.util.Scanner;
import shrek.CuriousWorkmanship;

/**
 *
 * @author bruno
 */
public class MainMenuView {
    private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|            Main Menu                  |"
            +"\n----------------------------------------"
            +"\nN - Start new game"
            +"\nG - Get and start saved game"
            +"\nH - Get help on how to play the game"
            +"\nS - Save the game"
            +"\nE - Exit"
            +"\n----------------------------------------";
    void displayMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("***MainMenuView.displayMenu() function called");
        char selection=' ';
        do {
            System.out.println(MENU);
            String input = this.getInput();
            selection = input.charAt(0);
            this.doAction(selection);
        } while(selection!='E');
        
    
    }
    
    private String getInput() {
        //To change body of generated methods, choose Tools | Templates.
        boolean valid=false;
        String value=null;
        Scanner keyboard = new Scanner(System.in);
        while(!valid){
            System.out.println("Enter the value");
            value=keyboard.nextLine();
            value=value.trim();
            if(value.length()<1) {
                System.out.println("Invalid name-it must not be blank");
                continue;}
            break;
            }
        return value;
        }

    private void doAction(char choice) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    switch (choice){
            case 'N':
                this.startNewGame();
                break;
            case 'G':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':
                return;
            default:
                System.out.println("Enter the value");
                break;              
       }
    }

    private void startNewGame() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        GameControl.createNewGame(CuriousWorkmanship.getPlayer());
        GameMenuView.gameMenu=new GameMenuView();
        gameMenu.displayMenu();
        
    }

    private void startExistingGame() {
        System.out.println("***Start Existing Game****");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveGame() {
        System.out.println("***Save Game************");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void displayHelpMenu() {
        HelpMenuView myHelp = new HelpMenuView();
        myHelp.displayMenu();
        
    }
      
 }
    
