package spi_tp3_pabloaguilar;

import spi_tp3_pabloaguilar.Entidades.Controlador_DB;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class SPI_TP3_PabloAguilar {

    public static void main(String[] args) {
    Conector_JBDC jdbc=new Conector_JBDC();
    //jdbc.conectar();
        
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Controlador_DB c = new Controlador_DB();
    
    Ficha_S fs = new Ficha_S();
    
    fs.Agregar_Ficha(f, e, c);
    }
    
}
