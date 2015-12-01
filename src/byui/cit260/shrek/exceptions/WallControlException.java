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
public class WallControlException extends Exception{

    public WallControlException(String message) {
        super(message);
    }

    public WallControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public WallControlException(Throwable cause) {
        super(cause);
    }

    public WallControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WallControlException() {
    }
    
    
}

