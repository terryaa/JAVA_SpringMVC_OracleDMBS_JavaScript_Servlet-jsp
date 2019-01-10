/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author younghoonkim
 */
public class Ex4_Set {
    public static void main(String[] args) {
        HashSet<String> h1 =new HashSet<>();
        
        h1.add("ZTest");
        h1.add("BTest");
        h1.add("ATest");
        h1.add("CTest");
        h1.add("BTest");
        System.out.println("size:"+h1.size());
        for(String e:h1){
            System.out.println(e);
        }
        Iterator<String> it=h1.iterator();
        System.out.println("-----------------------");
        while(it.hasNext()){
            String next=it.next();
            System.out.println(next);
        }
        
    }
}
