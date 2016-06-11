package projetohorus;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JProgressBar;

/**
 *
 * @author Vectro26
 */
public class ProjetoHorus extends Thread {

    public static DadosColetadosPDF dados;
    public static ArrayList<String> IP = new ArrayList<>();

    public static ArrayList<String> NameHost = new ArrayList<>();

    public static PingIP sc = new PingIP();
    static NetworkInterface rede;
    static PingIP ping = new PingIP();
    public static TamanhoHost tm = new TamanhoHost();
    public static int r;
    public static DadosColetadosPDF pdf = new DadosColetadosPDF();
     public static JProgressBar progresso = new JProgressBar();
		
     
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
                    String IpRede = address.getHostAddress();

                    System.out.println(IpRede + " está na rede " + "seu nome é:" + address.getHostName());

                    IP.add(IpRede);
                    NameHost.add(address.getHostName());
                }
            } catch (IOException ex) {
                Logger.getLogger(ProjetoHorus.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) throws UnknownHostException, IOException, DocumentException, InterruptedException {
   
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
                String IpRede = address.getHostAddress();

                System.out.println(IpRede + " está na rede " + "seu nome é:" + address.getHostName());

                IP.add(IpRede);
                NameHost.add(address.getHostName());
            }

        }

        System.out.println(IP.size());
        r = IP.size();
        ping.PingPortas();

   

    }

}
