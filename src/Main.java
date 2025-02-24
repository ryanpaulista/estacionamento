import com.estacionamento.entidades.*;
import com.estacionamento.servicos.*;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente(1, "Ryan", "84994003909");

        System.out.println(cliente1.getNome());

        Veiculo veiculo1 = new Veiculo("1", "Civic", "Preto", cliente1);

        System.out.println(veiculo1);

        Vaga vaga1 = new Vaga(1);

        vaga1.ocupar(veiculo1);
        
        System.out.println(vaga1.getStatus());
        System.out.println(vaga1.getEntrada());

        Tarifa tarifa1 = new Tarifa(10.0, 5.0);

        System.out.println("Tarifa = " +  tarifa1.calcularTarifa(3));

        Estacionamento estacionamento1 = new Estacionamento(10, tarifa1);
        
        System.out.println("Veiculo entrou = " + estacionamento1.registrarEntrada(veiculo1));
        LocalDateTime saida = LocalDateTime.now();
        System.out.println(estacionamento1.registrarSaida("1", saida));

    }

}