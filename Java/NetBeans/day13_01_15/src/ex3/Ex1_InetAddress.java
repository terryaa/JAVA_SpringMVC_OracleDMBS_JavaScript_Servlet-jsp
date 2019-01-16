/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author younghoonkim
 */
public class Ex1_InetAddress implements Ex1_InetAddressInter{

    
    private InetAddress[] ar;
    
    
    @Override
    public void searchDomain(String ns) throws UnknownHostException {
        ar=InetAddress.getAllByName(ns);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getDomainList() {
        ArrayList<String> list=new ArrayList<>();
        for(InetAddress e:ar){
            list.add(e.getHostAddress());
        }
        return list;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
