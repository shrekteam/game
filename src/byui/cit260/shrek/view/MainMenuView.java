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
import shrek.Shrek;

public class MainMenuView extends View{
    
    public MainMenuView(){
   // private final String MENU="\n"
        super("\n"
            +"\n----------------------------------------"
            +"\n|            Main Menu                  |"
            +"\n----------------------------------------"
            +"\nN - Start new game"
            +"\nG - Get and start saved game"
            +"\nH - Get help on how to play the game"
            +"\nS - Save the game"
            +"\nE - Exit"
            +"\n----------------------------------------");
        }
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
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
                return true;
            default:
                System.out.println("Enter the value");
                break;              
       }
        return true;
    }

    private void startNewGame() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        GameControl.createNewGame(Shrek.getPlayer());
        GameMenuView.gameMenu=new GameMenuView();
        gameMenu.display();
     
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
        myHelp.display();
        
    }
      
 }
    

