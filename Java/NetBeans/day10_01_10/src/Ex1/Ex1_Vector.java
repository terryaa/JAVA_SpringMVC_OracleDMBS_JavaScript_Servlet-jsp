/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author younghoonkim
 */
public class Ex1_Vector {
    public Ex1_Vector(){
        
        //List = > only saves collection object.
        //Every class in java extedns Object class.
        Vector v=new Vector();
        System.out.println("Initial capacity : "+v.capacity());
        System.out.println("Initial size : "+v.size());
        
        v.add("Test1");
        v.add("Test2");
        v.add("Test1");
        v.add("Test1");
        v.add("Test2");
        v.add("Test1");v.add("Test1");
        v.add("Test2");
        v.add("Test1");v.add("Test1");
        v.add("Test2");
        v.add("Test1");v.add("Test1");
        v.add("Test2");
        v.add("Test1");
        v.add("Test2");
        v.add("Test1");v.add("Test1");
        v.add("Test2");
        v.add("Test1");v.add("Test1");
        v.add("Test2");
        v.add("Test1");
        
        System.out.println("Capacity changed : "+v.capacity());
        System.out.println("Size changed : "+v.size());
        
        //not recommended
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }
        System.out.println("=================");
        
        // Whatever class or type is in vector v, 
        // Object e can aceess.
        for(Object e : v){
            System.out.println(e);
        }
        
        Iterator it=v.iterator();
        while(it.hasNext()){
            Object o=it.next();
            System.out.println(o);
        }
        
                
    }
    public static void main(String[] args) {
        Ex1_Vector ex=new Ex1_Vector();
    }
}
