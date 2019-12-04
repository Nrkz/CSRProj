package projet;

import java.util.concurrent.Semaphore;

public class Client extends Thread{

	Semaphore semPoisson;
	Semaphore semViande;
	Semaphore semLegume;
	Semaphore semNouille;
	private Buffet buffet;
	private Stand stand;
	private Restaurant restau;
	private int i;

	

	public Client (Buffet buffet, Stand stand,Restaurant restau,int i) {
		this.i = i;
		this.buffet=buffet;
		this.stand = stand;
		this.restau = restau;
		this.semPoisson = new Semaphore(Restaurant.CLIENTS_MAX);
		this.semViande = new Semaphore(Restaurant.CLIENTS_MAX);
		this.semLegume = new Semaphore(Restaurant.CLIENTS_MAX);
		this.semNouille = new Semaphore(Restaurant.CLIENTS_MAX);		
	}

	public void run() {
		entrerRestaurant();	
		prendrePortion();
		cuirePlat();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("bug");
			e.printStackTrace();
		}
		sortir();
	}

	public synchronized void entrerRestaurant(){
		if(restau.remplis()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Bonjour !" + this.i);
		restau.addClients();
	}	



	public void cuirePlat() {
		stand.cuire();
	}

	public void mangerPlat() {
		try {
			sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("CAFAITPAS 3 SECONOONONONDES");
		}
	}

	public synchronized void sortir() {
		Restaurant.removeClient();
		System.out.println("cc" + this.i);
		notifyAll();
	}

	public void prendrePortion() {
		for(int i = 0; i<4 ; i++) {
			switch (i) {
			case 0:
				try {
					semPoisson.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semPoisson.release();
				buffet.destocker(alea()*100,i);
			case 1:
				try {
					semViande.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semViande.release();
				buffet.destocker(alea()*100,i);
			case 2 :
				try {
					semLegume.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semLegume.release();
				buffet.destocker(alea()*100,i);
			case 3:
				try {
					semNouille.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semNouille.release();
				buffet.destocker(alea()*100,i);
			}
		}
	}
	public int alea() {
		int rand = (int) Math.random();
		return rand;
	}
}
