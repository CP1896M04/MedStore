/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i, n, c;
        System.out.println("Ban muon nhap bao nhieu?");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int arr[] = new int[n];
        System.out.println("Nhap vàoo là");
        for (i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            System.out.println("So thu" + " " + (i + 1) + " " + "la:" + arr[i]);

        }
        for (i = 0; i < n; i++) {
            System.out.println("Mang da duoc nhap la:" + Arrays.toString(arr));
            break;
        }
        for (i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    c=arr[j];
                    arr[j] = arr[i];
                   arr[i]=c;
                }
                 
            }
            System.out.print("So giam dan la:");
            for(i=0; i<n; i++){
               
            System.out.print("" + arr[i] + "\t");
               
        }
             System.out.println(" ");
            System.out.print("CHia het cho 5 la");
             for(i=0; i<n; i++){
                 if(arr[i]%5==0){
            
                System.out.print(""+ arr[i] +"\t" );
        }
             }
                 
        }
       

    }

}
