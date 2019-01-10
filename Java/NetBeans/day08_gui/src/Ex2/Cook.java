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

//Every cook uses this method to get a random food, 
//and generate result String including nation, food.
public class Cook {
    
    public String randomOrder(String foods[],String nation){
        int size=foods.length;
        int num=(int)(Math.random()*size);
        return "주문하신 "+nation+"요리 : "+foods[num];
    }
    
}
