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
    
    foods={"훠궈","마라탕","팔보채"};
    nation="중국";
    
    public String order(){
       return randomOrder(order,nation);
    }
    
}
