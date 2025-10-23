package spi_tp3_pabloaguilar.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
