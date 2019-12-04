package projet;

public class Restaurant {
	
	static final int CLIENTS_MAX = 25;
	private static int nbClients;
	private Client[] clients;
	private Buffet buffet;
	private Stand stand;
	private Cuisinier cuisto;
	
	public Restaurant () {
		this.buffet = new Buffet();
		this.stand = new Stand();
		this.cuisto = new Cuisinier();
		this.nbClients = 0;
		this.clients = new Client[50];
		
		for (int i = 0; i < clients.length; i ++) {
			clients[i] = new Client();
		}
	}
	
	public static boolean addClients() {
		if(nbClients < CLIENTS_MAX) {
			nbClients++;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void removeClient() {
		nbClients --;
	}

}
