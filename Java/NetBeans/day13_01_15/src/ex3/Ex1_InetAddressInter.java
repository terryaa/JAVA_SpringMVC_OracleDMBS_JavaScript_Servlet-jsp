/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author younghoonkim
 */
public interface Ex1_InetAddressInter {
    public void searchDomain(String ns) throws UnknownHostException;
    public ArrayList<String> getDomainList();
}
