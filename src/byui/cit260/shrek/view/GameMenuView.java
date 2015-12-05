/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.GameControl;
import byui.cit260.shrek.control.MapControl;
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
            +"\nI - View list of inventory items sorted by inventory type"
            +"\nS - View list of inventory items sorted by quantity in stock"
            +"\nR - Print inventory list Report"
            +"\nP - Purchase an item"
            +"\nC - Evaluate the total item list cost" 
            +"\nT - Shrek rescues the princess from the tower"
            +"\nG - Shrek goes away from the dragon"
            +"\nW - Shrek enters the town breaking the wall"
            +"\nE - Exit"
            +"\n----------------------------------------");
         }
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
        Game myGame = Shrek.getCurrentGame();
        InventoryItem[] inventory= myGame.getInventory();
        switch (choice){
            case 'V':
                //Game myGame = Shrek.getCurrentGame();
                Map myMap = myGame.getMap();
                this.displayMap(myMap);
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
                this.displayTotalCost(inventory);
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

    private void displayMap(Map map) {
                        
        Location[][] locations = map.getLocations();
        this.console.println("Shrek's Adventures Map");
        for(int i=0;i<locations.length;i++){
            this.console.println("row : "+i+" -");
            //System.out.println(locations[i][0]);
            for (int j=0; j<locations[i].length;j++){ 
                this.console.print(j+"|");
                
                Location location = locations[i][j];
                if (location.isVisited()){
                       Scene myScene=location.getScene();
                       this.console.println(myScene.getMapSymbol());
                }
                else this.console.println("??");
                this.console.println("|");
           
            }
            this.console.println("-");       
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
}
        