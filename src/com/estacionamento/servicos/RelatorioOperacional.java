package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class RelatorioOperacional implements Relatorio{

    private List<Vaga> vagas;
    private int vagasLivres;
    private int vagasOcupadas;

    public RelatorioOperacional(List<Vaga> vagas){
        this.vagas = vagas;
        this.vagasLivres = 0;
        this.vagasOcupadas = 0;
        for(int i=0; i<this.vagas.size();i++){
            if(vagas.get(i).getStatus()==StatusVaga.OCUPADA){
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