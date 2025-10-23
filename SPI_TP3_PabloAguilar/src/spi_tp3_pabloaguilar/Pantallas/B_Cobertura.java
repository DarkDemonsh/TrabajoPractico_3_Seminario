package spi_tp3_pabloaguilar.Pantallas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class B_Cobertura extends javax.swing.JFrame {

    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S(); 
    Connection conn = Conector_JBDC.conectar();
    
    public B_Cobertura() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        cober = new javax.swing.JCheckBox();
        buscar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cober.setText("Tiene Cobertura?");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cober, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(cober)
                        .addGap(47, 47, 47)
                        .addComponent(buscar)
                        .addGap(54, 54, 54)
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
    boolean co;
    
      if(cober.hasFocus()){
         co = (true);   
      }else{
         co = (false);   
        }    
        
    try {
        
    String sql = "SELECT * FROM ficha WHERE cobertura = "+co;
        
        try{

        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery();
        
        System.out.println("Lista de Fichas");
        List<String> show = new ArrayList();
        System.out.println("");
        
        while(rs.next()){
            int id = rs.getInt("Ficha_ID");
            String pro = rs.getString("Profesional");
            String per = rs.getString("Nombre_Paciente");
            long dni = rs.getLong("DNI_Paciente");
            boolean cob = rs.getBoolean("Cobertura");
            String diag = rs.getString("Diagnostico");
            String mcons = rs.getString("Motivo_Consulta");
            boolean cons = rs.getBoolean("Consulta");
            String obs = rs.getString("Observacion");
            boolean est = rs.getBoolean("Estado");
            LocalDateTime date = rs.getTimestamp("Fecha_Consulta").toLocalDateTime();
            
            list1.add("ID: "+id+", Profesional a cargo: "+pro+", Paciente: "+per+", DNI: "+dni+", Cobertura: "+cob+", Diagnostico: "+diag+", Estado de Consulta: "+cons+", Motivo de Consulta: "+mcons+", Observaciones: "+obs+", Estado: "+est+", Fecha de la Consulta: "+date);
            list1.add("");
        }

        rs.close();
        ps.close();

    } catch (Exception ex) {
        System.out.println("Error 004: " + ex.getMessage());
    }

    }catch (Exception ex) {
        System.out.println("Error 006: " + ex.getMessage());
    }
    }//GEN-LAST:event_buscarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JCheckBox cober;
    private java.awt.List list1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
