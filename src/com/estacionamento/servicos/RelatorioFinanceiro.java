package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

public class RelatorioFinanceiro implements Relatorio{

    private Recibo[] recibos;
    private double valor;

    public RelatorioFinanceiro(Recibo[] recibos){
        this.recibos = recibos;
        this.valor = 0.0;
        for(int i=0; i<this.recibos.length;i++){
            this.valor += this.recibos[i].getValor();
        }
    }

    @Override
    public void gerar(){
        System.out.println("Valor total arrecadado: R$ " + valor);
    }
}