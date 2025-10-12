package spi_tp3_pabloaguilar;

import java.sql.*;

public class Conector_JBDC {
    
    static String url="jdbc:mysql://localhost:3306/fichas_psicologia_db?useSSL=false";
    static String user="root";
    static String pass="root";
    
    public static Connection conectar(){
        Connection con = null;
        try{
            con=DriverManager.getConnection(url, user, pass);
            //System.out.println("Conectado");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
}
