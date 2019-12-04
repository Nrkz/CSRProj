package projet;

import java.util.concurrent.Semaphore;

public class Buffet {

	private int poissoncru;
	private int viandecru;
	private int legumecru;
	private int nouilles;
	
	public Buffet () {
		this.poissoncru=1000;
		this.viandecru= 1000;
		this.legumecru=1000;
		this.nouilles =1000;
	}
	
	public int getPoisson() {
		return this.poissoncru;
	}
	
	public void destockerPoisson(int poissonpris) {
		if(poissoncru-poissonpris<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.poissoncru = poissoncru-poissonpris;
	}
	
	public void stockerPoisson() {
		if(getPoisson()<100) {
			this.poissoncru=1000;
			notify();
		}
	}
	
}
