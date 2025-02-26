package com.estacionamento.entidades;

public class Cliente{

    private int id;
    private String nome;
    private String telefone;
    private String cpf;

    public Cliente(int id, String nome, String telefone, String cpf){
        
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        if(telefone==null || telefone.length()<8){
            throw new IllegalArgumentException("Telefone inválido. Deve ter pelo menos 8 dígitos.");
        }
        if(cpf==null || cpf.length()>14 || cpf.length()<14){
            throw new IllegalArgumentException("CPF inválido. Deve ter 14 dígitos.");
        }

        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        
    }

    // Getters
    public int getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getTelefone(){return this.telefone;}
    public String getCPF(){return this.cpf;}

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

    public boolean devePagar(){
        return true;
    }

}