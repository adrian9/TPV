/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Filas
 */

//Esta será la ventana de TPV que se abrirá en el CTPV
public class TPVClientes extends javax.swing.JInternalFrame {
    
    private HiloVentana hiloV;
    

    /**
     * Creates new form TPVClientes
     */
    public TPVClientes() {
        initComponents();   
        crearComponentes();
    }

    public void setHiloV(HiloVentana hiloV) {
        this.hiloV = hiloV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(172, 112));
        setMinimumSize(new java.awt.Dimension(172, 112));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    //Función que mostrará una ventana indicando que se ha cerrado el TPV cliente
    public void showMessage(){
        JOptionPane.showMessageDialog(null, "Cliente atendido", "TPV Cerrado", JOptionPane.INFORMATION_MESSAGE);
    }
    public void crearComponentes(){
        jPanelTabla = new javax.swing.JPanel();
        jPanelTotal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelPrecio.setMaximumSize(new java.awt.Dimension(500, 112));
        jLabelPrecio.setMinimumSize(new java.awt.Dimension(500, 112));
        jLabelPrecio.setPreferredSize(new java.awt.Dimension(500, 112));
        jLabelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        // create a line border with the specified color and width
	        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
	        jLabelPrecio.setBorder(border);
        
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(172, 112));
        setMinimumSize(new java.awt.Dimension(172, 112));

        jPanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Ticket Compra"));

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Ticket"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total venta:");

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPrecio.setText(" ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("€");

        javax.swing.GroupLayout jPanelTotalLayout = new javax.swing.GroupLayout(jPanelTotal);
        jPanelTotal.setLayout(jPanelTotalLayout);
        jPanelTotalLayout.setHorizontalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addGroup(jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTotalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTotalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTotalLayout.setVerticalGroup(
            jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTotalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }                


    // Variables declaration - do not modify                     
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabelPrecio;
    public javax.swing.JPanel jPanelTabla;
    public javax.swing.JPanel jPanelTotal;
}
