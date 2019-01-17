/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeeHiveNumbering;

/**
 *
 * @author younghoonkim
 */
public class Nation124 {
    public static void main(String[] args) {
        int num=25;
        int result=0;
        int i=1;
        int tempp=num;
        //decide how many digits
        for(;;i++){
            if(tempp<=Math.pow(3, i)){
                break;
            }
            tempp-=Math.pow(3, i);
        } 
        //first digit
        result=num%3;
        if(num%3==0){
            result+=4;
        }
        num-=3;
        
        for(int j=1;j<i;j++)
        {
            int temp=(int) ( (int)( ((num-1)%(Math.pow(3*3,j)) )/3 +1)*Math.pow(10,j));
            if(temp==3*Math.pow(10, j))
                result+=Math.pow(10,j)+temp;
            else
                result+=temp;
            
            num-=Math.pow(3,j+1)-1;
        }
        
//        }
//        num-=4;
//        int temp=(((num%9)/3)+1)*10;
//        if(30==temp){
//        result+=10+temp;
//    }
//        else
//            result+=temp;
//        
//        num-=8;
//        temp=(((num%27)/9+1)*100);
//        if(300==temp){
//        result+=100+temp;
//        }
//        else
//            result+=temp;
        System.out.println(result);
//    }
//    
    }      
    
    
}
