package spi_tp3_pabloaguilar.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Controlador_DB;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;

public class Ficha_S {
    
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Controlador_DB c = new Controlador_DB();
    Connection conn = Conector_JBDC.conectar();
    String respuesta;
    int falseid = 0;
    int afid = 0;
    boolean exit = true;
    LocalDateTime hoy = LocalDateTime.now();

public void Agregar_Ficha(Fichas f, Estadistica e, Controlador_DB c){

    Scanner leer = new Scanner(System.in);
 try{   
     
       Buscar_Ficha(afid);
       while(Buscar_Ficha(afid)){
            afid ++;
            Buscar_Ficha(afid);
       }
       f.setFicha_ID(afid); 
     
    System.out.println("Escribir el nombre del Profesional");
    f.setProfesional(leer.nextLine());
    
    System.out.println("Escribir el nombre del Paciente");
    f.setPaciente(leer.nextLine());
    
    System.out.println("Inserte DNI del paciente");
    f.setDNI_Paciente(leer.nextLong());
    leer.nextLine();
    
    System.out.println("Inesrte la localidad del paciente");
    f.setLocalidad(leer.nextLine());
    
    System.out.println("¿Contiene cobertura? Si/No");
    respuesta = leer.next();
    if(respuesta.equalsIgnoreCase("si")){
        f.setCobertura(true);
        leer.nextLine();
    }else if(respuesta.equalsIgnoreCase("no")){
        f.setCobertura(false);
    }
    
    System.out.println("Diagnostico");
    f.setDiagnostico(leer.nextLine());
    
    System.out.println("Motivo de la consulta");
    f.setMotivo_Consulta(leer.nextLine());
     
    System.out.println("¿El paciente esta en consulta? Si/No"); 
        respuesta = leer.next();
    if(respuesta.equalsIgnoreCase("si")){
        f.setConsulta(true);
        leer.nextLine();
    }else if(respuesta.equalsIgnoreCase("no")){
        f.setConsulta(false);
    }
    
    System.out.println("Observaciones?");
    f.setObservacion(leer.nextLine());
     
     System.out.println("Estado del Paciente");
     f.setEstado(leer.nextInt());
    
     f.setDate(hoy);
     System.out.println(afid);
     
 }catch(Exception ex){
     System.out.println("Error 001");
 } 
 
try{
        
        String sql = ("INSERT INTO ficha (Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, f.getFicha_ID());
        ps.setLong(2, f.getDNI_Paciente());
        ps.setString(3, f.getLocalidad());
        ps.setBoolean(4, f.isCobertura());
        ps.setString(5, f.getDiagnostico());
        ps.setString(6, f.getMotivo_Consulta());
        ps.setString(7, f.getPaciente());
        ps.setString(8, f.getProfesional());
        ps.setBoolean(9, f.isConsulta());
        ps.setString(10, f.getObservacion());
        ps.setInt(11, f.getEstado());
        ps.setTimestamp(12, Timestamp.valueOf(f.getDate()));
        
        ps.executeUpdate();
        ps.close();
        
}catch(Exception ex){
    System.out.println("Error 002 " + ex.getMessage());
}
 
}

public boolean Buscar_Ficha(int Ficha_ID) {
    try {
        String sql = "SELECT Ficha_ID FROM ficha WHERE Ficha_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Ficha_ID);

        ResultSet rs = ps.executeQuery();

        boolean existe = rs.next();

        rs.close();
        ps.close();

        return existe;

    } catch (Exception ex) {
        System.out.println("Error 003: " + ex.getMessage());
        return false;
    }
}

public void Borrar_Ficha(int Ficha_ID) {
    try {
        String sql = "DELETE FROM ficha WHERE Ficha_ID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Ficha_ID);

        int i = ps.executeUpdate();
        
        if(i>0){
            System.out.println("Ficha Borrada");
        }else{
            System.out.println("Ficha no encontrada");
        }
        
    } catch (Exception ex) {
        System.out.println("Error 004: " + ex.getMessage());
    }
}
public void Listar_Ficha(int Menor, int Mayor) {
    try {
        String sql = "SELECT * FROM ficha WHERE Ficha_ID BETWEEN ? AND ?";
        PreparedStatement ps = conn.prepareStatement(sql);  
        ps.setInt(1, Menor);
        ps.setInt(2, Mayor);
        
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
            
            show.add("ID: "+id+", Profesional a cargo: "+pro+", Paciente: "+per+", DNI: "+dni+", Cobertura: "+cob+", Diagnostico: "+diag+", Estado de Consulta: "+cons+", Motivo de Consulta: "+mcons+", Observaciones: "+obs+", Estado: "+est+", Fecha de la Consulta: "+date);
        }
        
        for (String s : show) {
            System.out.println(s);
            System.out.println("");
        }
        
        rs.close();
        ps.close();

    } catch (Exception ex) {
        System.out.println("Error 003: " + ex.getMessage());
    }
}
}
