/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.TreeSet;
/**
 *
 * @author younghoonkim
 */
public class Ex5_Lotto implements Ex5_LottoInter{
    @Override
    public String getLottoNum(){
         TreeSet<Integer> tree=new TreeSet<>();
         StringBuffer sb=new StringBuffer();
        while(tree.size()!=6){
            tree.add((int)(Math.random()*45+1));
        }
        for(Integer e: tree){
           sb.append(String.valueOf(e)+" ");
        }
        
        return sb.toString();
    }
    @Override
    public void setLottoGameNum(int num){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<num;i++){
            sb.append("No[").append((i+1)+"] : ").append(getLottoNum()+"\n");
        }
        System.out.println(sb.toString());
        
    }
    
    
    
}
