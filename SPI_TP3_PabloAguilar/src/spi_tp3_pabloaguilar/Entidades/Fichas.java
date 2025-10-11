package spi_tp3_pabloaguilar.Entidades;

import java.time.LocalDateTime;

public class Fichas {
    
    int Ficha_ID;
    String Profesional;
    String Paciente;
    long DNI_Paciente;
    String Localidad;
    boolean Cobertura;
    String Diagnostico;
    String Motivo_Consulta;
    boolean Consulta;
    String Observacion;
    int Estado;
    LocalDateTime date;

    public Fichas() {
    }

    public Fichas(int Ficha_ID, String Profesional, String Paciente, long DNI_Paciente, String Localidad, boolean Cobertura, String Diagnostico, String Motivo_Consulta, boolean Consulta, String Observacion, int Estado, LocalDateTime date) {
        this.Ficha_ID = Ficha_ID;
        this.Profesional = Profesional;
        this.Paciente = Paciente;
        this.DNI_Paciente = DNI_Paciente;
        this.Localidad = Localidad;
        this.Cobertura = Cobertura;
        this.Diagnostico = Diagnostico;
        this.Motivo_Consulta = Motivo_Consulta;
        this.Consulta = Consulta;
        this.Observacion = Observacion;
        this.Estado = Estado;
        this.date = date;
    }

    public String getProfesional() {
        return Profesional;
    }

    public int getFicha_ID() {
        return Ficha_ID;
    }

    public void setFicha_ID(int Ficha_ID) {
        this.Ficha_ID = Ficha_ID;
    }

    public void setProfesional(String Profesional) {
        this.Profesional = Profesional;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public long getDNI_Paciente() {
        return DNI_Paciente;
    }

    public void setDNI_Paciente(long DNI_Paciente) {
        this.DNI_Paciente = DNI_Paciente;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public boolean isCobertura() {
        return Cobertura;
    }

    public void setCobertura(boolean Cobertura) {
        this.Cobertura = Cobertura;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getMotivo_Consulta() {
        return Motivo_Consulta;
    }

    public void setMotivo_Consulta(String Motivo_Consulta) {
        this.Motivo_Consulta = Motivo_Consulta;
    }

    public boolean isConsulta() {
        return Consulta;
    }

    public void setConsulta(boolean Consulta) {
        this.Consulta = Consulta;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
