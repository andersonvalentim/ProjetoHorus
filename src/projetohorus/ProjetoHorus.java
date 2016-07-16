package projetohorus;


import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JProgressBar;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Vectro26
 */
public class ProjetoHorus extends TamanhoHost implements Runnable {

    public static DadosColetadosPDF dados;
    public static Vector<String> IP = new Vector();

    public static Vector<String> NameHost = new Vector();

    static NetworkInterface rede;
    static PingIP ping = new PingIP();
    public static TamanhoHost tm = new TamanhoHost();

    public static void main(String[] args) throws UnknownHostException, IOException, DocumentException, InterruptedException, EmailException {

        tm.TamanhoHost();
        Thread scan0 = new Thread(new ThreadScan(tm.getNumfirst(), tm.getNumlast() / 2));
        Thread scan1 = new Thread(new ThreadScan(tm.getNumlast() / 2, tm.getNumlast()));

        scan0.start();
        scan1.start();
        scan0.join();
        scan1.join();

        ping.PingPortas();

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
