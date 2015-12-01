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
                System.out.println("Enter the right value");
                break;              
       }
    return false;
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
    
