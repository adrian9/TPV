/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Filas
 */
public class HiloVentana extends Thread {

    private Socket clientSocket;
    private CTPV ctpv;
    private int numVentana;

    public HiloVentana(Socket clientSocket, CTPV ctpv, int numVentana) {
        this.clientSocket = clientSocket;
        this.ctpv = ctpv;
        this.numVentana = numVentana;
    }

    public void run() {
        //Creamos una ventana "modelo" de TPVClientes, la hacemos visible, y la añadimos al panel del CTPV
        TPVClientes tPVClientes = new TPVClientes();
        tPVClientes.setTitle("TPV "+numVentana);
        tPVClientes.setVisible(true);
        tPVClientes.repaint();
        ctpv.getjDesktopPane1().add(tPVClientes);
        while (true) {
            try {
                //Comprobamos si hemos cerrado ya el socket en el servidor
                if (!clientSocket.isClosed()) {
                    //Comprobamos si puede leer, si el resultado de la lectura es -1, el cliente habrá cerrado el socket
                    if (clientSocket.getInputStream().read() == -1) {
                        //Si el cliente ha cerrado el socket, lo cerramos 
                        clientSocket.close();
                        JOptionPane.showMessageDialog(tPVClientes, "Cliente atendido", "TPV Cerrado", JOptionPane.INFORMATION_MESSAGE);
                        //Quitamos el TPV del CTPV
                        tPVClientes.setVisible(false);
                        ctpv.getjDesktopPane1().remove(tPVClientes);
                        //Mostramos el mensaje de cliente atendido por pantalla
                        //tPVClientes.showMessage();
                        
                        //Actualizamos los componentes del panel
                        ctpv.updateUI();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
