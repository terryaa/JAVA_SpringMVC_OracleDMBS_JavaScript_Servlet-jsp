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

//OrderInter defines an interface for a Order.
//every class extending Orderinter must have a order method that
//randomly selects a food and 
public interface OrderInter {
    
    //숫자를 한개 입력받아 해당 숫자에 해당하는 나라의 음식을 한개 리턴한다.
    public String order();
    
}
