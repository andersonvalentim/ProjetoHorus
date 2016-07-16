/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projetohorus.ProjetoHorus.IP;
import static projetohorus.ProjetoHorus.NameHost;
import static projetohorus.ProjetoHorus.tm;

/**
 *
 * @author Vectro26
 */
public class ThreadScan extends ProjetoHorus {

    private int comeco;
    private int fim;

    ThreadScan(int comeco, int fim) {

        this.comeco = comeco;
        this.fim = fim;

    }

    @Override
    public void run() {

        InetAddress localhost = null;
        try {
            localhost = InetAddress.getLocalHost(); // me retorna o IP do Host
        } catch (UnknownHostException ex) {
            Logger.getLogger(ThreadScan.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] ip = localhost.getAddress(); // me retorna o endereço(não se esquecer disso!!)

        for (int i = comeco; i <= fim; i++) {

            System.out.println(i);
            ip[3] = (byte) i;
            InetAddress address = null;
            try {
                address = InetAddress.getByAddress(ip);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ThreadScan.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ThreadScan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
;

}
