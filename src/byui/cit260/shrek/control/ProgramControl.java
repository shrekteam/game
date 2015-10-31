/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.control;

import byui.cit260.shrek.model.Player;
import shrek.CuriousWorkmanship;

/**
 *
 * @author bruno
 */
public class ProgramControl {

    public static Player createPlayer(String name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(name==null){
            return null;
        }
        Player player = new Player();
        player.setName(name);
        CuriousWorkmanship.setPlayer(player);
        //System.out.println("\n** createPlayer function called");
        return player;
    }
    
}
