package com.mycompany.loginhealthinspec;

public class Funcionario {
    private Integer idFuncionario;
    private Integer fkHospital;
    private String email;
    private String senha;
    
    public Funcionario(Integer idFuncionario, Integer fkHospital, String email, String senha) {
        this.idFuncionario = idFuncionario;
        this.fkHospital = fkHospital;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getFkHospital() {
        return fkHospital;
    }

    public void setFkHospital(Integer fkHospital) {
        this.fkHospital = fkHospital;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
