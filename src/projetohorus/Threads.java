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
public class Threads extends PingIP {

    
    private int numIP;
    private int inicio;
    private int fim;
    
    int ports;

    Threads(int numIP, int inicio, int fim, String portas2, int ports) {
        this.numIP = numIP;
        this.inicio = inicio;
        this.fim = fim;
        
        this.ports = ports;

    }

    public Threads(int numIP, int inicio, int fim, int ports) {
        this.numIP = numIP;
        this.inicio = inicio;
        this.fim = fim;
        this.ports = ports;

    }

    @Override
    public void run() {
       Portas.clear();
       
        try {

            // Inet address  é um dos identificadores de um computador ou dispositivo
            // conectado à rede;
            // Obtém o endereço com base no IP informado
            InetAddress addr = InetAddress.getByName(IP.get(numIP));

            // Obtém o nome do computador/dispositivo pelo endereço IP informado
            String hostname = addr.getHostName();
               String portas2 = null;
            for (int j = inicio; j <= fim; j++) {
                Socket s = null;

                try {
                    // Tenta abrir uma conexão na porta 'j'
                    System.out.println("entrou2 " + j);
                    s = new Socket(addr, j);
                    // Caso consiga..
                    System.out.println("1 " + j + " está aberta em: " + hostname);
                    Portas.add(j + " ");
                    
                    
                } catch (IOException ex) {
                } finally {
                    try {
                        // Fecha o socket
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
