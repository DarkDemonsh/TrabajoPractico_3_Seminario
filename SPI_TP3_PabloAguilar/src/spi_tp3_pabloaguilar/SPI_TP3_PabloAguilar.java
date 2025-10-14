package spi_tp3_pabloaguilar;

import java.time.LocalDate;
import java.util.Scanner;
import spi_tp3_pabloaguilar.Entidades.Controlador_DB;
import spi_tp3_pabloaguilar.Entidades.Estadistica;
import spi_tp3_pabloaguilar.Entidades.Fichas;
import spi_tp3_pabloaguilar.Servicio.Estadistica_S;
import spi_tp3_pabloaguilar.Servicio.Ficha_S;
import spi_tp3_pabloaguilar.Entidades.Profesional;

public class SPI_TP3_PabloAguilar {

    public static void main(String[] args) {
    Conector_JBDC jdbc=new Conector_JBDC();
        
    Fichas f = new Fichas();
    Estadistica e = new Estadistica();
    Profesional p = new Profesional();
    Controlador_DB c = new Controlador_DB();
    
    Scanner leer = new Scanner(System.in);
    int exit = 1;
    int r = 0, r1 = 0, r2 = 0;
    LocalDate ld1, ld2;
    String ld0 = null, ld00 = null;
    
    Ficha_S fs = new Ficha_S();
    Estadistica_S es = new Estadistica_S();
  
try{   
do{
    System.out.println("");
    System.out.println("1- Agregar Ficha");
    System.out.println("2- Borrar Ficha");
    System.out.println("3- Mostrar Fichas");
    System.out.println("4- Listar Fichas por Fechas");
    System.out.println("5- Buscar por Cobertura");
    System.out.println("0- Salir");
    System.out.println("");
    
    int i = leer.nextInt();
    
    switch(i){
        case 1: 
            fs.Agregar_Ficha(f, e, p);
            break;   
        case 2: 
            System.out.println("Ficha a Borrar");
            int b = leer.nextInt();
            fs.Borrar_Ficha(b);
            break;
        case 3:
            System.out.println("Quieres buscar una ficha o entre un grupo de Fichas? 1/2");
            r = leer.nextInt();
            
            if(r == 1){
            System.out.println("Escribir la Ficha que desea Buscar");
            r1 = leer.nextInt();
            r2 = r1;
            }else if(r == 2){
            System.out.println("Elegir entre que Fichas Buscar");
            r1 = leer.nextInt();
            r2 = leer.nextInt();
            }
            
            System.out.println("");
            fs.Listar_Ficha(r1, r2);
            break;
        case 4:
           System.out.println("Quieres buscar una ficha o entre un grupo de Fichas? 1/2");
            r = leer.nextInt();
            leer.nextLine();
            if(r == 1){
            System.out.println("Escribir la Fecha que desea Buscar");
            ld0 = leer.nextLine();
            ld00 = ld0;
            }else if(r == 2){
            System.out.println("Elegir entre las que Fechas Buscar");
            ld0 = leer.nextLine();
            ld00 = leer.nextLine();
            }
            
            ld1 = LocalDate.parse(ld0);
            ld2 = LocalDate.parse(ld00);
            System.out.println("");
            es.Pacientes_X_Dia(ld1, ld2);
            break;
        case 5:
            System.out.println("Tiene cobertura? Si/No");
            ld0 = leer.next();
            if(ld0.equalsIgnoreCase("si")){
            es.Cobertura_Paciente(true);
            }else if(ld0.equalsIgnoreCase("no")){
            es.Cobertura_Paciente(false);    
            }
            break;
        case 6:
            leer.nextLine();
            System.out.println("Nombre del Profesional");
            ld0 = leer.nextLine();
            
            es.Cupos_Disponibles(ld0);
            break;
        case 0:
             exit = 0;
             break;
        
    }
}while(exit != 0);    
}catch(Exception ex){
    System.out.println("Error 000 "+ex.getMessage());
}    
    }
    
}
