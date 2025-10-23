package spi_tp3_pabloaguilar.Pantallas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class Borrar_Fichas extends javax.swing.JFrame {
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S();
    Estadistica_S es = new Estadistica_S();
    Connection conn = Conector_JBDC.conectar();
    
    public Borrar_Fichas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID = new javax.swing.JTextField();
        Borrar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresar ID de la Ficha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Borrar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(ID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(Borrar)
                .addGap(42, 42, 42)
                .addComponent(Salir)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        try {
            
        String ID_Ficha = ID.getText();
            
        String sql = "DELETE FROM ficha WHERE Ficha_ID = "+ID_Ficha;
        PreparedStatement ps = conn.prepareStatement(sql);
        
        String sql2 = "UPDATE profesional SET cupos_disponibles = cupos_disponibles + 1 WHERE nombre_profesional IN (SELECT nombre_profesional FROM ficha WHERE Ficha_ID = "+ID_Ficha+")";
        PreparedStatement ps2 = conn.prepareStatement(sql2);

        ps2.executeUpdate();
        
        int i = ps.executeUpdate();
        
        if(i>0){
            System.out.println("Ficha Borrada");
        }else{
            System.out.println("Ficha no encontrada");
        }
        
    } catch (Exception ex) {
        System.out.println("Error 004: " + ex.getMessage());
    }
    }//GEN-LAST:event_BorrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JTextField ID;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
