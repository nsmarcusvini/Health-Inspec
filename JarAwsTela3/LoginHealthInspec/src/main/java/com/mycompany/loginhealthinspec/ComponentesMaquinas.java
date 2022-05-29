package com.mycompany.loginhealthinspec;

public class ComponentesMaquinas {
    
    private Integer idComponenteMaquina;
    private Integer fkMaquina;

    public ComponentesMaquinas(Integer idComponenteMaquina) {
        this.idComponenteMaquina = idComponenteMaquina;
    }

    public ComponentesMaquinas() {
    }

    public Integer getIdComponenteMaquina() {
        return idComponenteMaquina;
    }

    public void setIdComponenteMaquina(Integer idComponenteMaquina) {
        this.idComponenteMaquina = idComponenteMaquina;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }
    
    

    @Override
    public String toString() {
        return "ComponentesMaquinas{" + "idComponenteMaquina=" + idComponenteMaquina + '}';
    }
    
    
    
}
