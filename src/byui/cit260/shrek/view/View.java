/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import shrek.Shrek;
import byui.cit260.shrek.view.ErrorView;

/**
 *
 * @author bruno
 */
public abstract class View implements ViewInterface{
    protected String promptMessage;
    protected final BufferedReader keyboard= Shrek.getInFile();
    protected final PrintWriter console= Shrek.getOutFile();

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    public View(String promptMessage){
        this.promptMessage=promptMessage;
    }
    
  @Override
  public void display(){
    String value="";
    boolean done = false;
     do {
            //System.out.println(this.promptMessage);
            this.console.println(this.promptMessage);
            value = this.getInput();
            done =this.doAction(value);
        } while(!done);
  }  
  @Override
  public String getInput(){
      boolean valid = false;
      String value = null;
   try{
      while(!valid){
          value=this.keyboard.readLine();
          value=value.trim();
          if(value.length()<1){
             // System.out.println("You must enter a value");
              ErrorView.display(this.getClass().getName(),"You must enter a value");
              continue;
          }
          break;
      }
      }catch (Exception e){
             ErrorView.display(this.getClass().getName(),"Error reading input:"+e.getMessage());
           }
   return value;
  
  }

}