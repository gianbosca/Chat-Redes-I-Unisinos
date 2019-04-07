package servicos;

import java.util.Scanner;
import java.io.InputStream;

/**
 * servicos.GerenciaMsgsServidor
 * classe que implementa Runnable
 */
class GerenciaMsgsServidor implements Runnable {

    // definir a entrada do socket
	private InputStream serv;

	public GerenciaMsgsServidor(InputStream serv) {
		this.serv = serv;
	}

	//metodo para ficar transmintindo as mensagens
	public void run() {
		try{
		    //ler as entradas do socket
			Scanner le = new Scanner(this.serv);
			while (le.hasNextLine()) {
				//Envia msg
				System.out.println(le.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Erro no run do servicos.GerenciaMsgsServidor: "+e.getMessage());
		}
	}
}