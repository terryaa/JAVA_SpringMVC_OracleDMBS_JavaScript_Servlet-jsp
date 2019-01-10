/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author younghoonkim
 * @Prize class has one method.
 * @prize take winrate as a parameter,
 * returns a congratulations message when winrate is higher then 70. 
 */

public interface Prize {
    public String prize(double winRate,String name);
    
}
