package com.estacionamento.entidades;

import com.estacionamento.entidades.Veiculo;

public class ClienteVIP extends Cliente{

    private boolean acessoLivre;
    private Veiculo veiculo;

    public ClienteVIP(int id, String nome, String telefone, String cpf, Veiculo veiculo){
        super(id, nome, telefone, cpf);
        this.acessoLivre = true;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo(){return this.veiculo;}

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    @Override
    public boolean devePagar(){
        return false; 
    }

    @Override
    public String toString(){
        return "Cliente VIP [Nome: " + getNome() + ", Telefone: " + getTelefone() + ", CPF: " + getCPF() + ", Veiculo: " + veiculo + "]\n";
    }

}