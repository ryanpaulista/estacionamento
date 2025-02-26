// Main.java
import com.estacionamento.entidades.*;
import com.estacionamento.servicos.*;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar cliente e veículo

        // Criar estacionamento e tarifa
        Tarifa tarifa = new Tarifa(10.0, 5.0); // R$10/hora, mínimo R$5
        Estacionamento estacionamento = new Estacionamento(10, tarifa);
        
        List<Veiculo> veiculos = new ArrayList<>();


        while (true) {
            System.out.println("\n=============== MENU ===============");
            System.out.println("|  1. Registrar entrada de veículo |");
            System.out.println("|  2. Registrar saída de veículo   |");
            System.out.println("|  3. Gerar relatório operacional  |");
            System.out.println("|  4. Gerar relatório financeiro   |");
            System.out.println("|  5. Sair                         |");
            System.out.println("====================================");
            System.out.print("└───> Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("└───> Digite a placa do veículo:\nPLACA: ");
                        String placa = scanner.nextLine();
                        System.out.print("└───> Digite o modelo do veículo:\nMODELO: ");
                        String modelo = scanner.nextLine();
                        System.out.print("└───> Digite a cor do veículo:\nCOR: ");
                        String cor = scanner.nextLine();

                        Veiculo veiculo = new Veiculo(placa, modelo, cor);

                        veiculos.add(veiculo);

                        salvarVeiculos(veiculos);

                        estacionamento.registrarEntrada(veiculo);

                        System.out.println("Veículo registrado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Digite a placa do veículo:");
                        String placa = scanner.nextLine();
                        LocalDateTime saida = LocalDateTime.now();

                        for (int i=0; i<veiculos.size(); i++){
                            if(veiculos.get(i).getPlaca().equals(placa)){
                                veiculos.remove(i);
                            }
                        }

                        salvarVeiculos(veiculos);
                        Recibo recibo = estacionamento.registrarSaida(placa, saida);
                        System.out.println("Saída registrada com sucesso!");
                        System.out.println(recibo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("\nGerando Relatório Operacional... \n");
                        RelatorioOperacional relatorioOperacional = new RelatorioOperacional(estacionamento.getVagas());
                        relatorioOperacional.gerar();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    if(estacionamento.getRecibos().length==0){
                        try{
                            System.out.println("\nGerando Relatório Financeiro...");
                            RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro(estacionamento.getRecibos());
                            relatorioFinanceiro.gerar();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else{
                        System.out.println("\n\033[31mNenhum valor foi arrecadado!\033[0m");
                        break;
                    }
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void salvarVeiculos(List<Veiculo> veiculos){
        
        try(FileWriter veiculosNoEstacionamento = new FileWriter("com/estacionamento/data/estacionamento.txt", false)){

            for (int i=0; i<veiculos.size(); i++){
                veiculosNoEstacionamento.write((i+1) + "º: " + veiculos.get(i).toString() + "\n");
            }

        } catch(IOException e) {
            System.out.println("Erro ao salvar os veiculos no arquivo: " + e.getMessage());
        }

    }
    
}

    
        
