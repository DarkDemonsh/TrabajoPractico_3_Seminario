package spi_tp3_pabloaguilar;

import java.util.Scanner;
import spi_tp3_pabloaguilar.Entidades.Controlador_DB;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;

public class SPI_TP3_PabloAguilar {

    public static void main(String[] args) {
    Conector_JBDC jdbc=new Conector_JBDC();
        
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Controlador_DB c = new Controlador_DB();
    
    Scanner leer = new Scanner(System.in);
    int exit = 1;
    
    Ficha_S fs = new Ficha_S();
  
    
do{
    System.out.println("");
    System.out.println("1- Agregar Ficha");
    System.out.println("2- Borrar Ficha");
    System.out.println("0- Salir");
    System.out.println("");
    
    int i = leer.nextInt();
    
    switch(i){
        case 1: 
            fs.Agregar_Ficha(f, e, c);
            break;   
        case 2: 
            System.out.println("Ficha a Borrar");
            int b = leer.nextInt();
            fs.Borrar_Ficha(b);
            break;
        case 0:
             exit = 0;
             break;
        
    }
}while(exit != 0);    
    
    }
    
}
