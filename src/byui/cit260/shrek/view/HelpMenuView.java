/**
 *
 * @author bruno
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

//import static byu.cit260.shrek.view.GameMenuView.gameMenu;
//import byui.cit260.shrek.control.GameControl;
//import byu.cit260.shrek.view.MainMenuView;
import java.util.Scanner;
//import shrek.CuriousWorkmanship;

/**
 *
 * @author bruno
 */
public class HelpMenuView {
    private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|              Help Menu                |"
            +"\n----------------------------------------"
            +"\nG - What is the goal of your game?"
            +"\nC - How to choose the adventure"
            +"\nI - How to choose the inputs?"
            +"\nE - Exit"
            +"\n----------------------------------------";
    void displayMenu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("***HelpMenuView.displayMenu() function called");
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
            case 'G':
                this.explainGoal();
                break;
            case 'C':
                this.explainChoose();
                break;
            case 'I':
                this.explainInputs();
                break;
            case 'E':
                return;
            default:
                System.out.println("Enter the value");
                break;              
       }
    }
    
    private void explainGoal() {
        System.out.println("***The goal is to overcome the adventures");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void explainChoose() {
        System.out.println("***You can choose among three adventures****");
        System.out.println("***Selecting the numbers 1-2-3-****");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void explainInputs() {
        System.out.println("***The inputs are values to make calculations");
        System.out.println("***For example you can choose");
        System.out.println("***speed(mph)=10 and angle(degrees)=25");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
 }
    
