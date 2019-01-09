/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author younghoonkim
 */
public class MyMessageDemo {
    
    public String makeMessage(String name,boolean gender){
        
     StringBuffer sb=new StringBuffer();
     
     if(gender){
          sb.append("여성! 안녕하세요").append(name).append("님 반가워요!\n");
     }
     else{
          sb.append("남성! 안녕하세요").append(name).append("님 반가워요!\n");
     }
     return sb.toString();
    }
   
    public String makeMessage(String name){
        
     StringBuffer sb=new StringBuffer();
     
          sb.append("안녕하세요").append(name).append("님 반가워요!\n");
          
     return sb.toString();
    
    }
//    public static void main(String[] args) {
//        MyMessageDemo mmd=new MyMessageDemo();
//        String message=mmd.makeMessage("김길동");
//        System.out.println(message);
//               
//    }
    
}
