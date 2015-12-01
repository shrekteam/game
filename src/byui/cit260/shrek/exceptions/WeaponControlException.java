/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.shrek.exceptions;

/**
 *
 * @author bruno
 */
public class WeaponControlException extends Exception{

    public WeaponControlException(String message) {
        super(message);
    }

    public WeaponControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeaponControlException(Throwable cause) {
        super(cause);
    }

    public WeaponControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WeaponControlException() {
    }
    
    
}

