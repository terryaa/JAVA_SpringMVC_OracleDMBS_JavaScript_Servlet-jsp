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
public interface OrderInter {
    //나라 이름을 저장할 필드멤버
    String[] order={"요리입력"};
    String nation="나라입력";
    
    //숫자를 한개 입력받아 해당 숫자에 해당하는 나라의 음식을 한개 리턴한다.
    public String order();
    
}
