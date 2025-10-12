package spi_tp3_pabloaguilar.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;

public class Estadistica_S {
   
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    
    Ficha_S fs = new Ficha_S();
    
    Connection conn = Conector_JBDC.conectar();
    
    public void Pacientes_X_Dia(LocalDate Menor, LocalDate Mayor){
        
        try {
  
        String sql = "SELECT * FROM ficha WHERE DATE (Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"'";
        
        fs.llamar(sql);

    } catch (Exception ex) {
        System.out.println("Error 005: " + ex.getMessage());
    }
    }
    
    public void Cobertura_Paciente(boolean cober){
        
    try {
        
    String sql = "SELECT * FROM ficha WHERE cobertura = "+cober;
        
    fs.llamar(sql);

    }catch (Exception ex) {
        System.out.println("Error 006: " + ex.getMessage());
    }
    } 
    
    public void Cupos_Disponibles (String n){
     try {
        
    String sql = "SELECT * FROM profesional WHERE nombre_profesional = '"+n+"'";
        
    PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery();
        
        System.out.println("Lista de Fichas");
        List<String> show = new ArrayList();
        System.out.println("");
        
        while(rs.next()){

            String pro = rs.getString("Nombre_Profesional");
            String per = rs.getString("Cupos_Disponibles");
 
            
            show.add("Profesional:  "+pro+", Cupos Disponibles: "+per);
        }
        
        for (String s : show) {
            System.out.println(s);
            System.out.println("");
        }
        
        rs.close();
        ps.close();


    }catch (Exception ex) {
        System.out.println("Error 007: " + ex.getMessage());
    }
    }           
}

