package com.mycompany.loginhealthinspec;

import org.springframework.jdbc.core.JdbcTemplate;

public class Usuario {
    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDataSource());
    
    
    private Integer id;
    private String nome;
    private String senha; 
    
    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario() {
        
    }

    @Override
    public String toString() {
        return String.format("ID: %d \nNome: %s \nSenha: %s\n", id, nome, senha);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
