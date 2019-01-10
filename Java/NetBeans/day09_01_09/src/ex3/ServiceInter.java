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
//Interface of a class for Service Class
//Defines methods to proceed the game. 
public interface ServiceInter {
    
    public void setInfo(String name, int money);
            
    //Defines how the game proceed
    public boolean gamePlay(int num);
    //Calculate winrate and return in String. 
    public String winRate();
    //Determines whether winrate is high enough for a prize, return prize String. 
    public String prize();
    //initialize gameinfo
    public void init(int count);
    
    //Returns saved gameinfo
    public GameInfo getGameInfo();
}
