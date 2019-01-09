/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author younghoonkim
 */
public class CookParent {
    
    private String nation="중국";
    
    public String getNation(){
        return this.nation;
    }
    public String order(int num){
        switch(num){
            case 1:
                return "요리1";
            case 2:
                return "요리2";
            case 3:
                return "요리3";
            default:
                return "요리4";
        }
          
        
    }
}
