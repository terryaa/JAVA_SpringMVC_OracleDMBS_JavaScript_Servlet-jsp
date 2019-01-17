/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author younghoonkim
 */
public interface Error {
    
    //텍스트 필드가 빈칸인지 확인하고 에러메세지를 리턴한다.
    public String blank();
    
    //텍스트 필드가 입력에 적합한 타입으로 작성하였는지 확인하고 에러메세지를 리턴한다. 
    public String wrongType();
    
    //클릭한 버튼이 진행할 동작이 불가능할때 에러메세지를 리턴한다. 
    public String clickNull();
    
    
}
