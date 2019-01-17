/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJO.Member;

/**
 *
 * @author younghoonkim
 */
public interface HandleData {
   public Member load();
   public boolean add(Member m);
   public boolean delete(Member m);
}
