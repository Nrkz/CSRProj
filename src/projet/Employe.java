package projet;

import java.util.concurrent.Semaphore;

public class Employe extends Thread{

	
	private Buffet buffet;
	Semaphore semPoisson;
	Semaphore semViande;
	Semaphore semLegume;
	Semaphore semNouille;
	
	
	public Employe (Buffet buffet) {
		this.buffet=buffet;
		stockerBuffet();
	}
	
	public void stockerBuffet(){
		for(int i = 0; i<4; i++) {
			switch (i) {
			case 0:
				try {
					semPoisson.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stockerPoisson();
				semPoisson.release();				
			case 1:
				try {
					semViande.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stockerViande();
				semViande.release();
			case 2:
				try {
					semLegume.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stockerLegume();
				semLegume.release();	
			case 3:
				try {
					semNouille.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stockerNouille();
				semNouille.release();		
			}	
		}
	}
}
