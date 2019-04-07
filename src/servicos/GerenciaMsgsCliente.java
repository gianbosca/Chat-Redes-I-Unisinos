package servicos;

import servicos.ServicosServidor;
import java.net.Socket;
import java.util.Scanner;

/**
 * servicos.GerenciaMsgsCliente
 * classe que implementa Runnable
 */
class GerenciaMsgsCliente implements Runnable {

	//declara socket
	private Socket cli;

	//servidor utilizado
	private ServicosServidor serv;

	public GerenciaMsgsCliente(Socket cli, ServicosServidor serv) {
		this.cli = cli;
		this.serv = serv;
	}

	// trata individualmente para cada socket de cliente
	public void run() {
		try {
            Scanner le = new Scanner(this.cli.getInputStream());
			while (le.hasNextLine()) {
				serv.imprimeMsgs(this.cli, le.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Erro no run do servicos.GerenciaMsgsCliente"+e.getMessage());
		}
	}
}