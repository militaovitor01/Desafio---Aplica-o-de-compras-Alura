package principal;
import model.Cartao;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite limite do cartao!");
        Cartao cartao = new Cartao(scanner.nextDouble());

        scanner.nextLine(); // Consumir quebra de linha

        System.out.println("Digite 0 para sair e 1 para continuar!");
        int opcao = scanner.nextInt();

        while (opcao != 0) {
            System.out.println("Digite o que deseja comprar!");
            scanner.nextLine(); // Consumir quebra de linha
            String tipoCompra = scanner.nextLine();

            System.out.println("Digite o valor do produto!");
            double valorCompra = scanner.nextDouble();

            if (valorCompra > cartao.getSaldoCartao()) {
                System.out.println("Transação negada. Saldo insuficiente.");
            } else {
                System.out.println("Transação Aceita!");
                cartao.adicionarCompra(tipoCompra, valorCompra);
            }

            System.out.println("Digite 0 para sair e 1 para continuar!");
            opcao = scanner.nextInt();
        }

        Collections.sort(cartao.getListaCompras());
        System.out.println("\n" + cartao.getLimiteCartao());
        System.out.println("Lista de Compras:");
        for (String compra : cartao.getListaCompras()) {
            System.out.println(compra);
        }

        cartao.setSaldoCartao(cartao.calculaSaldo());

        System.out.println("\nSeu saldo atual é de " + cartao.getSaldoCartao());
        System.out.println("Encerrando atividade...");
    }
}
