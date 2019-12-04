package projet;

import java.util.concurrent.Semaphore;

public class Client extends Thread{

	Semaphore semPoisson;
	Semaphore semViande;
	Semaphore semLegume;
	Semaphore semNouille;
	private Buffet buffet;
	
	public Client (Buffet buffet) {
		this.buffet=buffet;
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
