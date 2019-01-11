/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author younghoonkim
 */

//Build as this doesnt depend on a speific UI
public class Ex2_MemberJoin implements Ex2_MemberJoinInter{
//Field declaration
    //Afterwards, here there would be objects with real repository
    public ArrayList<Map<String,String>> list;
    public Ex2_MemberJoin(){
        list=new ArrayList<>();
    }
    //check the input value
    private boolean checkValue(){
        //checks if the speicfic value exists here
        //condition (age,sex ..etc)
        return true;
    }
    
    @Override
     public void setAddMember(Map<String,String> map){
            if(!checkValue()){ //this might be the main function of this class
            System.out.println("There's no member information");
            }
              list.add(map);
              
     }
     
    @Override
    public ArrayList<Map<String,String>> getList(){
    
        return new ArrayList<>();
    }
    
    
    
    
}
