package com.estacionamento.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.estacionamento.entidades.StatusVaga;
import com.estacionamento.entidades.Veiculo;

public class Vaga{

    private int id;
    private StatusVaga status;
    private Veiculo veiculo;
    private LocalDateTime entrada;

    public Vaga(int id){
        this.id = id;
        this.status = StatusVaga.LIVRE;
    }

    public StatusVaga getStatus(){
        return this.status;
    }

    public Veiculo getVeiculoNessaVaga(){
        if(status==StatusVaga.LIVRE){
            return null;
        }
        return this.veiculo;
    }

    public LocalDateTime getEntrada(){
        return this.entrada;
    }

    public boolean ocupar(Veiculo veiculo){
        if(status != StatusVaga.LIVRE){
            return false;
        }
        this.status = StatusVaga.OCUPADA;
        this.veiculo = veiculo;
        this.entrada = LocalDateTime.now();
        return true;
    }
    
    public Veiculo liberar(){
        if(status != StatusVaga.OCUPADA){
            return null;
        }
        this.status = StatusVaga.LIVRE;
        Veiculo veiculoLiberado = this.veiculo;
        this.veiculo = null;
        return veiculoLiberado;
    }

}