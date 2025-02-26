package com.estacionamento.entidades;

import java.util.Objects;

public class Veiculo{

    private String placa;
    private String modelo;
    private String cor;

    public Veiculo(String placa, String modelo, String cor){
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("A placa não pode ser nula ou vazia.");
        }
        if (cor == null || cor.isEmpty()) {
            throw new IllegalArgumentException("A cor não pode ser nula ou vazia.");
        }
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("O modelo não pode ser nulo ou vazio.");
        }

        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    // Getters
    public String getPlaca(){return this.placa;}
    public String getModelo(){return this.modelo;}
    public String getCor(){return this.cor;}

    // Setters
    public void setModelo(String modelo){this.modelo=modelo;}
    public void setCor(String cor){this.cor=cor;}

    // Representação em string (opcional)
    @Override
    public String toString() {
        return "Veiculo [placa = " + this.placa + ", modelo = " + this.modelo + ", cor = " + this.cor + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo outroVeiculo = (Veiculo) obj;
        return Objects.equals(placa, outroVeiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
    

}