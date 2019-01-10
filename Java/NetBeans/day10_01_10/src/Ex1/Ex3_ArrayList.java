/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author younghoonkim
 */
public class Ex3_ArrayList {
    
    private ArrayList<String> list;
    private ArrayList<Integer> nList;
    private ArrayList<Client> clientList;
    public Ex3_ArrayList(){
        //jdk7~   new ArrayList<>();
        //~jdk6    new ArrayList<String>();
        
        
        list=new ArrayList<>();
        list.add("Test1");
        list.add("10");
        list.add("3.14");
        
        nList=new ArrayList<>();
        nList.add(1000);
        nList.add(2000);
        for(String e:list){
            System.out.println(e);
        }
        System.out.println("-----------------");
        for(Integer e:nList){
            System.out.println(e);
        }
        Iterator<String> it1=list.iterator();
        Iterator<Integer> it2=nList.iterator();
        while(it1.hasNext())
        {
            String e=it1.next();
            System.out.println(e);
        }
        while(it2.hasNext()){
            int e=it2.next();
            System.out.println(e);
        }
        
        Client client=new Client();
        client.setAge(28);
        client.setId("heyhey");
        client.setName("younghoon");
        
        clientList=new ArrayList<>();
        clientList.add(client);
        
        clientList.add(new Client("terryaa","younghoon",28));
        
        System.out.println("id : "+clientList.get(0).getId());
        
       
        
    }
    public static void main(String[] args) {
        new Ex3_ArrayList();
    }
}
