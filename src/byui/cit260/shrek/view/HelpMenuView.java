package byui.cit260.shrek.view;

import java.util.Scanner;
/**
 *
 * @author bruno
 */
public class HelpMenuView extends View {
        public HelpMenuView() {
    //private final String MENU="\n"
         super("\n"
            +"\n----------------------------------------"
            +"\n|              Help Menu                |"
            +"\n----------------------------------------"
            +"\nG - What is the goal of your game?"
            +"\nC - How to choose the adventure"
            +"\nI - How to choose the inputs?"
            +"\nE - Exit"
            +"\n----------------------------------------");
        }
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
    //private void doAction(char choice) {
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
                return true;
            default:
                this.console.println("Enter the right value");
                break;              
       }
    return false;
    }
    
    private void explainGoal() {
        this.console.println("***The goal is to overcome the adventures");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void explainChoose() {
        this.console.println("***You can choose among three adventures****");
        this.console.println("***Selecting the numbers 1-2-3-****");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void explainInputs() {
        this.console.println("***The inputs are values to make calculations");
        this.console.println("***For example you can choose");
        this.console.println("***speed(mph)=10 and angle(degrees)=25");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
 }
    
