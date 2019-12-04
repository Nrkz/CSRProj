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
<<<<<<< HEAD
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
=======
		
>>>>>>> Quentin
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
