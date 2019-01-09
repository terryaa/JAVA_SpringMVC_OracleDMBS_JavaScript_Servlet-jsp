/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import com.sun.xml.internal.stream.Entity;
import java.util.Scanner;

/**
 *
 * @author younghoonkim
 */
public class MyChatConsoleDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Name:");
        String name=sc.nextLine();
        //입력 받은 이름에 출력을 "안녕하세요 000님"으로한다.
//        StringBuffer sb=new StringBuffer();
//        sb.append("안녕하세요.").append(name).append("님. 환영합니다.");
        MyMessageDemo mmd=new MyMessageDemo();
        System.out.println(mmd.makeMessage(name));
//        
                
    }
}
