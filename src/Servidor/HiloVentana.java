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

/**
 *
 * @author Filas
 */
public class HiloVentana extends Thread {

    private Socket clientSocket;
    private CTPV ctpv;

    public HiloVentana(Socket clientSocket, CTPV ctpv) {
        this.clientSocket = clientSocket;
        this.ctpv = ctpv;
    }

    public void run() {
        //Creamos una ventana "modelo" de TPVClientes, la hacemos visible, y la añadimos al panel del CTPV
        TPVClientes tPVClientes = new TPVClientes();
        tPVClientes.setVisible(true);
        ctpv.getjDesktopPane1().add(tPVClientes);
        while (true) {
            try {
                //Comprobamos si hemos cerrado ya el socket en el servidor
                if (!clientSocket.isClosed()) {
                    //Comprobamos si puede leer, si el resultado de la lectura es -1, el cliente habrá cerrado el socket
                    if (clientSocket.getInputStream().read() == -1) {
                        //Si el cliente ha cerrado el socket, lo cerramos 
                        clientSocket.close();
                        //Quitamos el TPV del CTPV
                        tPVClientes.setVisible(false);
                        ctpv.getjDesktopPane1().remove(tPVClientes);
                        //Mostramos el mensaje de cliente atendido por pantalla
                        ctpv.showMessage();
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
