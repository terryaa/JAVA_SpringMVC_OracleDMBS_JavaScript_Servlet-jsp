/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;


/**
 *
 * @author younghoonkim
 */

//Service runs Cook's children depending on user's button input. 
//Them returns a message containing random food,nation, name.
//
public class ServiceCook implements ServiceInter{
    
    public String service(int num,String name){
        
        String msg="";
        switch(num){
            case 1:
                msg= new KoreaCook().order();
                break;
            case 2:
                msg= new ChinaCook().order();
                break;
            case 3:
                msg= new IndoCook().order();
                break;
            default:
                msg= "에러";
                break;
        }
        return name+"님이 "+msg+"\n";
    }
    
}
