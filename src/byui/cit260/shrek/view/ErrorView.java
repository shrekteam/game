/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import byui.cit260.shrek.model.Game;
import byui.cit260.shrek.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;
import shrek.Shrek;

/**
 *
 * @author bruno
 */
public class ErrorView {
    private static final PrintWriter errorFile =Shrek.getOutFile();
    private static final PrintWriter logFile =Shrek.getLogFile();
    public static void display(String className,String errorMessage){
        errorFile.println(
        "------------------------------------------------------"
        +"\n-ERROR -"+  errorMessage
        +"\n---------------------------------------------------");
        logFile.println(className+"-"+ errorMessage);   
    }
    
}
