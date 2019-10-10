/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TestThrowException {

    int number;

    void setNumber(int pNumber) throws CustomException {
        if (pNumber <= 0) {
            throw new CustomException("Number must be greater then 0");
        }
        number = pNumber;
    }

    public static void main(String[] args) {
        TestThrowException obj = new TestThrowException();
        try {
            obj.setNumber(-2);
        } catch (CustomException ex) {
            Logger.getLogger(TestThrowException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
