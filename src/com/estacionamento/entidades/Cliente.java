package com.estacionamento.entidades;

public class Cliente{

    private int id;
    private String nome;
    private String telefone;

    public Cliente(int id, String nome, String telefone){
        
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        if(telefone==null || telefone.length()<8){
            throw new IllegalArgumentException("Telefone inválido. Deve ter pelo menos 8 dígitos.");
        }

        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters
    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getTelefone(){return this.telefone;}

    // Setters
    public void setNome(String nome){
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        this.nome = nome;
    }

    public void setTelefone(String telefone){
        if(telefone==null || telefone.length()<8){
            throw new IllegalArgumentException("Telefone inválido. Deve ter pelo menos 8 dígitos.");
        }
        this.telefone = telefone;
    }

}