/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author younghoonkim
 */
public class Ex1_Map {
    
    public static void main(String[] args){
        //Map -> saves data in Key, Value format.(Entry)
        //Array saved in Map
        String[] msg={"AA","BB","CC","AA","DD","EE","FF"};
        HashMap<Integer,String> map=new HashMap<>();
        int cnt=0; //array starts
        for(String e : msg){
            map.put(cnt+1,e);
            cnt++;
        }
        System.out.println("Map:"+map.size());
        //to print, returns the reference of Entry having the Key.
        Set<Integer> keys=map.keySet();
        for(Integer e: keys){
            System.out.println(map.get(e));
        }
    }
    
}
