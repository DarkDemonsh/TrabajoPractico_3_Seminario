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
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class Mostrar_Fichas extends javax.swing.JFrame {
    
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S();
    Estadistica_S es = new Estadistica_S();
    Connection conn = Conector_JBDC.conectar();
    
    public Mostrar_Fichas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        fecha1 = new javax.swing.JTextField();
        fecha2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        list2 = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        fecha1.setText("aaaa-mm-dd");

        fecha2.setText("aaaa-mm-dd");

        jLabel1.setText("Desde");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel2.setText("NOTA: Esto buscara todas las fichas entre las dos fechas");

        list2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Hasta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 430, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Salir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fecha2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fecha1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(Cargar)
                        .addGap(31, 31, 31)
                        .addComponent(Salir)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
    try {
        String f1 = fecha1.getText();
        String f2 = fecha2.getText();
        
        String sql = "SELECT * FROM ficha WHERE Fecha_Consulta BETWEEN '"+f1+" 00:00:00' AND '"+f2+" 23:59:59'";
        
        llamar(sql);
        
    } catch (Exception ex) {
        System.out.println("Error 003: " + ex.getMessage());
    }
    }//GEN-LAST:event_CargarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void list2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list2ActionPerformed

public void llamar(String i){
    try{
        String sql = "";
        sql = i;

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
            
            String s = "ID: "+id+", Profesional a cargo: "+pro+", Paciente: "+per+", DNI: "+dni+", Cobertura: "+cob+", Diagnostico: "+diag+", Estado de Consulta: "+cons+", Motivo de Consulta: "+mcons+", Observaciones: "+obs+", Estado: "+est+", Fecha de la Consulta: "+date;

            list2.add(s);
            list2.add("");
            
            System.out.println("");
        }
        
        rs.close();
        ps.close();

    } catch (Exception ex) {
        System.out.println("Error 004: " + ex.getMessage());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField fecha1;
    private javax.swing.JTextField fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.List list2;
    // End of variables declaration//GEN-END:variables
}

