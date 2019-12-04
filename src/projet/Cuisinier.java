package projet;

public class Cuisinier extends Thread{
	private Stand stand;
    
    public Cuisinier(Stand stand) {
    	this.stand = stand;
    	this.setDaemon(true);
        
    }
    
    public void run() {
    	stand.cuire();
                
    }
	
}
