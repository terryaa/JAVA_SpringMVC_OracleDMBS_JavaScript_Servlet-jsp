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
public class Service extends GameInfo implements ServiceInter{
    
    
    //Declare WinRateInter Class to use calculate the winrate
    private WinRateInter winrate;
    //Declare Prize class to make a congratulations/failure message
    private Prize prize;
    
    
    
    //save inital information of the game. name / money.
    @Override
    public void setInfo(String name,int money){
        super.setName(name);
        super.setMoney(money);
        
    }
    
//    @Override
//    public void setMoney(int money){
//        super.setMoney(money);
//    }
//    
//    @Override
//    public int getMoney(){
//        return super.getMoney();
//    }
//    @Override
//    public int getTotal() {
//        return super.getTotal();
//    }
//
//    @Override
//    public void setTotal(int total) {
//        super.setTotal(total);
//    }
//
//    @Override
//    public int getWin() {
//        return super.getWin();
//    }
//
//    @Override
//    public void setWin(int win) {
//        super.setWin(win);
//    }
//
//    @Override
//    public double getWinRate() {
//        return super.getWinRate();
//    }
//
//    @Override
//    public void setWinRate(double winRate) {
//        super.setWinRate(winRate);
//    }
//
//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public void setName(String name) {
//        super.setName(name);
//    }
//
//    @Override
//    public int getCount() {
//        return super.getCount();
//    }
//
//    @Override
//    public void setCount(int count) {
//        super.setCount(count);
//    }
    
    //@gamePlay gets choice(even/odd) from user, 
    //compare it with random number.
    @Override
    public boolean gamePlay(int num){
        int oddEven=(int) (Math.random() * 10)%2;
        //if money is not enought to play one round
        if(super.money<500)
            return false;
        else
        {
            //money gets drawed.
            super.money=super.money-500;
            //if it's correct, win
            if(num==oddEven){
                super.win++;
            }
            //total played increases, count decreases.
            super.total++;
            super.count--;
            return true;
        }
    }
    
    //Calculate winRate and returns in String format.
    @Override
    public String winRate(){
        //Lamda implementation of WinRateInter's winrate method. 
        winrate=(total,win)->{
            return (win/(double)total)*100;
            };
        //use winrate.
        super.winRate=winrate.winRate(super.total, super.win);
        return String.format("%.3f",winRate);
        
    }
    
    //Generates a message depending on winrate. 
    @Override
    public String prize(){
        //Lamda implementation of Prize's prize method.
        prize=(winRate,name)->{
            if((winRate)>70){
            return name+ "! Congratulation!!You win the prize!";
        }
        else
            return name+"! Failed to win the prize.. try next time";
        };
        return prize.prize(super.winRate,super.name);
    }
    
    
    //initialize variables. developer can choose minimum play rounds(count).
    @Override
    public void init(int count){
        super.count=count;
        super.money=0;
        super.name="";
        super.total=0;
        super.win=0;
    }
    
    
    //returns gameinfo object containing all information of the game. 
    @Override
    public GameInfo getGameInfo(){
        return super.getGameInfo();
    }
    
}
