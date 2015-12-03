/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import static byui.cit260.shrek.view.GameMenuView.gameMenu;
import byui.cit260.shrek.control.GameControl;
import byui.cit260.shrek.exceptions.MapControlException;
//import byui.cit260.shrek.exceptions.MapControlExceptions;
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
                this.console.println("Enter the right value");
                break;              
       }
        return false;
    }

    private void startNewGame() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try{
            GameControl.createNewGame(Shrek.getPlayer());
        } catch (MapControlException mce){
            ErrorView.display(this.getClass().getName(),mce.getMessage());
            return;
        } catch (Throwable te){
        ErrorView.display(this.getClass().getName(),te.getMessage());
        te.printStackTrace();
        return;
        }
        GameMenuView.gameMenu=new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        this.console.println("\nEnter the file path for file where the game is to be saved");
        String filePath = this.getInput();
        try {
            GameControl.getSavedGame(filePath);
        }catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
    }

    private void saveGame() {
        this.console.println("\nEnter the file path for file where the game is to be saved");
        String filePath = this.getInput();
        try {
            GameControl.saveGame(Shrek.getCurrentGame(),filePath);
            }catch (Exception ex){
                ErrorView.display("MainMenuView", ex.getMessage());
              }  
        
            
        }
        
    private void displayHelpMenu() {
        
        HelpMenuView myHelp = new HelpMenuView();
        myHelp.display();
        
    }
      
 }
    

