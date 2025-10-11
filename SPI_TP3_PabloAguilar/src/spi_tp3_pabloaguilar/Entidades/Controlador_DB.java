package spi_tp3_pabloaguilar.Entidades;

public class Controlador_DB {
    
    int ID_ficha;
    int DNI_Paciente;
    int ID_Estadistica;
    long fecha_resultado;

    public Controlador_DB() {
    }

    public Controlador_DB(int ID_ficha, int DNI_Paciente, int ID_Estadistica, long fecha_resultado) {
        this.ID_ficha = ID_ficha;
        this.DNI_Paciente = DNI_Paciente;
        this.ID_Estadistica = ID_Estadistica;
        this.fecha_resultado = fecha_resultado;
    }

    public int getID_ficha() {
        return ID_ficha;
    }

    public void setID_ficha(int ID_ficha) {
        this.ID_ficha = ID_ficha;
    }

    public int getDNI_Paciente() {
        return DNI_Paciente;
    }

    public void setDNI_Paciente(int DNI_Paciente) {
        this.DNI_Paciente = DNI_Paciente;
    }

    public int getID_Estadistica() {
        return ID_Estadistica;
    }

    public void setID_Estadistica(int ID_Estadistica) {
        this.ID_Estadistica = ID_Estadistica;
    }

    public long getFecha_resultado() {
        return fecha_resultado;
    }

    public void setFecha_resultado(long fecha_resultado) {
        this.fecha_resultado = fecha_resultado;
    }
    
}
