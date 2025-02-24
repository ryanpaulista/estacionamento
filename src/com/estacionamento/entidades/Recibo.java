package com.estacionamento.entidades;

import com.estacionamento.entidades.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recibo{

    private int id;
    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valor;

    public Recibo(int id, Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida, double valor){
        this.id = id;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String entradaFormatada = this.entrada.format(formatter);
        String saidaFormatada = this.saida.format(formatter);
        
        return "Recibo [ID = " + this.id + 
               ", Placa = " + this.veiculo.getPlaca() + 
               ", Entrada = " + entradaFormatada + 
               ", Saída = " + saidaFormatada + 
               ", Valor = R$ " + this.valor + "]"; 
    }
}