package spi_tp3_pabloaguilar.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    int falseid = 1;
    int afid = 1;
    boolean exit = true;
    LocalDateTime hoy = LocalDateTime.now();

public void Agregar_Ficha(Fichas f, Estadistica e, Controlador_DB c){

    Scanner leer = new Scanner(System.in);
 try{   
     
    do{
       System.out.println(afid+" / "+falseid);
       BuscarFicha(afid);
       if(afid == falseid){
           afid += 1;
            System.out.println(afid+" / "+falseid);
       }else{
           f.setFicha_ID(afid);
           exit = false;
       }

    }while(exit = false);
 
     
    System.out.println("Escribir el nombre del Profesional");
    f.setProfesional(leer.next());
    
    System.out.println("Escribir el nombre del Paciente");
    f.setPaciente(leer.next());
    
    System.out.println("Inserte DNI del paciente");
    f.setDNI_Paciente(leer.nextLong());
    
    System.out.println("Inesrte la localidad del paciente");
    f.setLocalidad(leer.next());
    
    System.out.println("¿Contiene cobertura? Si/No");
    respuesta = leer.next();
    if(respuesta.equalsIgnoreCase("si")){
        f.setCobertura(true);
    }else if(respuesta.equalsIgnoreCase("no")){
        f.setCobertura(false);
    }
    
    System.out.println("Diagnostico");
    f.setDiagnostico(leer.next());
    
    System.out.println("Motivo de la consulta");
    f.setMotivo_Consulta(leer.next());
     
    System.out.println("¿El paciente esta en consulta? Si/No"); 
        respuesta = leer.next();
    if(respuesta.equalsIgnoreCase("si")){
        f.setConsulta(true);
    }else if(respuesta.equalsIgnoreCase("no")){
        f.setConsulta(false);
    }
    
    System.out.println("Observaciones?");
    f.setObservacion(leer.next());
     
     System.out.println("Estado del Paciente");
     f.setEstado(leer.next());
    
     f.setDate(hoy);
     System.out.println(afid);
     
 }catch(Exception ex){
     System.out.println("Error 001");
 } 
 
try{
        
        String sql = ("INSERT INTO Ficha (Ficha_ID, DNI_Paciente, Localidad, Cobertura, Diagnostico, Motivo_Consulta, Nombre_Paciente, Profesional, Consulta, Observacion, Estado, Fecha_Consulta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
        ps.setString(11, f.getEstado());
        ps.setTimestamp(12, Timestamp.valueOf(f.getDate()));
        
        ps.executeUpdate();
        ps.close();
        
}catch(Exception ex){
    System.out.println("Error 002 " + ex.getMessage());
}
 
}

public void BuscarFicha(int Ficha_ID){
    
    if(conn != null){
        try{
            
            String sql = "SELECT * FROM ficha WHERE Ficha_ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, afid);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            falseid = rs.getInt("Ficha_ID");
            }
            
            rs.close();
            ps.close();
            
        }catch (Exception ex){
            System.out.println("Error 003 " + ex.getMessage());
        }
    }    
}
}