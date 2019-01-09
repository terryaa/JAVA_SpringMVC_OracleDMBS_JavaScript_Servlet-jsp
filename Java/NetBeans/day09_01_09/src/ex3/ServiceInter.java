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
//Interface of a class for 
public interface ServiceInter {
    
    public void setInfo(String name, int money);
            
            
    public boolean oddEven(int num);
    public String winRate();
    public String prize();
    public void init();
    
    public int getTotal();
    public void setTotal(int total) ;
    public int getWin();
    public void setWin(int win);
    public double getWinRate();
    public void setWinRate(double winRate);
     public int getMoney();
     public void setMoney(int money);
     public String getName();
     public void setName(String name);
     public int getCount();
      public void setCount(int count);
}
