/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
/*
public class GameMenuView {
    static GameMenuView gameMenu;
    void displayMenu(){
        System.out.println("\n**** displayMenu stub function called***");
}
}
*/

/**
 *
 * @author bruno
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import static byu.cit260.shrek.view.GameMenuView.gameMenu;
//import byui.cit260.shrek.control.GameControl;
//import byu.cit260.shrek.view.MainMenuView;


/**
 *
 * @author bruno
 */
public class GameMenuView {
    static GameMenuView gameMenu;
    private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|              Adventure Menu                |"
            +"\n----------------------------------------"
            +"\nR - Shrek rescues the princess from the tower"
            +"\nG - Shrek goes away from the dragon"
            +"\nT - Shrek enters into the town"
            +"\nE - Exit"
            +"\n----------------------------------------";
    void displayMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("***HelpMenuView.displayMenu() function called");
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
            case 'R':
                this.rescuePrincess();
                break;
            case 'G':
                this.goAway();
                break;
            case 'T':
                this.enterTown();
                break;
            case 'E':
                return;
            default:
                System.out.println("Enter the value");
                break;              
       }
    }
    
    private void rescuePrincess() {
        System.out.println("***The goal is to rescue the Princess");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void goAway() {
        System.out.println("***The goal is to escape from the dragon***");
        //
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void enterTown() {
        WallMenuView myWallMenu=new WallMenuView();
        myWallMenu.displayMenu();
        //System.out.println("***The goal is to enter the Town of the King***");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
 }
    
