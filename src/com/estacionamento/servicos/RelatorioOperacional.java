package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

public class RelatorioOperacional extends Relatorio{

    private Vaga[] vagas;
    private int vagasLivres;
    private int vagasOcupadas;

    public RelatorioOperacional(Vaga[] vagas){
        this.vagas = vagas;
        this.vagasLivres = 0;
        this.vagasOcupadas = 0;
        for(int i=0; i<this.vagas.length;i++){
            if(vagas[i].getStatus()==StatusVaga.OCUPADA){
                vagasOcupadas++;
            } else{
                vagasLivres++;
            }
        }
    }

    @Override
    public String toString(){
        return "Relatório operacional:\n" + 
        "Quantidade de vagas livre: " + this.vagasLivres + "\n" +
        "Quantidade de vagas ocupadas: " + this.vagasOcupadas;
    }
}