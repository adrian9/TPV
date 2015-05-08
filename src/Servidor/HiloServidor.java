/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Filas
 */
public class HiloServidor extends Thread {

    private ServerSocket serverSocket;
    private CTPV ctpv;
   
    
    

    public HiloServidor(CTPV ctpv) {
        try {
            this.ctpv = ctpv;
            serverSocket = new ServerSocket(1234);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    //Función que nos permitirá escuchar las conexiones de los clientes
    private void escucharPeticiones() {
        try {

            while (true) {
                if (ctpv.getClientesAbiertos()<=6){
                    //Aceptamos la conexión y lanzamos el hilo que generará la ventana del TPVCliente en CTPV
                    Socket socketCliente = serverSocket.accept();
                    new HiloVentana(socketCliente, ctpv, ctpv.getClientesTotales()).start();
                    System.out.println("Clientes abiertos=" +ctpv.getClientesAbiertos());
                    sumarVentanas();
                }
            }
        } catch (IOException ex) {
        }
    }
    
    private void sumarVentanas(){
        ctpv.setClientesAbiertos(ctpv.getClientesAbiertos()+1);
        ctpv.setClientesTotales(ctpv.getClientesTotales()+1);
    }

    @Override
    public void run() {
        escucharPeticiones();
    }

}
