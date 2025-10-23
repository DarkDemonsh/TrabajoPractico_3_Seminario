package spi_tp3_pabloaguilar.Pantallas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class Crear_Ficha extends javax.swing.JFrame {
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S();
    Estadistica_S es = new Estadistica_S();
    Connection conn = Conector_JBDC.conectar();
    
    String prof, n_pac, dni1;
  
    public Crear_Ficha() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        N_Profesional = new javax.swing.JTextField();
        N_Paciente = new javax.swing.JTextField();
        DNI_Paciente = new javax.swing.JTextField();
        Localidad = new javax.swing.JTextField();
        M_Consulta = new javax.swing.JTextField();
        Diagnostico = new javax.swing.JTextField();
        Observacion = new javax.swing.JTextField();
        cobertura = new javax.swing.JCheckBox();
        consulta = new javax.swing.JCheckBox();
        estado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        list1 = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        N_Profesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_ProfesionalActionPerformed(evt);
            }
        });

        N_Paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_PacienteActionPerformed(evt);
            }
        });

        DNI_Paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNI_PacienteActionPerformed(evt);
            }
        });

        Localidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalidadActionPerformed(evt);
            }
        });

        M_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_ConsultaActionPerformed(evt);
            }
        });

        Diagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagnosticoActionPerformed(evt);
            }
        });

        Observacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObservacionActionPerformed(evt);
            }
        });

        cobertura.setText("Tiene Cobertura?");
        cobertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coberturaActionPerformed(evt);
            }
        });

        consulta.setText("Esta en consulta?");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        estado.setText("Esta Internado?");
        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Profesional");

        jLabel2.setText("Nombre del Paciente");

        jLabel3.setText("DNI del Paciente");

        jLabel4.setText("Localidad");

        jLabel5.setText("Motivo de la consulta");

        jLabel6.setText("Diagnostico");

        jLabel7.setText("Observacion");

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Localidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(DNI_Paciente)
                                .addComponent(N_Paciente)
                                .addComponent(N_Profesional)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(M_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(130, 130, 130))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Observacion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cobertura)
                        .addGap(10, 10, 10)
                        .addComponent(consulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estado)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addGap(18, 18, 18)
                        .addComponent(Salir)
                        .addContainerGap())))
            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(N_Profesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(N_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(DNI_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(M_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Observacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estado)
                                    .addComponent(consulta)
                                    .addComponent(cobertura))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Salir)
                                    .addComponent(Guardar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void N_ProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_ProfesionalActionPerformed

    }//GEN-LAST:event_N_ProfesionalActionPerformed

    private void N_PacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_PacienteActionPerformed

    }//GEN-LAST:event_N_PacienteActionPerformed

    private void DNI_PacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNI_PacienteActionPerformed

    }//GEN-LAST:event_DNI_PacienteActionPerformed

    private void LocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalidadActionPerformed

    }//GEN-LAST:event_LocalidadActionPerformed

    private void M_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_ConsultaActionPerformed

    }//GEN-LAST:event_M_ConsultaActionPerformed

    private void DiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagnosticoActionPerformed

    }//GEN-LAST:event_DiagnosticoActionPerformed

    private void ObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObservacionActionPerformed
   
    }//GEN-LAST:event_ObservacionActionPerformed

    private void coberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coberturaActionPerformed
    try{    
        if(cobertura.hasFocus()){
         f.setCobertura(true);   
        }else{
         f.setCobertura(false);   
        }
    }catch(Exception ex){
        list1.add("ERROR 001: "+ex.getMessage());
    }
    }//GEN-LAST:event_coberturaActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        try{    
        if(consulta.hasFocus()){
         f.setConsulta(true);   
        }else{
         f.setConsulta(false);   
        }
    }catch(Exception ex){
        list1.add("ERROR 002: "+ex.getMessage());
    }
    }//GEN-LAST:event_consultaActionPerformed

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        try{    
        if(estado.hasFocus()){
         f.setEstado(1);   
        }else{
         f.setEstado(0);   
        }
    }catch(Exception ex){
        list1.add("ERROR 003: "+ex.getMessage());
    }
    }//GEN-LAST:event_estadoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
/*Nombre Profesional*/
    try{   
        prof = N_Profesional.getText();
        
        f.setProfesional(prof);
        
    if(fs.Prof_name(f.getProfesional()) == false){
    if(fs.Prof_cupo(f.getProfesional())== true){
    p.setNombre_profesional(f.getProfesional());
    p.setCupos_Disponibles(p.getCupos_Disponibles()-1);
    }else{
        System.out.println("El profesional no tiene cupos disponibles");
    }
    
    String sql2 = ("INSERT INTO profesional (Nombre_Profesional, Cupos_Disponibles) VALUES (?, 6)");
    PreparedStatement ps2 = conn.prepareStatement(sql2);
    ps2.setString(1, p.getNombre_profesional());
        
    ps2.executeUpdate();
    ps2.close();
    
    }else{
        fs.Update_Prof(f.getProfesional());
    }
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*Nombre Paciente*/
    try{  
        
       n_pac = N_Paciente.getText(); 
       f.setPaciente(n_pac);
       
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*DNI*/
    try{   
        dni1 = DNI_Paciente.getText();
        long dni = Long.parseLong(dni1);
        f.setDNI_Paciente(dni);
        
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*Localidad*/
    try{    
        String local = Localidad.getText();
        f.setLocalidad(local);
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*Consulta*/
    try{
        String cons = M_Consulta.getText();
        f.setMotivo_Consulta(cons);
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*Diagnostico*/
    try{    
        String diag = Diagnostico.getText();
        f.setDiagnostico(diag);
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    /*Observacion*/
    try{
        String obs = Observacion.getText();
        f.setObservacion(obs);
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    } 
    /*Guardado*/    
    try{
        if(prof.isEmpty() || dni1.isEmpty() || n_pac.isEmpty()){
        throw new Exception("El valor en: Nombre Profesional, Nombre Paciente y DNI Paciente no deben estar vacios"); 
        }else{
        fs.Agregar_Ficha(f, e, p);
        }
    }catch(Exception ex){
        list1.add("ERROR 004: "+ex.getMessage());
    }
    }//GEN-LAST:event_GuardarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNI_Paciente;
    private javax.swing.JTextField Diagnostico;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField Localidad;
    private javax.swing.JTextField M_Consulta;
    private javax.swing.JTextField N_Paciente;
    private javax.swing.JTextField N_Profesional;
    private javax.swing.JTextField Observacion;
    private javax.swing.JButton Salir;
    private javax.swing.JCheckBox cobertura;
    private javax.swing.JCheckBox consulta;
    private javax.swing.JCheckBox estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
