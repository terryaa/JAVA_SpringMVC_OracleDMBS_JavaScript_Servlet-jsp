/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author younghoonkim
 */
public class Car_MT {
    private ArrayList<String> carList;
    public Car_MT(){
        carList=new ArrayList<>();
    }
    public String getCar(){
        String carName="";
        int carNum=(int)(Math.random()*3);
        switch(carNum){
            case 0: carName="New Grandeur1";break;
            case 1: carName="New Grandeur2";break;
            case 2: carName="New Grandeur3";break;
        }
        return carName;
    }
    public synchronized String pop(Thread t){
        String carName="";
        if(carList.size()==0){
            System.out.println("there's no car produced");
            System.out.println("Wait until the procedure is done");
            System.out.println("having a coffee");
            System.out.println("--------------");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Car_MT.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        carName=carList.remove(carList.size()-1);
        System.out.println("You've purchased a car");
        System.out.print("The information about your car:");
        System.out.println(carName+":"+t.getName());
        return carName;
    }
    public synchronized void push(String car,Thread t){
        carList.add(car);
        System.out.println("Your ordered car "+car+"is produced");
        System.out.println("Thread:"+t.getName());
        if(carList.size()==5){
            notify();
        }
    }
}
