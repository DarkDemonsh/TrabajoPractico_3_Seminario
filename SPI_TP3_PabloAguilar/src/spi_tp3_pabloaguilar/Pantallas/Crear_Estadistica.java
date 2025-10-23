package spi_tp3_pabloaguilar.Pantallas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class Crear_Estadistica extends javax.swing.JFrame {

    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Ficha_S fs = new Ficha_S(); 
    Estadistica_S es = new Estadistica_S();
    Connection conn = Conector_JBDC.conectar();
    
    int cant = 0, no = 0, si = 0,afid = 1, lol = 0, n1 = 0, n2 = 0,m = 0;
    
    public Crear_Estadistica() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha1 = new javax.swing.JTextField();
        fecha2 = new javax.swing.JTextField();
        Crear_Guardar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        list1 = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fecha1.setText("aaaa-mm-dd");

        fecha2.setText("aaaa-mm-dd");

        Crear_Guardar.setText("Crear y Guardar");
        Crear_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_GuardarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Crear_Guardar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(fecha1))
                            .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Crear_Guardar)
                .addGap(18, 18, 18)
                .addComponent(Salir)
                .addGap(24, 24, 24)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Crear_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Crear_GuardarActionPerformed
         try {
        
       es.Buscar_Estadistica(afid);
       while(es.Buscar_Estadistica(afid)){
            afid ++;
            es.Buscar_Estadistica(afid);
       }
       e.setEstadistica_ID(afid);
    
    String sql = "SELECT * FROM profesional";
        
    PreparedStatement ps = conn.prepareStatement(sql); 
    ResultSet rs = ps.executeQuery();
        
        System.out.println("Lista de Fichas");
        List<String> show = new ArrayList();
        System.out.println("");

         
        String f1 = fecha1.getText();
        String f2 = fecha2.getText();
    
    while (rs.next()){
        String pro = rs.getString("Nombre_Profesional");

        String sql1 = "SELECT COUNT(*) AS Total FROM ficha WHERE DATE(Fecha_Consulta) BETWEEN '"+f1+"' AND '"+f2+"' AND Profesional = '"+pro+"'";

        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ResultSet rs1 = ps1.executeQuery();
    
        String sql2 = "SELECT COUNT(*) AS SI FROM ficha WHERE cobertura = '1' AND Profesional = '"+pro+"' AND DATE(Fecha_Consulta) BETWEEN '"+f1+"' AND '"+f2+"'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();
    
        String sql3 = "SELECT COUNT(*) AS NO FROM ficha WHERE cobertura = '0' AND Profesional = '"+pro+"' AND DATE(Fecha_Consulta) BETWEEN '"+f1+"' AND '"+f2+"'";
        PreparedStatement ps3 = conn.prepareStatement(sql3);
        ResultSet rs3 = ps3.executeQuery();
    
        System.out.println("");
        
        String per = rs.getString("Cupos_Disponibles");
            
        if(rs1.next()){    
            cant = rs1.getInt("Total");
            m += cant;
        };
        if(rs2.next()){ 
            si = rs2.getInt("SI");
        };
        if(rs3.next()){ 
            no = rs3.getInt("NO");
        };
        
 
        show.add("ID_Estadistica: "+e.getEstadistica_ID()+", Profesional:  "+pro+", Cupos Disponibles: "+per+", Total de Paceintes Atendidos: "+cant+", Pacientes con cobertura: "+si+", Paceintes sin cobertura: "+no+", Fecha de la Estadistica: "+e.getDia());
        
        }
    
        String sql5 = "SELECT SUM(Cupos_Disponibles) AS Cupo FROM profesional";
        
        
        PreparedStatement ps5 = conn.prepareStatement(sql5);
        ResultSet rs5 = ps5.executeQuery();
        
        if(rs5.next()){    
            lol = rs5.getInt("Cupo");
        };
        
        String sql7 = "SELECT COUNT(*) AS NON FROM ficha WHERE cobertura = '0' AND DATE(Fecha_Consulta) BETWEEN '"+f1+"' AND '"+f2+"'";
        String sql8 = "SELECT COUNT(*) AS SIS FROM ficha WHERE cobertura = '1' AND DATE(Fecha_Consulta) BETWEEN '"+f1+"' AND '"+f2+"'";
        PreparedStatement ps7 = conn.prepareStatement(sql7);
        ResultSet rs7 = ps7.executeQuery();
        PreparedStatement ps8 = conn.prepareStatement(sql8);
        ResultSet rs8 = ps8.executeQuery();
        
        if(rs7.next()){    
            n1 = rs7.getInt("NON");
        };
        if(rs8.next()){    
            n2 = rs8.getInt("SIS");
        };
        
        String sql4 = ("INSERT INTO estadistica (Estadistica_ID, Pacientes_Atendidos, Pacientes_Con_Cobertura, Pacientes_Sin_Cobertura, Cupos_Disponibles ,Fecha_Estadistica) VALUES (?,?,?,?,?,?)");
        PreparedStatement ps4 = conn.prepareStatement(sql4);
    
        ps4.setInt(1, e.getEstadistica_ID());
        ps4.setInt(2, m);             
        ps4.setInt(3, n2);
        ps4.setInt(4, n1); 
        ps4.setInt(5, lol);  
        ps4.setDate(6, Date.valueOf(e.getDia()));
        
        JSONObject j = new JSONObject();
            
        j.put("Id_Estadistica: ", e.getEstadistica_ID());
        j.put("Total_de_Pacientes",m);
        j.put("Pacientes_Con_Cobertura",n2);
        j.put("Pacientes_Sin_Cobertura",n1);
        j.put("Cupos_Disponibles",lol);
        j.put("Fecha_Estadistica",Date.valueOf(e.getDia()));
        
        String carpeta = "Estadistica";
        File directorio = new File(carpeta);
        
        if (!directorio.exists()) {
            if (directorio.mkdirs()){
                directorio.getAbsolutePath();
            } else {
                return;
            }
        }
        
        try(FileWriter file = new FileWriter(carpeta+File.separator+e.getDia()+"_"+e.getEstadistica_ID()+"_Estadistica.json")){
               file.write(j.toString());
        }catch(IOException ex){
            list1.add("ERROR 009: "+ex.getMessage());
        }
        
        ps4.executeUpdate();
        ps4.close();
        
        for (String s : show) {
            System.out.println(s);
            System.out.println("");            
        }
        
        rs.close();
        ps.close();
               
    }catch (Exception ex) {
        list1.add("ERROR 010: "+ex.getMessage());
    } 
    }//GEN-LAST:event_Crear_GuardarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear_Guardar;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField fecha1;
    private javax.swing.JTextField fecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
