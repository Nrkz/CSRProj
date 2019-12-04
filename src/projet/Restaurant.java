package projet;

public class Restaurant {
	
	static final int CLIENTS_MAX = 25;
	private static int nbClients;
	private Client[] clients;
	private Buffet buffet;
	private Stand stand;
	private Cuisinier cuisto;
	private Employe employe;
	
	public Restaurant () {
		this.buffet = new Buffet();
		this.employe = new Employe(this.buffet);
		this.stand = new Stand();
		this.cuisto = new Cuisinier(this.stand);
		this.nbClients = 0;
		this.clients = new Client[50];
		
		for (int i = 0; i < clients.length; i ++) {
			clients[i] = new Client(this.buffet, this.stand, this);
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
	
	public static void main(String args[]) {
		Restaurant restau = new Restaurant();
		for (int i = 0; i < restau.clients.length; i ++) {
			restau.clients[i].start();
		}
		restau.employe.start();
		restau.cuisto.start();
	}
}
