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
    
    /**
     *
     * @param num
     * @return
     */
    private WinRateInter winrate;
    private Prize prize;
    private GameInfo gameinfo;
    
    
    
    
    @Override
    public void setInfo(String name,int money){
        super.setName(name);
        super.setMoney(money);
        
    }
    
    @Override
    public void setMoney(int money){
        super.setMoney(money);
    }
    
    @Override
    public int getMoney(){
        return super.getMoney();
    }
    @Override
    public int getTotal() {
        return super.getTotal();
    }

    @Override
    public void setTotal(int total) {
        super.setTotal(total);
    }

    @Override
    public int getWin() {
        return super.getWin();
    }

    @Override
    public void setWin(int win) {
        super.setWin(win);
    }

    @Override
    public double getWinRate() {
        return super.getWinRate();
    }

    @Override
    public void setWinRate(double winRate) {
        super.setWinRate(winRate);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public void setCount(int count) {
        super.setCount(count);
    }
    
    
    @Override
    public boolean oddEven(int num){
        int oddEven=(int) (Math.random() * 10)%2;
        if(super.money<500)
            return false;
        else
        {
            super.money=super.money-500;
            if(num==oddEven){
                super.win++;
            }
            super.total++;
            super.count--;
            return true;
        }
    }
    @Override
    public String winRate(){
        winrate=(total,win)->{
            return (win/(double)total)*100;
            };
        winRate=winrate.winRate(super.total, super.win);
        return String.format("%.3f",winRate);
        
    }
    @Override
    public String prize(){
        prize=new Prize();
        return prize.prize(winRate,super.name);
    }
    
    @Override
    public void init(){
        super.count=8;
        super.money=0;
        super.name="";
        super.total=0;
        super.win=0;
    }
    
}
