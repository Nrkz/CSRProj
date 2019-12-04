package projet;

public class Restaurant {
	
	static final int CLIENTS_MAX = 25;
	private int nbClients;
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
			clients[i] = new Client(this.buffet, this.stand, this, i);
		}
	}
	
	public synchronized void addClients() {
		if(CLIENTS_MAX-nbClients<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nbClients++;
	}
	
	
	public synchronized void removeClient() {
		nbClients --;
		notify();	

	}
	
	public static void main(String args[]) {
		Restaurant restau = new Restaurant();
		restau.employe.start();
		restau.cuisto.start();
		for (int i = 0; i < restau.clients.length; i ++) {
			restau.clients[i].start();
		}
	}
}
