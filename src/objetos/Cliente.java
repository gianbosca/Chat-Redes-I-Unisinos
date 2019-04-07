package objetos;

public class Cliente {

    // declara como localhost
	private static String HOST = "127.0.0.1";
	private String nome;
	private int porta;

	public Cliente(String nome, int porta) {
		this.nome = nome;
		this.porta = porta;
	}

    public static String getHOST() {
        return HOST;
    }

    public String getNome() {
        return nome;
    }

    public int getPorta() {
        return porta;
    }
}
