package projet;

import java.util.concurrent.Semaphore;

public class Client extends Thread{

	private Buffet buffet;
	private Stand stand;
	private Restaurant restau;
	int i;
	

	public Client (Buffet buffet, Stand stand,Restaurant restau,int i) {
		this.buffet=buffet;
		this.stand = stand;
		this.restau = restau;
		this.i=i;
	}

	public void run() {
		
		entrerRestaurant();		
		System.out.println("Entree reussi pour thread :"+i);
		prendrePortion();
		System.out.println("Prendre Portion :"+i);
		cuirePlat();
		mangerPlat();
		sortir();
		System.out.println("Sortie reussi ");
	}
	
	public synchronized void entrerRestaurant(){		
		restau.addClients();
	}


	public void cuirePlat() {
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
		restau.removeClient();
	}

	public void prendrePortion() {
		for(int i = 0; i<4 ; i++) {
			switch (i) {
			case 0:
				try {
					buffet.semPoisson.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semPoisson.release();
				buffet.destocker(alea()*100,i);
			case 1:
				try {
					buffet.semViande.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semViande.release();
				buffet.destocker(alea()*100,i);
			case 2 :
				try {
					buffet.semLegume.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semLegume.release();
				buffet.destocker(alea()*100,i);
			case 3:
				try {
					buffet.semNouille.acquire();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sleep(200+alea()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.semNouille.release();
				buffet.destocker(alea()*100,i);
			}
		}
	}
	public int alea() {
		int rand = (int) Math.random();
		return rand;
	}
	
}
