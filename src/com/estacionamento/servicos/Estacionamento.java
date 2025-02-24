package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento{
    
    private Vaga[] vagas;
    private Tarifa tarifa;
    private Recibo[] recibos;
    private int proximoIdRecibo;

    public Estacionamento(int numVagas, Tarifa tarifa){
        this.vagas = new Vaga[numVagas];

        for (int i=0; i<numVagas;i++){
            vagas[i] = new Vaga(i+1);
        }
        this.tarifa = tarifa;
        this.recibos = new Recibo[100];
        this.proximoIdRecibo = 1;
    }

    // Encontra uma vaga livre
    public Vaga encontrarVagaLivre(){

        for (Vaga vaga : vagas){
            if(vaga.getStatus() == StatusVaga.LIVRE){
                return vaga;
            }
        }
        return null;
    }

    public boolean registrarEntrada(Veiculo veiculo){
        Vaga vaga = encontrarVagaLivre();
        return vaga.ocupar(veiculo);
    }

    public Recibo registrarSaida(String placa, LocalDateTime saida){
        for(Vaga vaga : vagas){
            if (vaga.getStatus() == StatusVaga.OCUPADA && vaga.getVeiculoNessaVaga().getPlaca().equals(placa)){
                Veiculo veiculo = vaga.liberar();
                LocalDateTime entrada = vaga.getEntrada();

                //Calcula o tempo de permanência
                Duration duracao = Duration.between(entrada, saida);
                double horas = duracao.toMinutes() / 60.0;

                //Valor a ser pago perante a tarifa
                double valor = tarifa.calcularTarifa(horas);

                //Gera do rebido
                Recibo recibo = new Recibo(proximoIdRecibo++, veiculo, entrada, saida, valor);
                adicionarRecibo(recibo);
                return recibo;
            }
        }
        throw new IllegalArgumentException("Veiculo não encontrado nas vagas.");
    }

    private void adicionarRecibo(Recibo recibo){
        for(int i=0; i<recibos.length; i++){
            if(recibos[i]==null){
                recibos[i] = recibo;
                break;
            }
        }
    }
}