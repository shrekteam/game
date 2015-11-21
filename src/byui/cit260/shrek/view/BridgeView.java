/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.control.BridgeControl;
import byui.cit260.shrek.model.BridgeGame;
import java.util.Scanner;

/**
 *
 * @author Vlad
 */
public class BridgeView extends View {
    
    
    private String key = "\n"
            + " \n" +
"Bridge\n" +
"\n" +
"D - dragon\n" +
"> - flame\n" +
"0 - hole\n" +
"S - Shrek and friend\n" +
"\n";
     
    private String board = "\n"+
"________________________________________________________________________________\n" +
"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n" +
"      D       >>        0                      0                       0       -\n" +
"  _ddd                                 $       0        0                      -\n" +
" /                                   0         0          0                    -\n" +
"________________________________________________________________________________\n" +
"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n" +
"            ";
    public BridgeView() { super("\n" +
            "(c)rawl\n"+
            "(j)ump\n"+
            "(r)un\n");
    }

    public void display(){
        String value;
        do {
            System.out.println(this.key);
            System.out.println(this.board);
            System.out.println(this.promptMessage);
            value = this.getInput();
            this.doAction(value);
        } while(!value.equals("Q"));
    }
   
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;
        
        while(!valid) {
            System.out.println("\t\nEnter your selection below:");
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            }
            break;
        }
        return selection;
    }
    @Override
    public boolean doAction(Object obj) {
        String value= (String)obj;
        value= value.toUpperCase();
        char choice = value.charAt(0);
        switch (choice){
            case'C':
                BridgeControl.crawl();
                break;
            case'J':
                BridgeControl.jump();
                break;
            case 'R':
                BridgeControl.run();
                break;
                
            default:
                System.out.println("Enter the value");
                break;   
        }
        return true;
    }
    
}