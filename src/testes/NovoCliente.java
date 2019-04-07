package testes;

import servicos.ServicosCliente;
import java.util.Scanner;

public class NovoCliente {
	public static void main(String[] args) {
		try {
			//instancia scanner para ler dados
			Scanner le = new Scanner(System.in);

			//Identificação do cliente
			String nome = "";
			while(nome == ""){
				System.out.print("Digite seu nome: ");
				nome = le.nextLine();
			}

			//indentificacao da porta
			int porta = 0;
			while(porta <= 1024){
				System.out.print("Digite a porta: ");
				porta = le.nextInt();
				if(porta <= 1024)
					System.out.println("Porta Invalida!");
			}

			//cria o cliente
            ServicosCliente c = new ServicosCliente(nome, porta);
			c.criarCliente();

		} catch (Exception e){
			System.out.println("HEY, Problemas CLI:\n"+e.getMessage());
		} finally {
			System.out.println("Cliente não criado!");
		}
	}
}
