/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeeHiveNumbering;

import java.util.Scanner;

/**
 *
 * @author younghoonkim
 */
public class BeeHiveNumbering {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int goal=2;
        int i=1;
        while(num>=goal){
            goal=goal+6*i;
            i++;
        }
        System.out.println(i);
    }
}
