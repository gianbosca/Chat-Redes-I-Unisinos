package objetos;

import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	//definir a porta
	private int porta;

	//definimos arraylist para armazenar sockets dos clientes
	private ArrayList<Socket> clis;

	public Servidor(int porta) {
		//definir qual porta utiliza
		this.porta = porta;
		//instancia com um arraylis vazio
		this.clis = new ArrayList<>();
	}

    public int getPorta() {
        return porta;
    }

    public ArrayList<Socket> getClis() {
        return clis;
    }

}
