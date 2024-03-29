package projet;


public class Buffet {

	private int poissoncru;
	private int viandecru;
	private int legumecru;
	private int nouilles;
	
	public Buffet () {
		this.poissoncru = 1000;
		this.viandecru = 1000;
		this.legumecru = 1000;
		this.nouilles = 1000;
	}
	
	public int getPoisson() {
		return this.poissoncru;
	}
	
	public int getViande() {
		return this.viandecru;
	}
	
	public int getLegume() {
		return this.legumecru;
	}
	
	public int getNouille() {
		return this.nouilles;
	}

	public void stocker(int i) {
		switch (i) {
			case 0:
				if(getPoisson() < 100) {
					this.poissoncru = 1000;
					notify();
				}
				break;
			case 1:
				if(getViande() < 100) {
					this.viandecru = 1000;
					notify();
				}
				break;
			case 2:
				if(getLegume() < 100) {
					this.legumecru = 1000;
					notify();
				}
			case 3:
				if(getNouille() < 100) {
					this.nouilles = 1000;
					notify();
				}
		}
	}
	
	public void destocker(int qt, int i) {
		switch (i) {
			case 0:
				if(getPoisson() - qt < 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.poissoncru = getPoisson() - qt;
			case 1:
				if(getViande() - qt < 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.viandecru = getViande() - qt;
			case 2:
				if(getLegume() - qt<0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.legumecru = getLegume() - qt;
			case 3:
				if(getNouille() - qt <0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.nouilles = getNouille()- qt;
		}
	}
}
