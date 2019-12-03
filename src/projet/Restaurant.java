package projet;

public class Restaurant {
	
	static final int CLIENTS_MAX = 25;
	private Buffet buffet;
	private Stand stand;
	private Cuisinier cuisto;
	
	public Restaurant () {
		this.buffet = new Buffet();
	}

}
