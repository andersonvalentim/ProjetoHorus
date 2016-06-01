/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;

/**
 *
 * @author Vectro26
 */
public class PingIP extends Thread {

   
     String IP="";
     
     String [] Ips= IP.split("-");

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP +="-"+ IP;
    }
   
    
    void pingarportas(){
        
        
    }
    
}
