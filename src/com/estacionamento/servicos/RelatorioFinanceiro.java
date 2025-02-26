package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class RelatorioFinanceiro implements Relatorio{

    private List<Recibo> recibos;
    private double valor;

    public RelatorioFinanceiro(List<Recibo> recibos){
        this.recibos = recibos;
        this.valor = 0.0;
        for(int i=0; i<this.recibos.size();i++){
            this.valor += this.recibos.get(i).getValor();
        }
    }

    @Override
    public void gerar(){
        System.out.println("Valor total arrecadado: R$ " + valor);
    }
}