package projetohorus;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Vectro26
 */
public class ProjetoHorus extends Thread {

    public static ArrayList<String> IP = new ArrayList<String>();
    public static PingIP sc = new PingIP();
    static NetworkInterface rede;

    public static TamanhoHost tm = new TamanhoHost();

    @Override
    public void run() {

        InetAddress localhost = null;
        try {
            localhost = InetAddress.getLocalHost(); // me retorna o IP do Host
        } catch (UnknownHostException ex) {
            Logger.getLogger(ProjetoHorus.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] ip = localhost.getAddress(); // me retorna o endereço(não se esquecer disso!!)

        for (int i = tm.getNumlast() / 2; i <= tm.getNumlast(); i++) {

            System.out.println(i);
            ip[3] = (byte) i;
            InetAddress address = null;
            try {
                address = InetAddress.getByAddress(ip);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ProjetoHorus.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (address.isReachable(1700)) //testa o IP para ver se ele está disponivel
                {
                    String IpRede = address.toString();

                    System.out.println(IpRede + " está na rede " + "seu nome é:" + address.getHostAddress());
                    sc.setIP(IpRede);
                    IP.add(IpRede);

                }
            } catch (IOException ex) {
                Logger.getLogger(ProjetoHorus.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) throws UnknownHostException, IOException {

        tm.TamanhoHost();

        InetAddress localhost = InetAddress.getLocalHost(); // me retorna o IP do Host
        Thread myThread = new ProjetoHorus();
        myThread.start();
        byte[] ip = localhost.getAddress(); // me retorna o endereço(não se esquecer disso!!)

        for (int i = tm.getNumfirst(); i <= tm.getNumlast() / 2; i++) {

            System.out.println(i);
            ip[3] = (byte) i;
            InetAddress address = InetAddress.getByAddress(ip);

            if (address.isReachable(1700)) //testa o IP para ver se ele está disponivel
            {
                String IpRede = address.toString();

                System.out.println(IpRede + " está na rede " + "seu nome é:" + address.getHostAddress());
                sc.setIP(IpRede);
                IP.add(IpRede);
            }
           
        }
        
        
         System.out.println(IP.size());

    }

}
