package com.mycompany.loginhealthinspec;

public class Registros {
    
    private Integer idRegistros;
    private Integer fkComponenteMaquina;
    private Integer fkComponente;

    public Registros(Integer idRegistros, Integer fkComponenteMaquina, Integer fkComponente) {
        this.idRegistros = idRegistros;
        this.fkComponenteMaquina = fkComponenteMaquina;
        this.fkComponente = fkComponente;
    }

    public Registros() {
    }

    public Integer getIdRegistros() {
        return idRegistros;
    }

    public void setIdRegistros(Integer idRegistros) {
        this.idRegistros = idRegistros;
    }

    public Integer getFkComponenteMaquina() {
        return fkComponenteMaquina;
    }

    public void setFkComponenteMaquina(Integer fkComponenteMaquina) {
        this.fkComponenteMaquina = fkComponenteMaquina;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }

    @Override
    public String toString() {
        return "Registros{" + "idRegistros=" + idRegistros + ", fkComponenteMaquina=" + fkComponenteMaquina + ", fkComponente=" + fkComponente + '}';
    }
    
    
    
    
}
