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
public class PathwayControlException extends Exception{

    public PathwayControlException(String message) {
        super(message);
    }

    public PathwayControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PathwayControlException(Throwable cause) {
        super(cause);
    }

    public PathwayControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PathwayControlException() {
    }
    
    
}

