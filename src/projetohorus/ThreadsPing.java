/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohorus;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;
import static projetohorus.ProjetoHorus.IP;

/**
 *
 * @author Vectro26
 */
public class ThreadsPing extends PingIP {

    private int numIP;
    private int inicio;
    private int fim;

    int ports;

    ThreadsPing(int numIP, int inicio, int fim, String portas2, int ports) {
        this.numIP = numIP;
        this.inicio = inicio;
        this.fim = fim;

        this.ports = ports;

    }

    public ThreadsPing(int numIP, int inicio, int fim, int ports) {
        this.numIP = numIP;
        this.inicio = inicio;
        this.fim = fim;
        this.ports = ports;

    }

    @Override
    public void run() {

        try {

            InetAddress addr = InetAddress.getByName(IP.get(numIP));

            String hostname = addr.getHostName();
           
            for (int j = inicio; j <= fim; j++) {
                Socket s = null;

                try {
                    System.out.println(ports + "   Thread " + j);
                    s = new Socket(addr.getHostAddress(), j);

                    System.out.println( j + " está aberta em: " + hostname);
                    Portas.add(j + " ");

                    
                } catch (IOException ex) {
                } finally {
                    try {
                        if (s != null) {
                            s.close();
                        }
                    } catch (IOException ex) {
                    }
                }

            }

        } catch (UnknownHostException ex) {
            System.err.println(ex);
        }

    }

};
