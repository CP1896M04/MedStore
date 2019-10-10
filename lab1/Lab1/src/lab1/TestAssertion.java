/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.*;

/**
 *
 * @author Admin
 */
public class TestAssertion {

    public static void main(String[] args) {
        int a;
        Scanner input = new Scanner(System.in);
        System.out.println("please enter number a");
        a = input.nextInt();
        assert (a >0 && a<10 ) : "The number must be greater than 0 and less than 10";
         
        System.out.println("Number OK");

    }
}
