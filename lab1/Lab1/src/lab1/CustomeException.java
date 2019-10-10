/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
public class CustomeException extends Exception {
    String message;
    public CustomeException(String massage){
        this.message=message;
        
    }

    /**
     *
     * @return
     */
    public String getmessage(){
        return message;
    }

    /**
     * @param args the command line arguments
     */
   
    
}
