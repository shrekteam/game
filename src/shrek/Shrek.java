


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shrek;

import byui.cit260.shrek.model.Player;

/**
 *
 * @author bruno
 */
public class Shrek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player playerOne = new Player();
        playerOne.setName("Fred Flinstone");
        playerOne.setBestTime(7.00);
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
