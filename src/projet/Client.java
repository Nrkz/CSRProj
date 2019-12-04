package projet;

import java.util.concurrent.Semaphore;

public class Client extends Thread{

	Semaphore semPoisson;
	Semaphore semViande;
	Semaphore semLegume;
	Semaphore semNouille;
	private Buffet buffet;
	private Stand stand;
	
	public Client (Buffet buffet, Stand stand) {
		this.buffet=buffet;
		this.stand = stand;
		prendrePortion();
		cuirePlat();
		mangerPlat();
		sortir();
		
	}
	
	public synchronized void cuirePlat() {
		stand.cuissonQueue();
	}
	
	public void mangerPlat() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sortir() {
		Restaurant.removeClient();
	}
	
	public void prendrePortion() {
		try {
			semPoisson.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semPoisson.release();
		buffet.destockerPoisson(100);
	}
}
