package spi_tp3_pabloaguilar.Servicio;

public class Profesional {
  
    String nombre_profesional;
    int Cupos_Disponibles;

    public Profesional() {
    }

    public Profesional(String nombre_profesional, int Cupos_Disponibles) {
        this.Cupos_Disponibles = 7;
        this.nombre_profesional = nombre_profesional;
        this.Cupos_Disponibles = Cupos_Disponibles;
    }

    public String getNombre_profesional() {
        return nombre_profesional;
    }

    public void setNombre_profesional(String nombre_profesional) {
        this.nombre_profesional = nombre_profesional;
    }

    public int getCupos_Disponibles() {
        return Cupos_Disponibles;
    }

    public void setCupos_Disponibles(int Cupos_Disponibles) {
        this.Cupos_Disponibles = Cupos_Disponibles;
    }
    
}
