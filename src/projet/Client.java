package projet;

public class Client extends Thread {
	


	public Client() {
		
		while (!entreRestaurant()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int rand;
		for (int i = 0 ; i < 4 ; i++) {
			rand = (int) Math.random() * 100;
			/*
			 * Pour chaque rand enlever X ingrédients au bac i 
			 * 
			 */
		}
		
		//faireCuire();
		
		//manger();
		
		sortirRestaurant();
		
		
		
		
	}
	
	public boolean entreRestaurant() {
		return Restaurant.addClients();
	}
	/*
	private boolean faireCuire() {
		Cuisinier.cuire();
	}
	*/
	private void manger() throws InterruptedException {
		sleep(1000);
		
	}
	
	private void sortirRestaurant() {
		Restaurant.removeClient();
	}
}
