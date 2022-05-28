package com.mycompany.loginhealthinspec;

public class Maquinas {
    private Integer idMaquina;
    private Integer fkHospital;
    
    public Maquinas(Integer idMaquina, Integer fkHospital) {
        this.idMaquina = idMaquina;
        this.fkHospital = fkHospital;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getFkHospital() {
        return fkHospital;
    }

    public void setFkHospital(Integer fkHospital) {
        this.fkHospital = fkHospital;
    }
}
