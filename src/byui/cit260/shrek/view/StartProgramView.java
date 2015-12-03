/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.ProgramControl;
import byui.cit260.shrek.model.Player;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class StartProgramView extends View{ 

    public StartProgramView(String promptMessage) {
        super(promptMessage);
    }
    public void displayBanner(){
        this.console.println("*                         *"
                +"\n* This is Shrek adventure's game"
                +"\n* You can choose among different stories"
                +"\n* It will be a wonderful game! "
        );
        
        //String playersName =this.getPlayersName();
        
}
public void startProgram(){
    this.displayBanner();
    String playersName=this.getPlayersName();
    Player player = ProgramControl.createPlayer(playersName);
    this.displayWelcomeMessage(player);
    MainMenuView mainMenu=new MainMenuView();
    mainMenu.display();
}

private String getPlayersName() {
        //To change body of generated methods, choose Tools | Templates.
        boolean valid=false;
        String playersName=null;
      try{
        //Scanner keyboard = new Scanner(System.in);
        while(!valid){
            this.console.println("Enter the player's name");
            
            //playersName=keyboard.nextLine();
            playersName=this.keyboard.readLine();
            playersName=playersName.trim();
            if(playersName.length()<2) {
                ErrorView.display(this.getClass().getName(),"Invalid name-it must not be blank");
                continue;}
            break;
            }
        }catch(Exception e)
        {
            ErrorView.display(this.getClass().getName(),"Error reading input: "+e.getMessage());
      }
      return playersName;
    }
      

    private void displayWelcomeMessage(Player player) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.console.println("\n\n============================================");
        this.console.println("\t Welcome to the game  "+player.getName());
        this.console.println("\t We hope you have a lot of fun!");
        this.console.println("================================================");
    }
    @Override
    public boolean doAction(Object obj) {return false;}
}
