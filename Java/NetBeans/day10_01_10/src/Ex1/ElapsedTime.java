/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.List;

/**
 *
 * @author younghoonkim
 */
public class ElapsedTime {
    public void elapsedTime(List<String> list){
        long startTime;
        long endTime;
        
        startTime=System.nanoTime();
        for(int i=0;i<100000;i++){
            list.add(String.valueOf(i));
        }
        endTime=System.nanoTime();
        System.out.println(list.getClass().getSimpleName()+" 걸린시간 : "+(endTime-startTime)+" ns");
               
    }
    
}
