package servicos;

import objetos.Servidor;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServicosServidor extends Servidor {

    public ServicosServidor(int porta){
        super(porta);
    }

    /**
     * cria servidor novo
     * @throws Exception
     */
    public void criarServidor() throws Exception  {
        try{
            ServerSocket servidor = new ServerSocket(getPorta());

            System.out.println("Servidor em execução na porta: "+getPorta());

            while (true) {
                // fica tentando aceitar uma conexao de cliente
                Socket cli = servidor.accept();

                //avisa no console quando houve nova conexão
                System.out.println();
                System.out.println("*************************");
                System.out.println("Nova conexão: "+cli.toString());
                System.out.println("*************************");
                System.out.println();

                //adiciona a lista dos sockets dos clientes
                //para futura comparacao para impressao
                getClis().add(cli);

                //tratara tais mensagens de cada socket de cliente
                GerenciaMsgsCliente gerenciaMsgsCliente = new GerenciaMsgsCliente(cli, this);

                //starta a trhead do cliente em execução
                new Thread(gerenciaMsgsCliente).start();
            }
        } catch (Exception e){
            throw new Exception();
        } finally {
            System.out.println("metodo criarServidor lancou excecao!");
        }
    }

    /**
     * @param socket = cliente que ta mandando msg
     * @param mensagem = recebe a msg
     */
    public void imprimeMsgs(Socket socket, String mensagem) {
        for (int i = 0; i < getClis().size() ; i++) {
            //caso o socket esteja fechado nem tenta imprimir
           if (!socket.isClosed()){
                if(getClis().get(i).equals(socket)){
                    //nao imprime pra si mesmo
                }else{
                    //imprime pra demais clientes com seu socket aberto
                    try {
                        PrintStream ps = new PrintStream(getClis().get(i).getOutputStream());
                        ps.println("\n"+mensagem+"\nDigite:");
                    } catch (Exception e) {
                        System.out.println("Erro no imprimeMsgs: "+e.getMessage());
                    }
                }
            }
        }
    }

}
