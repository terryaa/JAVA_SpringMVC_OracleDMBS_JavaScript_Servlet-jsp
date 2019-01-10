/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author younghoonkim
 */
public class LinkedListExample {
    
    public static void main(String[] args) {
       
        List<String> list1;
        //List<String> list2;
        
        //list2=new LinkedList<>();
        System.out.print("1 or 2 를 입력하세요 : ");
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());
        if(num==1){
            //new ElapsedTime().elapsedTime(list1);
            list1=new ArrayList<>();
            elapsedTime(list1);
        }
        else{
            //new ElapsedTime().elapsedTime(list2);
            list1=new LinkedList<>();
            elapsedTime(list1);
        }
        
        
       
    }
    private static void elapsedTime(List<String> list){
        long startTime;
        long endTime;
        
        startTime=System.nanoTime();
        
        for(int i=0;i<100000;i++){
            list.add(String.valueOf(i));
        }
        endTime=System.nanoTime();
        System.out.println(list.getClass().getSimpleName()+" 걸린시간 : "+(endTime-startTime)+" ns");
               
    }
}
