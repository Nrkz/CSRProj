package projet;

public class Restaurant {
	
	static final int CLIENTS_MAX=25;
	
	public static void main(String[] args) {
		Buffet buffet = new Buffet();
		Employe employe = new Employe(buffet);
		for (int i=0;i<25;i++) {
			Client client = new Client(buffet);
		}
		
	}
}
