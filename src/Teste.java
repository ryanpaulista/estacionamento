// Main.java
import com.estacionamento.entidades.*;
import com.estacionamento.servicos.*;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar cliente e veículo

        // Criar estacionamento e tarifa
        Tarifa tarifa = new Tarifa(10.0, 5.0); // R$10/hora, mínimo R$5
        Estacionamento estacionamento = new Estacionamento(10, tarifa);
        

        try(FileWriter veiculosNoEstacionamento = new FileWriter("com/estacionamento/data/estacionamento.txt")){
            // Menu principal
            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Registrar entrada de veículo");
                System.out.println("2. Registrar saída de veículo");
                System.out.println("3. Gerar relatório operacional");
                System.out.println("5. Gerar relatório financeiro");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        try {
                            System.out.println("Digite a placa do veículo:");
                            String placa = scanner.nextLine();
                            System.out.println("Digite o modelo do veículo:");
                            String modelo = scanner.nextLine();
                            System.out.println("Digite a cor do veículo:");
                            String cor = scanner.nextLine();

                            Veiculo veiculo = new Veiculo(placa, modelo, cor);

                            estacionamento.registrarEntrada(veiculo);
                            veiculosNoEstacionamento.write(veiculo.toString() + "\n");
                            veiculosNoEstacionamento.flush();

                            System.out.println("Veículo registrado com sucesso!");
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Digite a placa do veículo:");
                        String placa = scanner.nextLine();
                        LocalDateTime saida = LocalDateTime.now();
                        try {
                            Recibo recibo = estacionamento.registrarSaida(placa, saida);
                            System.out.println("Saída registrada com sucesso!");
                            System.out.println(recibo);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try{
                            System.out.println("Gerando Relatório Operacional...");
                            RelatorioOperacional relatorioOperacional = new RelatorioOperacional(estacionamento.getVagas());
                            System.out.println(relatorioOperacional);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try{
                            System.out.println("Gerando Relatório Financeiro...");
                            RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro(estacionamento.getRecibos());
                            System.out.println(relatorioFinanceiro);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch(IOException e){
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    
    }
        
}