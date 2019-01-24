/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import GUI.Grace_GUI;

/**
 *
 * @author younghoonkim
 */
public interface ServiceInter {
    
    public void displayDetailedInfo(Grace_GUI gui);
    public void serviceStart(Grace_GUI gui);
    public void reservationListRefresh(Grace_GUI gui);
    public void login(Grace_GUI gui);
    public void join(Grace_GUI gui);
    public void idCheck(Grace_GUI gui);
    public void makeReservation(Grace_GUI gui);
    public void checkID(Grace_GUI gui);
}
