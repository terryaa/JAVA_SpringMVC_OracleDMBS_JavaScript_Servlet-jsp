/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import Ex2.Cook;

/**
 *
 * @author younghoonkim
 */
public class KoreaCook extends Cook implements OrderInter {
    
    
    String[] order={"된장찌개","김치찌개","잡채"};
    String nation="한국";
    
    public String order(){
       return randomOrder(order,nation);
    }
    
}
