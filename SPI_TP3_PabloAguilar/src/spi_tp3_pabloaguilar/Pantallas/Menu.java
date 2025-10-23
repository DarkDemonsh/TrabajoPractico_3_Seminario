package spi_tp3_pabloaguilar.Pantallas;

import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }
    
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S();
    Estadistica_S es = new Estadistica_S();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Crear_Ficha2 = new javax.swing.JButton();
        Cargar_Ficha = new javax.swing.JButton();
        Borrar_Ficha = new javax.swing.JButton();
        Cargar_Estadistica = new javax.swing.JButton();
        Buscar_Cobertura = new javax.swing.JButton();
        Cupos_Profesional = new javax.swing.JButton();
        CG_Estadistica = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Crear_Ficha2.setText("Crear Ficha");
        Crear_Ficha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_Ficha2ActionPerformed(evt);
            }
        });

        Cargar_Ficha.setText("Mostrar Ficha");
        Cargar_Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_FichaActionPerformed(evt);
            }
        });

        Borrar_Ficha.setText("Borrar Ficha");
        Borrar_Ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar_FichaActionPerformed(evt);
            }
        });

        Cargar_Estadistica.setText("Cargar Estadistica");
        Cargar_Estadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_EstadisticaActionPerformed(evt);
            }
        });

        Buscar_Cobertura.setText("Buscar por Cobertura");
        Buscar_Cobertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_CoberturaActionPerformed(evt);
            }
        });

        Cupos_Profesional.setText("Consultar Cupos de Profesional");
        Cupos_Profesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cupos_ProfesionalActionPerformed(evt);
            }
        });

        CG_Estadistica.setText("Crear y Guardar Estadistica");
        CG_Estadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CG_EstadisticaActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Crear_Ficha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Borrar_Ficha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cargar_Ficha, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cargar_Estadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CG_Estadistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(Buscar_Cobertura, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(Cupos_Profesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Crear_Ficha2)
                        .addGap(40, 40, 40)
                        .addComponent(Cargar_Ficha)
                        .addGap(37, 37, 37)
                        .addComponent(Borrar_Ficha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(CG_Estadistica)
                .addGap(18, 18, 18)
                .addComponent(Cargar_Estadistica)
                .addGap(26, 26, 26)
                .addComponent(Buscar_Cobertura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cupos_Profesional)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cupos_ProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cupos_ProfesionalActionPerformed
        Cupos_Profesionales pc = new Cupos_Profesionales();
        
        pc.setVisible(true);
        pc.setLocationRelativeTo(null);  
    }//GEN-LAST:event_Cupos_ProfesionalActionPerformed

    private void Cargar_EstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_EstadisticaActionPerformed
        C_Estad ce = new C_Estad();
        
        ce.setVisible(true);
        ce.setLocationRelativeTo(null);
    }//GEN-LAST:event_Cargar_EstadisticaActionPerformed

    private void Crear_Ficha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Crear_Ficha2ActionPerformed
        Crear_Ficha cf = new Crear_Ficha();

        cf.setVisible(true); 
        cf.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_Crear_Ficha2ActionPerformed

    private void Cargar_FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_FichaActionPerformed
        Mostrar_Fichas mf = new Mostrar_Fichas();
        
        mf.setVisible(true);
        mf.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_Cargar_FichaActionPerformed

    private void Borrar_FichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_FichaActionPerformed
        Borrar_Fichas bf = new Borrar_Fichas();
        
        bf.setVisible(true);
        bf.setLocationRelativeTo(null);
    }//GEN-LAST:event_Borrar_FichaActionPerformed

    private void CG_EstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CG_EstadisticaActionPerformed
        Crear_Estadistica cge = new Crear_Estadistica();
        
        cge.setVisible(true);
        cge.setLocationRelativeTo(null);
    }//GEN-LAST:event_CG_EstadisticaActionPerformed

    private void Buscar_CoberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_CoberturaActionPerformed
       B_Cobertura bc = new B_Cobertura();
        
        bc.setVisible(true);
        bc.setLocationRelativeTo(null);
    }//GEN-LAST:event_Buscar_CoberturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar_Ficha;
    private javax.swing.JButton Buscar_Cobertura;
    private javax.swing.JButton CG_Estadistica;
    private javax.swing.JButton Cargar_Estadistica;
    private javax.swing.JButton Cargar_Ficha;
    private javax.swing.JButton Crear_Ficha2;
    private javax.swing.JButton Cupos_Profesional;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
