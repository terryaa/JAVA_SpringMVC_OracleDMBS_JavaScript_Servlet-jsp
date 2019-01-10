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
//ChinaCook selects random food, and generate result message. 
public class ChinaCook extends Cook implements OrderInter{
    
    
    public String order(){
        super.nation="중국";
       return randomOrder(order,nation);
    }
    
}
