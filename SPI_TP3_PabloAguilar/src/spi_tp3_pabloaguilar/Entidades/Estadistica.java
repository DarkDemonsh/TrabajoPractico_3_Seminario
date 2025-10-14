package spi_tp3_pabloaguilar.Entidades;

import java.time.LocalDate;
import java.util.List;

public class Estadistica {
   
    int Pacientes_Atendidos;
    String Pacientes_con_cobertura;
    String Pacientes_sin_cobertura;
    int cupos_disponibles;
    List<String> resultado;
    int Estadistica_ID;
    LocalDate hoy = LocalDate.now();
    LocalDate dia = hoy;

    public Estadistica() {
    }

    public Estadistica(int Pacientes_Atendidos, String Pacientes_con_cobertura, String Pacientes_sin_cobertura, int cupos_disponibles, List<String> resultado, int Estadistica_ID, LocalDate dia) {
        this.Pacientes_Atendidos = Pacientes_Atendidos;
        this.Pacientes_con_cobertura = Pacientes_con_cobertura;
        this.Pacientes_sin_cobertura = Pacientes_sin_cobertura;
        this.cupos_disponibles = cupos_disponibles;
        this.resultado = resultado;
        this.Estadistica_ID = Estadistica_ID;
        this.dia = hoy;
    }

    public int getPacientes_Atendidos() {
        return Pacientes_Atendidos;
    }

    public void setPacientes_Atendidos(int Pacientes_Atendidos) {
        this.Pacientes_Atendidos = Pacientes_Atendidos;
    }

    public String getPacientes_con_cobertura() {
        return Pacientes_con_cobertura;
    }

    public void setPacientes_con_cobertura(String Pacientes_con_cobertura) {
        this.Pacientes_con_cobertura = Pacientes_con_cobertura;
    }

    public String getPacientes_sin_cobertura() {
        return Pacientes_sin_cobertura;
    }

    public void setPacientes_sin_cobertura(String Pacientes_sin_cobertura) {
        this.Pacientes_sin_cobertura = Pacientes_sin_cobertura;
    }

    public int getCupos_disponibles() {
        return cupos_disponibles;
    }

    public void setCupos_disponibles(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
    }

    public List<String> getResultado() {
        return resultado;
    }

    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }

    public int getEstadistica_ID() {
        return Estadistica_ID;
    }

    public void setEstadistica_ID(int Estadistica_ID) {
        this.Estadistica_ID = Estadistica_ID;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
  
}
