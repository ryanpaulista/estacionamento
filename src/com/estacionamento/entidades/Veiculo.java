package com.estacionamento.entidades;
import com.estacionamento.entidades.Cliente;

public class Veiculo{

    private String placa;
    private String modelo;
    private String cor;
    private Cliente cliente;

    public Veiculo(String placa, String modelo, String cor, Cliente cliente){
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("A placa não pode ser nula ou vazia.");
        }
        if (cliente == null || placa.isEmpty()) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
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
        this.cliente = cliente;
    }

    // Getters
    public String getPlaca(){return this.placa;}
    public String getModelo(){return this.modelo;}
    public String getCor(){return this.cor;}
    public Cliente getCliente(){return cliente;}

    // Setters
    public void setModelo(String modelo){this.modelo=modelo;}
    public void setCor(String cor){this.cor=cor;}
    public void setCliente(Cliente cliente){this.cliente=cliente;}

    // Representação em string (opcional)
    @Override
    public String toString() {
        return "Veiculo [placa = " + this.placa + ", modelo = " + this.modelo + ", cor = " + this.cor + ", cliente = " + cliente.getNome() + "]";
    }
    

}