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
import java.util.Scanner;
import shrek.Shrek;


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
            +"\nV - View map"     
            +"\nI - View list of item in inventory"
            +"\nP - Purchase an Item"
            //+"\nA - View list actors" 
            +"\nR - Shrek rescues the princess from the tower"
            +"\nG - Shrek goes away from the dragon"
            +"\nT - Shrek enters the town breaking the wall"
            +"\nE - Exit"
            +"\n----------------------------------------");
         }
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
        switch (choice){
            case 'V':
                Game myGame = Shrek.getCurrentGame();
                Map myMap = myGame.getMap();
                this.displayMap(myMap);
                break;
            case 'I':
                this.viewInventory();
                break;
            case 'P':
                this.purchaseItem();
                break;
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
        PathwayMenuView myPathwayMenu= new PathwayMenuView();
        myPathwayMenu.display();
    }

    private void enterTown() {
        WallMenuView myWallMenu=new WallMenuView();
        myWallMenu.display();
    }

    private void viewInventory() {
        InventoryItem[] inventory=GameControl.getInsertionSortedInventoryList();
        System.out.println("\nList of Inventory Items");
        System.out.println("\nType"+"\t"+
                            "Required"+"\t"+
                            "In Stock\n");
        for (InventoryItem inventoryItem:inventory){
            System.out.println(inventoryItem.getInventoryType()+"\t"+
                                inventoryItem.getRequiredAmount()+"\t\t"+
                                inventoryItem.getQuantityInStock());
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
        System.out.println("Shrek's Adventures Map");
        for(int i=0;i<locations.length;i++){
            System.out.println("row : "+i+" -");
            //System.out.println(locations[i][0]);
            for (int j=0; j<locations[i].length;j++){ 
                System.out.print(j+"|");
                
                Location location = locations[i][j];
                if (location.isVisited()){
                       Scene myScene=location.getScene();
                       System.out.println(myScene.getMapSymbol());
                }
                else System.out.println("??");
                System.out.println("|");
           
            }
            System.out.println("-");       
        }
      
 }
 
}
    
