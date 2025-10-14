package spi_tp3_pabloaguilar.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;

public class Estadistica_S {
   
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    
    Ficha_S fs = new Ficha_S();
    
    Connection conn = Conector_JBDC.conectar();
    
    String ld0 = null, ld00 = null;
    Scanner leer = new Scanner(System.in);
    int cant = 0, no = 0, si = 0;
    
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

    public void Resultado_Estadistica(){
     try {
        
    String sql = "SELECT * FROM profesional";
        
    PreparedStatement ps = conn.prepareStatement(sql); 
    ResultSet rs = ps.executeQuery();
        
        System.out.println("Lista de Fichas");
        List<String> show = new ArrayList();
        System.out.println("");

         System.out.println("Indicar año-mes-dia de las fichas a contar");
         
          ld0 = leer.nextLine();
          LocalDate Menor = LocalDate.parse(ld0);
          ld00 = leer.nextLine();
          LocalDate Mayor = LocalDate.parse(ld00);
    
    while (rs.next()){
        String pro = rs.getString("Nombre_Profesional");

        String sql1 = "SELECT COUNT(*) AS Total FROM ficha WHERE DATE(Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"' AND Profesional = '"+pro+"'";

        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ResultSet rs1 = ps1.executeQuery();
    
        String sql2 = "SELECT COUNT(*) AS SI FROM ficha WHERE cobertura = '1' AND Profesional = '"+pro+"'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();
    
        String sql3 = "SELECT COUNT(*) AS NO FROM ficha WHERE cobertura = '0' AND Profesional = '"+pro+"'";
        PreparedStatement ps3 = conn.prepareStatement(sql3);
        ResultSet rs3 = ps3.executeQuery();
    
        System.out.println("");
        
            String per = rs.getString("Cupos_Disponibles");
            
        if(rs1.next()){    
            cant = rs1.getInt("Total");
        };
        if(rs2.next()){ 
            si = rs2.getInt("SI");
        };
        if(rs3.next()){ 
            no = rs3.getInt("NO");
        };
        
        show.add("Profesional:  "+pro+", Cupos Disponibles: "+per+", Total de Paceintes Atendidos: "+cant+", Pacientes con cobertura: "+si+", Paceintes sin cobertura: "+no);
        }
        
        for (String s : show) {
            System.out.println(s);
            System.out.println("");
        }
        
        rs.close();
        ps.close();


    }catch (Exception ex) {
        System.out.println("Error 015: " + ex.getMessage());
    }        
        
        
        
    }

}

