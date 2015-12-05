/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.GameControl;
import byui.cit260.shrek.model.InventoryItem;
import byui.cit260.shrek.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class ReportMenuView extends View {
    private String filePath ="";
    public ReportMenuView() {
    //private final String MENU="\n"
         super("\n"
            +"\n----------------------------------------"
            +"\n|              Report Menu                |"
            +"\n----------------------------------------"
            +"\nP - Print the Report into the file"
            +"\nF - Choose the file path"
            +"\nD - Display the report"
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
            case 'P':
                this.displayReport();
                break;
            case 'F':
                this.fileChoice();
                break;
            case 'D':
                this.printReport();
                break;
            case 'E':
                return true;
            default:
                this.console.println("Enter the right value");
                break;              
       }
    return false;
    }
    public void displayReport(){
     InventoryItem[] inventoryItems = GameControl.getInsertionSortedInventoryList();
     if(!this.filePath.isEmpty()){
        try (PrintWriter out1 = new PrintWriter (this.filePath)) {
            out1.println("\n\n          Inventory Report ");
            out1.printf("%n%-20s%10s%10s","Type", "Quantity", "Price");
            out1.printf("%n%-20s%10s%10s","-----------","-----------","-----------");
            for(InventoryItem inventoryItem:inventoryItems){
                out1.printf("%n%-20s%10s%10s",inventoryItem.getInventoryType(),inventoryItem.getQuantityInStock(),inventoryItem.getInventoryCost());
                
            }
            out1.close();
        }catch(IOException ex){
           ErrorView.display(this.getClass().getName(),"I/O Error: "+ex.getMessage());
        }finally{
            
           // out1.close();
        }
      
      }
    else{this.console.println("Befor printing choose to enter the file path");};
   }
    private void fileChoice() {
        this.console.println("\nEnter the file path for file where the game is to be saved");
        this.filePath = this.getInput();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void printReport() {
        InventoryItem[] inventoryItems = GameControl.getInsertionSortedInventoryList();
        try (PrintWriter out1 = new PrintWriter (this.console)) {
            out1.println("\n\n          Inventory Report ");
            out1.printf("%n%-20s%10s%10s","Type", "Quantity", "Price");
            out1.printf("%n%-20s%10s%10s","-----------","-----------","-----------");
            for(InventoryItem inventoryItem:inventoryItems){
                out1.printf("%n%-20s%10s%10s",inventoryItem.getInventoryType(),inventoryItem.getQuantityInStock(),inventoryItem.getInventoryCost());
                
            }
            out1.append("\n");
            this.display();
            //out1.close();
        }catch(Exception ex){
           ErrorView.display(this.getClass().getName(),"I/O Error: "+ex.getMessage());
        }finally{
            
          // return;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
