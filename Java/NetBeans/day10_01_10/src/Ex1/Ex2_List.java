/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author younghoonkim
 */
public class Ex2_List {
    private List list;
    public Ex2_List(){
        list=new ArrayList();
        list.add("StringAAA");
        list.add(new Integer(30));
        list.add(new Character('A'));
        list.add(new Float(3.14f));
        list.add("String");
        System.out.println("size"+list.size());
        Iterator it=list.iterator();
        
        //But! Object type is not recommended as a input of collection.
        //JDK5 ~>  use generic.
        while(it.hasNext()){
            Object o=it.next();
            if(o instanceof String)
            {
                System.out.print(o.getClass().getSimpleName());
                System.out.println(o.toString());
                System.out.print("String :");
                System.out.println(o);
            }
            if(o instanceof Integer){
                System.out.print(o.getClass().getSimpleName());
                System.out.println(o.toString());
                System.out.print("Integer :");
                System.out.println(o);
            }
            if(o instanceof Character)
            {
                 System.out.print(o.getClass().getSimpleName());
                System.out.println(o.toString());
                System.out.print("Character :");
                System.out.println(o);
            }
            if(o instanceof Float)
            {
                 System.out.print(o.getClass().getSimpleName());
                System.out.println(o.toString());
                System.out.print("Float :");
                System.out.println(o);
                
            }
            
            //does same operation as getSimpleName()
            String obj=o.getClass().getCanonicalName();
            System.out.println(obj.substring(obj.lastIndexOf(".")+1)+":");
            System.out.println(o);
            
                
            
        }
    }
    public static void main(String[] args) {
        Ex2_List ex=new Ex2_List();
    }
}
