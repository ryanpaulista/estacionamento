package com.estacionamento.entidades;

public class Cliente{

    private int id;
    private String nome;
    private String telefone;

    public Cliente(int id, String nome, String telefone){
        this.id = id;
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        } 
        this.nome = nome;
        if(telefone==null || telefone.length()<8){
            throw new IllegalArgumentException("Telefone inválido. Deve ter pelo menos 8 dígitos.");
        }
        this.telefone = telefone;
    }

    public int get_id(){
        return this.id;
    }

    public String get_nome(){
        return this.nome;
    }

    public String get_telefone(){
        return this.telefone;
    }

    public void set_nome(String nome){
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        this.nome = nome;
    }

    public void set_telefone(String telefone){
        if(telefone==null || telefone.length()<8){
            throw new IllegalArgumentException("Telefone inválido. Deve ter pelo menos 8 dígitos.");
        }
        this.telefone = telefone;
    }

}