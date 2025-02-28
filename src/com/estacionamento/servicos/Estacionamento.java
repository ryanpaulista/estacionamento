package com.estacionamento.servicos;

import com.estacionamento.entidades.*;

import java.time.Duration;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Estacionamento{
    
    private List<Vaga> vagas;
    private Tarifa tarifa;
    private List<Recibo> recibos;
    private int proximoIdRecibo;
    private int proximoIdCliente;
    private List<ClienteVIP> clientesVIP;

    public Estacionamento(int numVagas, Tarifa tarifa){
        this.vagas = new ArrayList<>();

        for (int i=0; i<numVagas;i++){
            vagas.add(i, new Vaga(i+1));
        }

        this.tarifa = tarifa;
        this.recibos = new ArrayList<>();
        this.proximoIdRecibo = 1;
        this.proximoIdCliente = 1;
        this.clientesVIP = new ArrayList<>();
    }

    // getters
    public List<Vaga> getVagas(){return Collections.unmodifiableList(this.vagas);}
    public List<Recibo> getRecibos(){return Collections.unmodifiableList(this.recibos);}
    public List<ClienteVIP> getClientesVIP(){return Collections.unmodifiableList(this.clientesVIP);}

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
                double valor = 0.0;

                if(isClienteVIP(veiculo)==false){
                    valor = tarifa.calcularTarifa(horas);
                }
    
                //Gera do rebido
                Recibo recibo = new Recibo(proximoIdRecibo++, veiculo, entrada, saida, valor);
                adicionarRecibo(recibo);
                return recibo;
            }
        }
        throw new IllegalArgumentException("Veiculo não encontrado nas vagas.");
    }

    private void adicionarRecibo(Recibo recibo){
        if (recibo==null){
            throw new IllegalArgumentException("O recibo não pode ser nulo.");
        }
        recibos.add(recibo);
    }

    public void registrarClienteVIP(String nome, String telefone, String cpf, Veiculo veiculo){
        ClienteVIP clienteVIP = new ClienteVIP(proximoIdCliente++, nome, telefone, cpf, veiculo);
        clientesVIP.add(clienteVIP);
    }

    public void editarClienteVIP(String cpf){

        Scanner scanner = new Scanner(System.in);
       
        for(ClienteVIP clienteVIP : clientesVIP){
            if(clienteVIP.getCPF().equals(cpf)){
               System.out.print("└───> O que deseja alterar?\n1 - CPF / 2 = NOME / 3 = TELEFONE / 4 = VEICULO: ");
               int opcao = scanner.nextInt();
               scanner.nextLine();
               switch(opcao){
                    case 1:
                        System.out.print("└───> Digite o novo CPF do cliente VIP:\nCPF - ___.___.___-__: ");
                        String cpf2 = scanner.nextLine();
                        clienteVIP.setCPF(cpf2);
                        break;
                    case 2:
                        System.out.print("└───> Digite o novo nome do cliente VIP:\nNome: ");
                        String nome = scanner.nextLine();
                        clienteVIP.setNome(nome);
                        break;
                    case 3:
                        System.out.print("└───> Digite o novo telefone do cliente VIP:\nTELEFONE: ");
                        String telefone = scanner.nextLine();
                        clienteVIP.setCPF(telefone);
                        break;
                    case 4:
                        System.out.print("└───> Digite a placa do veículo do cliente VIP:\nPLACA: ");
                        String placa = scanner.nextLine();
                        System.out.print("└───> Digite o modelo do veículo do cliente VIP:\nMODELO: ");
                        String modelo = scanner.nextLine();
                        System.out.print("└───> Digite a cor do veículo do cliente VIP:\nCOR: ");
                        String cor = scanner.nextLine();
                        Veiculo veiculo = new Veiculo(placa, modelo, cor);
                        clienteVIP.setVeiculo(veiculo);
                        break;
               }
            }
        }
    }

    public boolean removerClienteVIP(String cpf){
        for(ClienteVIP clienteVIP : clientesVIP){
            if(clienteVIP.getCPF().equals(cpf)){
                clientesVIP.remove(clienteVIP);
                return true;
            }
        }
        return false;
    }

    private boolean isClienteVIP(Veiculo veiculo){
        List<ClienteVIP> clientesVIP = getClientesVIP();
        if (clientesVIP == null || clientesVIP.isEmpty()) {
            return false;
        }

        for (ClienteVIP clienteVIP : clientesVIP) {
            Veiculo veiculoVIP = clienteVIP.getVeiculo();
            if (veiculoVIP != null && veiculo.equals(veiculoVIP)) {
                return true;
            }
        }
        return false;
    }

}