package projet;

public class Cuisinier extends Thread{
	private Stand stand;
    
    public Cuisinier(Stand stand) {
    	this.stand = stand;
    	this.setDaemon(true);
        
    }
    
    public void run() {
    	while(true) {
    		try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		stand.cuire();
    	}
    	
    }
	
}
