package spi_tp3_pabloaguilar.Servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import spi_tp3_pabloaguilar.Entidades.Profesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    try{   
        Buscar_Ficha(afid);
       while(Buscar_Ficha(afid)){
            afid ++;
            Buscar_Ficha(afid);
       }
       f.setFicha_ID(afid); 

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
            
        String carpeta = "Fichas";
        File directorio = new File(carpeta);
        
        if (!directorio.exists()) {
            if (directorio.mkdirs()){
                directorio.getAbsolutePath();
            } else {
                return;
            }
        }
            
        try(FileWriter file = new FileWriter(carpeta+File.separator+e.getDia()+"_"+f.getFicha_ID()+"_Ficha.json")){
               file.write(j.toString());
        }catch(IOException ex){
            System.out.println("Error en al guardar el JSON");
        }
    }

}
