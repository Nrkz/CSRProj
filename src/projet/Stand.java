package projet;

public class Stand {
	
	
	public Stand(){}
	
	public void cuire() {
		notify();
	}
	
	public void cuissonQueue() {
		try {
			wait();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
