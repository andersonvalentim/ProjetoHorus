/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;
import org.taksmind.subnet.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.commons.net.util.SubnetUtils;

/**
 *
 * @author Vectro26
 */
public class TamanhoHost  {
      
    private int numfirst;

   

    

    public int getNumfirst() {
        return numfirst;
    }

    public void setNumfirst(int numfirst) {
        this.numfirst = numfirst;
    }

    public int getNumlast() {
        return numlast;
    }

    public void setNumlast(int numlast) {
        this.numlast = numlast;
    }
    private int numlast;

    void TamanhoHost() throws UnknownHostException, SocketException {
        InetAddress localHost = Inet4Address.getLocalHost();
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
        short x = networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
        String n = localHost.getHostAddress() + "/" + x;
        System.out.println(n);
        SubnetUtils utils = new SubnetUtils(n);
        Subnet sc = new Subnet();

        System.out.println(utils.getInfo());
        String first = utils.getInfo().getLowAddress();
        String last = utils.getInfo().getHighAddress();
        String[] iplast = last.split(Pattern.quote("."));
        String[] ipfirst = first.split(Pattern.quote("."));

        numfirst = Integer.parseInt(ipfirst[3]);
        numlast = Integer.parseInt(iplast[3]);

    }
    
        
}
