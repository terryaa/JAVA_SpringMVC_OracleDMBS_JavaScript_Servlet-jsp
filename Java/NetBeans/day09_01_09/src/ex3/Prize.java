/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author younghoonkim
 */
public class Prize {
    public String prize(double winRate,String name){
        if((winRate)>70){
            return name+ "! Congratulation!!You win the prize!";
        }
        else
            return name+"! Failed to win the prize.. try next time";
    }
    
}
