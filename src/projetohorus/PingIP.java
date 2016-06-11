package projetohorus;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projetohorus.ProjetoHorus.IP;
import java.util.Vector; 
public class PingIP extends ProjetoHorus implements Runnable {
public static Vector Portas = new Vector();
    

    int i;
  
           
    String portas = "";

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas += portas;
    }
     

    public void PingPortas() throws InterruptedException {
         
        
        for (i = 0; i < IP.size(); i++) {
            
            portas = "";
          
              Thread t0 = new Thread(new Threads(i, 1, 204,1));
            Thread t1 = new Thread(new Threads(i, 205, 408,2));
            Thread t2 = new Thread(new Threads(i, 409, 612,3));
            Thread t3 = new Thread(new Threads(i, 613, 816,4));
            Thread t4 = new Thread(new Threads(i, 817, 1020,5));
            t0.start();
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t0.join();
            t1.join();
            t3.join();
            t4.join();
            
            portas = Portas.toString();
            Portas.add(i, portas);
            System.out.println(Portas.get(i));
            t0.stop();
            t1.stop();
            t2.stop();
            t3.stop();
            t4.stop();
        }

        try {
            pdf.GerarPDF();
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(PingIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
