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
            +"\nG - What is the goal of the game?"
            +"\nC - How can you choose the adventure?"
            +"\nI - How can you choose the adventure inputs?"
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
        this.console.println("***The goal is to win three adventures inspired to the Shrek's movie:");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private void explainChoose() {
        this.console.println("*** The adventures are : 1)rescue the princess, 2)escape from the dragon, 3)enter the town breaking its wall ****");
        this.console.println("*** You can choose the adventures selecting the letters T,G,W from the game menu ****");
        this.console.println("*** To participate to the adventures you have to gain money and purchase the game tools: sword, arrow, spear ****");        
        this.console.println("*** You gain money moving to the locations, choosing M at the game menu. ****");
        this.console.println("*** But you cannot gain money at the location already visited ****");
        this.console.println("*** The map shows the location already visited and the money gained for each location  ****");        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void explainInputs() {
        this.console.println("*** The adventures inputs are numerical values to make calculations ***");
        this.console.println("*** For example you can choose ***");
        this.console.println("*** speed(mph)=10 and angle(degrees)=25 ***");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
 }
    
