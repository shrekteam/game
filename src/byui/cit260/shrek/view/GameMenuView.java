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
public class GameMenuView extends View {
    static GameMenuView gameMenu;
    public GameMenuView() {
    //private final String MENU="\n"
         super("\n"
    
    //private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|              Adventure Menu                |"
            +"\n----------------------------------------"
            +"\nR - Shrek rescues the princess from the tower"
            +"\nG - Shrek goes away from the dragon"
            +"\nT - Shrek enters the town breaking the wall"
            +"\nE - Exit"
            +"\n----------------------------------------");
         }
    public boolean doAction(Object obj, Object obj2) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
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
                return true;
            default:
                System.out.println("Enter the value");
                break;              
       }
    return false;
    }
    
    private void rescuePrincess() {
        System.out.println("***The goal is to rescue the Princess");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void goAway() {
        System.out.println("***The goal is to escape from the dragon***");
    }

    private void enterTown() {
        WallMenuView myWallMenu=new WallMenuView();
        myWallMenu.display();
    }
      
 }
    
