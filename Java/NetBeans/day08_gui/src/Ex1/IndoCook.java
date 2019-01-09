/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import Ex2.OrderInter;
import Ex2.Cook;

/**
 *
 * @author younghoonkim
 */
public class IndoCook extends Cook implements OrderInter{
    
    String[] order={"커리","난","탄두리"};
    String nation="인도";
    
    public String order(){
       return randomOrder(order,nation);
    }
    
}
