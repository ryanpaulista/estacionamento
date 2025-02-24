// Main.java
import com.estacionamento.entidades.*;
import com.estacionamento.servicos.Estacionamento;
import com.estacionamento.servicos.Tarifa;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar cliente e veículo
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefoneCliente = scanner.nextLine();

        Cliente cliente = new Cliente(1, nomeCliente, telefoneCliente);
        Veiculo veiculo = new Veiculo("ABC1234", "Fusca", "Azul", cliente);

        // Criar estacionamento e tarifa
        Tarifa tarifa = new Tarifa(10.0, 5.0); // R$10/hora, mínimo R$5
        Estacionamento estacionamento = new Estacionamento(10, tarifa);

        // Menu principal
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Gerar relatório financeiro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    try {
                        estacionamento.registrarEntrada(veiculo);
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
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}