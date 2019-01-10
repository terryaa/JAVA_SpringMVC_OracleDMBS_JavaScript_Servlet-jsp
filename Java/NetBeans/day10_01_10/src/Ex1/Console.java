/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author younghoonkim
 */
public class Console {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("금액을 입력하세요:");
        int money=Integer.parseInt(sc.nextLine());
        
        Service service=new Service();
        service.playLotto(money);
       
    }
    
}
