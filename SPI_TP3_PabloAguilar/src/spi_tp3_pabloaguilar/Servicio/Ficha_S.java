package spi_tp3_pabloaguilar.Servicio;

import java.io.FileWriter;
import java.io.IOException;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;
import spi_tp3_pabloaguilar.Conector_JBDC;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;

public class Ficha_S {
    
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    
    Connection conn = Conector_JBDC.conectar();
    
    String respuesta;
    int falseid = 1;
    int afid = 1;
    boolean exit = true;
    LocalDateTime hoy = LocalDateTime.now();

public void Agregar_Ficha(Fichas f, Estadistica e, Profesional p){

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
    
    if(Prof_name(f.getProfesional()) == false){
    if(Prof_cupo(f.getProfesional())== true){
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
        Update_Prof(f.getProfesional());
    }
    
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
        Guardado_Local(f);
        
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
        
        String sql2 = "UPDATE profesional SET cupos_disponibles = cupos_disponibles + 1 WHERE nombre_profesional IN (SELECT nombre_profesional FROM ficha WHERE Ficha_ID = ?)";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setInt(1, Ficha_ID);

        ps2.executeUpdate();
        
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
        
        String sql = "SELECT * FROM ficha WHERE Ficha_ID BETWEEN "+Menor+" AND "+Mayor;
        
        llamar(sql);

    } catch (Exception ex) {
        System.out.println("Error 003: " + ex.getMessage());
    }
}

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
            
            show.add("ID: "+id+", Profesional a cargo: "+pro+", Paciente: "+per+", DNI: "+dni+", Cobertura: "+cob+", Diagnostico: "+diag+", Estado de Consulta: "+cons+", Motivo de Consulta: "+mcons+", Observaciones: "+obs+", Estado: "+est+", Fecha de la Consulta: "+date);
        }
        
        for (String s : show) {
            System.out.println(s);
            System.out.println("");
        }
        
        rs.close();
        ps.close();

    } catch (Exception ex) {
        System.out.println("Error 004: " + ex.getMessage());
    }
}

public boolean Buscar_Prof(String n) {
    try {
        String sql = n;
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        boolean existe = rs.next();

        rs.close();
        ps.close();

        return existe;

    } catch (Exception ex) {
        System.out.println("Error 010: " + ex.getMessage());
        return false;
    }
}

public void Update_Prof(String n) {
    try {
        String sql = "UPDATE profesional SET cupos_disponibles = cupos_disponibles - 1 WHERE nombre_profesional = '"+n+"'";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.executeUpdate();

        ps.close();

    } catch (Exception ex) {
        System.out.println("Error 011: " + ex.getMessage());
    }
}

public boolean Prof_name(String n){
    try{
    String sql = "SELECT nombre_profesional FROM profesional WHERE nombre_profesional = '"+n+"'";
    
    if(Buscar_Prof(sql) == true){
        return true;
    }else{
        return false;
    }
    
    }catch(Exception ex){
        System.out.println("Error 012: "+ex.getMessage());
        return false;
    }       
}

public boolean Prof_cupo(String n) {
    try {
        String sql = "SELECT cupos_disponibles FROM profesional WHERE nombre_profesional = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, n);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            int i = rs.getInt("cupos_disponibles");
            rs.close();
            ps.close();

            return i > 0;
        } else {
            rs.close();
            ps.close();
            return true;
        }

    } catch (Exception ex) {
        System.out.println("Error 013: " + ex.getMessage());
        return false;
    }
}

public void Guardado_Local(Fichas f){
            JSONObject j = new JSONObject();
            
            j.put("Ficha_Id", f.getFicha_ID());
            j.put("Profesional",f.getProfesional());
            j.put("Nombre_Paciente",f.getPaciente());
            j.put("DNI_Paciente",f.getDNI_Paciente());
            j.put("Localidad_Paciente",f.getLocalidad());
            j.put("Diagnostico",f.getDiagnostico());
            j.put("Motivo_Consulta",f.getMotivo_Consulta());
            j.put("Estado",f.getEstado());
            j.put("Observaciones",f.getObservacion());
            j.put("Tiene_Cobertura",f.isCobertura());
            j.put("Sigue_con_Consulta",f.isConsulta());
            j.put("Fecha_De_Consulta",f.getDate());
            
        try(FileWriter file = new FileWriter(e.getDia()+"_"+f.getFicha_ID()+"_Ficha.json")){
               file.write(j.toString());
        }catch(IOException ex){
            System.out.println("Error en al guardar el JSON");
        }
    }

}
