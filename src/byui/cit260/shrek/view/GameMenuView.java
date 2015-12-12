/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.GameControl;
import byui.cit260.shrek.control.MapControl;
import byui.cit260.shrek.model.Actor;
import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.InventoryItem;
import byui.cit260.shrek.model.Location;
import byui.cit260.shrek.model.Map;
import byui.cit260.shrek.model.Scene;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import shrek.Shrek;
/**
 *
 * @author bruno
 */
public class GameMenuView extends View {
    static GameMenuView gameMenu;
    private String filePath ="";
    public GameMenuView() {
    //private final String MENU="\n"
         super("\n"
    //private final String MENU="\n"
            +"\n----------------------------------------"
            +"\n|              Game Menu                |"
            +"\n----------------------------------------"
            +"\nV - View map"    
            +"\nM - Move to new location gaining money"      
            +"\nI - View list of inventory game tools sorted by type"
            +"\nS - View list of inventory game tools sorted by quantity in stock"
            +"\nA - List of enemies"    
            +"\nB - List of enemies sorted by name"    
            +"\nL - List of scenes"   
            +"\nN - List of scenes sorted by money gained" 
            +"\nR - Print inventory list report"
            +"\nP - Purchase a game tools participating to an adventure"
            +"\nC - Evaluate the total game tools list cost" 
            +"\nT - First adventure: rescue the princess from the tower"
            +"\nG - Second adventure: escape from the dragon"
            +"\nW - Third adventure: enter the town breaking its wall"
            +"\nE - Exit"
            +"\n----------------------------------------");
         }
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
        Game myGame = Shrek.getCurrentGame();
        InventoryItem[] inventory= myGame.getInventory();
        //Map myMap = myGame.getMap();
        switch (choice){
                
            case 'V':
                //Game myGame = Shrek.getCurrentGame();
                Map myMap = myGame.getMap();
                this.displayMap2(myMap);
                break;
            case 'A':
                //Game myGame = Shrek.getCurrentGame();
                this.listActors();
                break;
            case 'B':
                //Game myGame = Shrek.getCurrentGame();
                Actor[] myActor = Actor.values();
                String[] mylist = {"","","","",""};
                //Actor myActor;
                int i;
                for(i=0;i<5;i++)
                    mylist[i] = myActor[i].name();
                //for (Actor actor:myActor){
                  //   mylist[1] = myActor.toString();
                    //  }
                GameControl.getSortedStringList(mylist);
                 
                break;
            case 'L':
                //Game myGame = Shrek.getCurrentGame();
                this.viewListScenes();
                break;
            
            case 'M':
                this.chooseLocation();
                break;
            case 'I':
                this.viewInventory();
                break;
            case 'P':
                this.purchaseItem();
                break;
            case 'T':
                this.rescuePrincess();
                break;
            case 'G':
                this.goAway();
                break;
            case 'W':
                this.enterTown();
            break;
            case 'C':
                //InventoryItem[] inventory= myGame.getInventory();
                this.win();
                //this.diddsplayTotalCost(inventory);
                break;
            case 'S':
                //InventoryItem[] inventory= myGame.getInventory();
                this.viewInventoryQuantitySorted();
                break;
            case 'R':
                //InventoryItem[] inventory= myGame.getInventory();
                this.fileChoice();
                break;
            case 'E':
                return true;
            default:
                this.console.println("Enter the right value");
                break;              
       }
    return false;
    }
    
    private void win() {
        boolean a = Shrek.getCurrentGame().isWinPathway();
        boolean b = Shrek.getCurrentGame().isWinWall();
        boolean c = Shrek.getCurrentGame().isWinWeapon();
        this.console.println("Pathway:"+a+"Wall:"+b+"Weapon:"+c);
        
    }
    private void rescuePrincess() {
        this.console.println("***The goal is to rescue the Princess");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        WeaponMenuView myWeaponMenu= new WeaponMenuView();
        myWeaponMenu.display();
    }
    

    private void goAway() {
        this.console.println("***The goal is to escape from the dragon***");
        PathwayMenuView myPathwayMenu= new PathwayMenuView();
        myPathwayMenu.display();
    }

    private void enterTown() {
        WallMenuView myWallMenu=new WallMenuView();
        myWallMenu.display();
    }
    private void listActors() {
        Actor[] actors= Actor.values();
         for(Actor actor:actors) {
             this.console.println(actor+":"+actor.getDescription());
             
         }
    }
    private void viewListScenes() {
        Scene[] scenes=MapControl.createScenes();
        this.console.println("\nList of Scenes");
        this.console.println("\nDescription                  "+"\t"+
                            "Map Symbol"+"\t"+
                             "Money\n");
        for (Scene scene:scenes){
            this.console.println(scene.getDescription()+"\t"+
                                scene.getMapSymbol()+"\t"+
                                scene.getMoney());
                                
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewSortedListScenes() {
        Scene[] scenes=MapControl.createScenes();
        this.console.println("\nList of Scenes");
        this.console.println("\nDescription                  "+"\t"+
                            "Map Symbol"+"\t"+
                             "Money\n");
        for (Scene scene:scenes){
            this.console.println(scene.getDescription()+"\t"+
                                scene.getMapSymbol()+"\t"+
                                scene.getMoney());
                                
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void viewInventory() {
        InventoryItem[] inventory=GameControl.getInsertionSortedInventoryList();
        this.console.println("\nList of Inventory Items");
        this.console.println("\nType"+"\t"+
                            "Required"+"\t"+
                             "In Stock\t"
                            + "\"Cost for element\n");
        for (InventoryItem inventoryItem:inventory){
            this.console.println(inventoryItem.getInventoryType()+"\t"+
                                inventoryItem.getRequiredAmount()+"\t\t"+
                                inventoryItem.getQuantityInStock()+"\t\t"+
                                inventoryItem.getInventoryCost());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void purchaseItem(){
        PurchaseItemMenu myPurchase=new PurchaseItemMenu();
        myPurchase.display();
        //System.out.println("\nWhich Item do you want to purchase?");
        //System.out.println("\nSelect S-sword  A-arrow K-Knife");
        
    }

    private void displayMap2(Map map) {
                        
        Location[][] locations = map.getLocations();
        this.console.println("Shrek's Adventures Map: "
                + "\nevery cell if visited shows the money gained otherwise shows ??\n ");
        for(int i=0;i<locations.length;i++){
            this.console.print("row "+i+": ");
            //System.out.println(locations[i][0]);
            for (int j=0; j<locations[i].length;j++){ 
                this.console.print("|");
                
                Location location = locations[i][j];
                if (location.isVisited()){
                       Scene myScene=location.getScene();
                       this.console.print(myScene.getMoney());
                }
                else this.console.print("??");
                //this.console.print("|");
           
            }
            this.console.println("-");       
        }
      
    }
    
    private void displayMap(Map map) {

        Location[][] locations = map.getLocations();
        System.out.println("Shrek's Adventures Map");
        System.out.println("every cell visited shows the money gained");
            for(int i=0;i<locations.length;i++){
        //System.out.println(locations[i][0]);
                for (int j=0; j<locations[i].length;j++){ 
                    if (i == 0)
                    {
                       if (j == 0)
                       {
                       System.out.print(((i < 10) ? "Row: " : "Row: ") +i); //+"|"); 
                       }
                       System.out.print(((j < 10) ? "| " : "|") +j); //+"|");
                       if (j == (locations[i].length - 1))
                       System.out.print("|");
                    }
                    else
                    {
                    // Show Row number
                        if (j == 0)
                        System.out.print(((i < 10) ? "Row: " : "Row: ") +i+"|"); 
                        // System.out.print(i+"|");

                        Location location = locations[i][j];
                            if (location.isVisited()){
                            Scene myScene=location.getScene();
                            System.out.print(myScene.getMoney());
                            }
                            else 
                            System.out.print("??");
                            System.out.print("|");
                            }
                }
                System.out.println("-"); 
       }

    }

    private void displayTotalCost(InventoryItem[] inventory) {
        int cost=0;
        for (InventoryItem myItem:inventory) {
            cost = cost + myItem.getInventoryCost()*myItem.getQuantityInStock();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    this.console.println ("The total items cost is : "+cost);
  }

    private void viewInventoryQuantitySorted() {
        InventoryItem[] inventory=GameControl.getSortedQuantityInventoryList();
        this.console.println("\nList of Inventory Items");
        this.console.println("\nType"+"\t"+
                            "Required"+"\t"+
                             "In Stock\t"
                            + "\"Cost for element\n");
        for (InventoryItem inventoryItem:inventory){
            this.console.println(inventoryItem.getInventoryType()+"\t"+
                                inventoryItem.getRequiredAmount()+"\t\t"+
                                inventoryItem.getQuantityInStock()+"\t\t"+
                                inventoryItem.getInventoryCost());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void displayReportMenu() {
        
        ReportMenuView myReport = new ReportMenuView();
        myReport.display();
        
    }
    
    private void fileChoice() {
        this.console.println("\tEnter the file path for the file where the game is to be saved.");
        this.console.println("\tIt can be absolute (for example c:/users/filename.txt)");
        this.console.println("\tor relative (filename.txt), in this case it will be saved in the program directory");
        try{ 
            this.filePath = this.getInput();
            FileWriter outfile= new FileWriter(this.filePath);
            this.printInventoryReport();
        }catch(IOException ex){
            ErrorView.display(this.getClass().getName(),"I/O Error: "+ex.getMessage());
        }catch(Exception e){
            ErrorView.display(this.getClass().getName(),"Error: "+e.getMessage());
        }
        
    }
    
    public void printInventoryReport(){
        InventoryItem[] inventoryItems = GameControl.getSortedQuantityInventoryList();
       // if(!this.filePath.isEmpty()){
        try (PrintWriter out1 = new PrintWriter (this.filePath)) {
            out1.println("\n\n          Inventory Report ");
            out1.printf("%n%-20s%10s%10s","Type", "Quantity", "Price");
            out1.printf("%n%-20s%10s%10s","-----------","-----------","-----------");
            for(InventoryItem inventoryItem:inventoryItems){
                out1.printf("%n%-20s%10s%10s",inventoryItem.getInventoryType(),inventoryItem.getQuantityInStock(),inventoryItem.getInventoryCost());
            }
            this.console.println("\n The report was successfully printed to the specified path!");
          }catch(IOException ex){
            ErrorView.display(this.getClass().getName(),"I/O Error: "+ex.getMessage());
          }catch(Exception e){
            ErrorView.display(this.getClass().getName(),"Error: "+e.getMessage());
          }
     }
    
    private void chooseLocation() {
        //the actor choose the location where gain money
        Location[][] mylocation = Shrek.getCurrentGame().getMap().getLocations();
        boolean repeatDisplay = false;
        int x=0;
        int y=0;
        int totMoney=0;
        do {
          boolean value1=true;
          boolean value2=true;
          while(value1==true) { 
            this.console.println("Enter the integer coordinates x of the location between 0 an 19 or enter E to Exit"); 
            String value = this.getInput();
            if (value.equals("E")||value.equals("e"))return;
            try{
            x = Integer.parseInt(value);
            value1=false;
            }catch(NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),"You must enter a valid number.Try again or enter E to Exit");
            }
            catch (Throwable te){
            ErrorView.display(this.getClass().getName(),te.getMessage());
            te.printStackTrace();
            }
          } 
           
          while(value2==true) {
            this.console.println("Enter the integer coordinates x of the location between 0 an 19 or enter E to Exit");
            String value = this.getInput();
            if (value.equals("E")||value.equals("e"))return;
            try{
            y = Integer.parseInt(value);
            value2=false;
            }catch(NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),"You must enter a valid number.Try again or enter E to Exit ");}
            catch (Throwable te){
            ErrorView.display(this.getClass().getName(),te.getMessage());
            te.printStackTrace();
            }
            
         }
          //Shrek.getCurrentGame().setGain(x*y/10);
          int money=0;
          try{
          //if (mylocation[x][y].getScene().getMoney()>0)
          money=mylocation[x][y].getScene().getMoney();
          }catch (Exception te){
            ErrorView.display(this.getClass().getName(),"no money in this location");
            //te.printStackTrace();
            }
          if (mylocation[x][y].isVisited()==false)
             {Shrek.getCurrentGame().setGain(money);
             mylocation[x][y].setVisited(true);}
          else 
              {this.console.println("You already visited this location, so you cannot increase your gain!");
              }
          totMoney = Shrek.getCurrentGame().getGain();
          this.console.println(""
                  + "the Scene of this location is: "+mylocation[x][y].getScene().getDescription()
                  +"\nthe Enemy is:  "+mylocation[x][y].getActor()+"");
          this.console.println("The money you gained at this location is "+money);
          this.console.println("The total money you gained is "+totMoney);
        } while(repeatDisplay==true);
        
    }
    
}
        