package spi_tp3_pabloaguilar.Entidades;

public class Fichas {
    
    String Profesional;
    String Paciente;
    long DNI_Paciente;
    String Localidad;
    boolean Cobertura;
    String Diagnostico;
    String Motivo_Consulta;
    boolean Consulta;
    String Observacion;
    boolean Estado;

    public Fichas() {
    }

    public Fichas(String Profesional, String Paciente, long DNI_Paciente, String Localidad, boolean Cobertura, String Diagnostico, String Motivo_Consulta, boolean Consulta, String Observacion, boolean Estado) {
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
    }

    public String getProfesional() {
        return Profesional;
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

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
     
}
