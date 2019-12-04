package projet;

public class Cuisinier extends Thread{
	private Stand stand;
    
    public Cuisinier(Stand stand) {
    	cuire();
    	this.stand = stand;
        
    }
    
    public synchronized void cuire() {
    	stand.cuire();
                
    }
	
}
