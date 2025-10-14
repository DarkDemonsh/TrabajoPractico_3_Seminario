package spi_tp3_pabloaguilar.Servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Entidades.Profesional;

public class Estadistica_S {
   
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    
    Ficha_S fs = new Ficha_S();
    
    Connection conn = Conector_JBDC.conectar();
    
    String ld0 = null, ld00 = null;
    Scanner leer = new Scanner(System.in);
    int cant = 0, no = 0, si = 0,afid = 1, lol = 0, n1 = 0, n2 = 0,m = 0;
    
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
        
       Buscar_Estadistica(afid);
       while(Buscar_Estadistica(afid)){
            afid ++;
            Buscar_Estadistica(afid);
       }
       e.setEstadistica_ID(afid);
    
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
    
        String sql2 = "SELECT COUNT(*) AS SI FROM ficha WHERE cobertura = '1' AND Profesional = '"+pro+"' AND DATE(Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"'";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();
    
        String sql3 = "SELECT COUNT(*) AS NO FROM ficha WHERE cobertura = '0' AND Profesional = '"+pro+"' AND DATE(Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"'";
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
        e.setResultado(show);
        }
    
        String sql5 = "SELECT SUM(Cupos_Disponibles) AS Cupo FROM profesional";
        
        
        PreparedStatement ps5 = conn.prepareStatement(sql5);
        ResultSet rs5 = ps5.executeQuery();
        
        if(rs5.next()){    
            lol = rs5.getInt("Cupo");
        };
        
        String sql7 = "SELECT COUNT(*) AS NON FROM ficha WHERE cobertura = '0' AND DATE(Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"'";
        String sql8 = "SELECT COUNT(*) AS SIS FROM ficha WHERE cobertura = '1' AND DATE(Fecha_Consulta) BETWEEN '"+Menor+"' AND '"+Mayor+"'";
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
            
        try(FileWriter file = new FileWriter(e.getDia()+"_"+e.getEstadistica_ID()+"_Estadistica.json")){
               file.write(j.toString());
        }catch(IOException ex){
            System.out.println("Error en CrearSave"+ex.getMessage());
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
        System.out.println("Error 015: " + ex.getMessage());
    } }

    public boolean Buscar_Estadistica(int Estadistica_ID) {
    try {
        String sql = "SELECT Estadistica_ID FROM estadistica WHERE Estadistica_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Estadistica_ID);

        ResultSet rs = ps.executeQuery();

        boolean existe = rs.next();

        rs.close();
        ps.close();

        return existe;

    } catch (Exception ex) {
        System.out.println("Error 016: " + ex.getMessage());
        return false;
    }
    }}
    
