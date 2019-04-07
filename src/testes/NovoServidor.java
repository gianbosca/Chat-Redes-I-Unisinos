package testes;

import servicos.ServicosServidor;

import java.util.Scanner;

/**
 * classe para instanciar um servidor
 */
public class NovoServidor {
    public static void main(String[] args) {
        try {
            //instancia scanner para ler dados
            Scanner le = new Scanner(System.in);

            //indentificacao da porta
            int porta = 0;
            while(porta <= 1024){
                System.out.print("Digite a porta: ");
                porta = le.nextInt();
                if(porta <= 1024)
                    System.out.println("Porta Invalida!");
            }

            //instancia servidor
            ServicosServidor s = new ServicosServidor(porta);

            //cria o servidor
            s.criarServidor();
        }catch (Exception e){
            System.out.println("Problema SERV: "+e.getMessage());
        }finally {
            System.out.println("Servidor não iniciado!");
        }

    }
}
