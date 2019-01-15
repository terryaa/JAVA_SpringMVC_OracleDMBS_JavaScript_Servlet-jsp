/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Account {
    private int balance;
    public void withdraw(int money){
        if(balance>=money){
            try {
                Thread.sleep(1000);
                balance-=money;
            } catch (InterruptedException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        System.out.println("check: "+balance);
    }
    
    
}
