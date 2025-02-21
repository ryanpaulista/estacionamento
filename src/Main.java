import com.estacionamento.entidades.Cliente;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente(1, "Ryan", "84994003909");

        System.out.println(cliente1.get_nome());
    }

}