package com.estacionamento.servicos;

public class Tarifa{

    private double valorPorHora;
    private double valorMinimo;

    public Tarifa(double valorPorHora, double valorMinimo){
        this.valorPorHora = valorPorHora;
        this.valorMinimo = valorMinimo;
    }

    public double calcularTarifa(double horas){
        return valorMinimo + (valorPorHora * horas);
    }
}