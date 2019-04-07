package servicos;

import objetos.Cliente;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServicosCliente extends Cliente {
    public ServicosCliente(String nome, int porta) {
        super(nome, porta);
    }

    public void criarCliente() throws Exception {
        try{
            //instancia socket, scanner e printStream
            Socket cli = new Socket(getHOST(), getPorta());
            Scanner le = new Scanner(System.in);
            PrintStream print = new PrintStream(cli.getOutputStream());

            // se obteve sucesso continua
            //imprime cliente
            System.out.println("Cliente chamado "+getNome()+" conectou-se na porta: "+getPorta());

            //faz com que o server receba as msgs
            GerenciaMsgsServidor gerenciaMsgsServidor = new GerenciaMsgsServidor(cli.getInputStream());

            //abre uma thread para recepcao das msgs
            new Thread(gerenciaMsgsServidor).start();


            // comeca a ler msgs no terminal do cliente criado
            System.out.print("Digite: ");
            String line=null;
            while (le.hasNextLine()) {
                System.out.print("Digite: ");
                print.println(getNome()+" disse: "+(line=le.nextLine()));
            }
        } catch (Exception e){
            System.out.println("Problema criarCliente(): "+ e.getMessage());
        }
    }
}
