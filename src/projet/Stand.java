package projet;

public class Stand {
	boolean occupe;
	
	public Stand(){
		this.occupe = false;
	}
	
	int i = 0;
	int b = 0;
	
	public synchronized void cuire() {
			System.out.println("Cuisson " + i);
			i++;
			notify();
	}

	public synchronized boolean enAttenteCuisson() {
		if(occupe) {
			try {
				System.out.println("b : " + b);
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
