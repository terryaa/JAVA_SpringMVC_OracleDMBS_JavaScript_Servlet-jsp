/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.Scanner;

/**
 *
 * @author younghoonkim
 */
public class Console {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //이름과 나라를 입력받음
        System.out.println("이름 :");
        String name=sc.nextLine();
        System.out.println("1.한국 2.중국 3.인도 :");
        int num=Integer.parseInt(sc.nextLine());
        //숫자에 따라 한국,중국,인도 음식 결정. 
        //각 case별로 randomOrder에 의해 랜덤한 해당 나라의 음식을 포함한 결과 String이리턴됨
        ServiceInter service=new ServiceCook();
        String msg=service.service(num, name);
        System.out.println(msg);
        
    }
    
}
