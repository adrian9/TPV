/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        tPVClientes.setTitle("TPV " + numVentana);
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
                        //Mostramos el mensaje de cliente atendido por pantalla
                        JOptionPane.showMessageDialog(tPVClientes, "Cliente atendido", "TPV Cerrado", JOptionPane.INFORMATION_MESSAGE);
                        //Quitamos el TPV del CTPV
                        tPVClientes.setVisible(false);
                        ctpv.getjDesktopPane1().remove(tPVClientes);
                        
                        //tPVClientes.showMessage();

                        //Actualizamos los componentes del panel
                        ctpv.updateUI();
                    } else {

                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String inputLine = in.readLine();
                        if (inputLine.startsWith("[TOTAL]")) {
                            tPVClientes.getLbl_total().setText(inputLine.replace("[TOTAL]", ""));
                        } else if (inputLine.startsWith("[PEDIDO]")) {
                            boolean esta = false;

                            String[] partes = inputLine.replace("[PEDIDO]", "").split(";");

                            for (int i = 0; i < tPVClientes.getjTable1().getModel().getRowCount(); i++) {
                                String valorColumna = (String) ((DefaultTableModel) tPVClientes.getjTable1().getModel()).getValueAt(i, 0);
                                System.out.println("S-->" + valorColumna);
                                System.out.println("S-->" + partes[0]);
                                esta = esta || valorColumna.equals(partes[0]);
                            }
                            if (!esta) {
                                ((DefaultTableModel) tPVClientes.getjTable1().getModel()).addRow(partes);
                            }
                        } else if (inputLine.startsWith("[REINICIAR]")) {
                            for (int i = 0; i < tPVClientes.getjTable1().getModel().getRowCount(); i++) {
                                ((DefaultTableModel) tPVClientes.getjTable1().getModel()).removeRow(i);
                            }

                        } else if (inputLine.startsWith("[CERRAR]")) {
                            ctpv.setClientesAbiertos(ctpv.getClientesAbiertos()-1);
                        } else if (inputLine.startsWith("[ABRIR]")) {
//                            if (ctpv.getClientesAbiertos()+1 <6){
//                                ctpv.setClientesAbiertos(ctpv.getClientesAbiertos()+1);
//                                ctpv.setClientesTotales(ctpv.getClientesTotales()+1);
//                            }else{
//                                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                                out.println(" [KO]");
//                                System.out.println("[KO]");
//                            }
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
