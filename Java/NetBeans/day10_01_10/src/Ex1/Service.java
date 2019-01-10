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
public class Service {
    private Ex5_LottoInter lotto;
    public void playLotto(int money){
        lotto=new Ex5_Lotto();
        int num=money/1000;
        lotto.setLottoGameNum(num);
    }
}
