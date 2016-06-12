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
    public static Vector PortasA = new Vector();
    int i;

    String portas = "";

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas += portas;
    }

    public void PingPortas() throws InterruptedException {

        for (int i = 0; i < IP.size(); i++) {

            portas = "";

            Thread t0 = new Thread(new Threads(i, 1, 102, 1));
            Thread t1 = new Thread(new Threads(i, 103, 204, 2));
            Thread t2 = new Thread(new Threads(i, 205, 306, 3));
            Thread t3 = new Thread(new Threads(i, 307, 408, 4));
            Thread t4 = new Thread(new Threads(i, 409, 510, 5));
            Thread t5 = new Thread(new Threads(i, 511, 612, 6));
            Thread t6 = new Thread(new Threads(i, 613, 715, 7));
            Thread t7 = new Thread(new Threads(i, 716, 817, 8));
            Thread t8 = new Thread(new Threads(i, 818, 919, 9));
            Thread t9 = new Thread(new Threads(i, 920, 1020, 10));
            t0.start();
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t8.start();
            t9.start();
            t0.join();
            t1.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            portas = Portas.toString();
            PortasA.add(i, portas);
            System.out.println(PortasA.get(i));
            t0.stop();
            t1.stop();
            t2.stop();
            t3.stop();
            t4.stop();
            t5.stop();
            t6.stop();
            t7.stop();
            t8.stop();
            t9.stop();
            Portas.clear();
        }

        try {
            pdf.GerarPDF();
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(PingIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
