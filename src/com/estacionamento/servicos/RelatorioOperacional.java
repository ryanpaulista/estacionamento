package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

public class RelatorioOperacional implements Relatorio{

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
    public void gerar(){
        System.out.println("Vagas ocupadas: " + vagasOcupadas + "\n" + "Vagas livre: " + vagasLivres);
    }
}