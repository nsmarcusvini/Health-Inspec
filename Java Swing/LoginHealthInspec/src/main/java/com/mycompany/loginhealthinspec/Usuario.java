package com.mycompany.loginhealthinspec;

public class Usuario {
    private Integer id;
    private String nome;
    private String senha; 
    
    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
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
