package projet;

import java.util.concurrent.Semaphore;

public class Employe extends Thread{

	
	private Buffet buffet;
	
	
	public Employe (Buffet buffet) {
		this.buffet=buffet;
		this.setDaemon(true);
	}
	
	public void run(){
		for(int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				try {
					buffet.semPoisson.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stocker(i);
				buffet.semPoisson.release();
			case 1:
				try {
					buffet.semViande.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stocker(i);
				buffet.semViande.release();
			case 2:
				try {
					buffet.semLegume.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stocker(i);
				buffet.semLegume.release();
			case 3:
				try {
					buffet.semNouille.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffet.stocker(i);
				buffet.semNouille.release();
				i=-1;
			}	
		}
	}
}
