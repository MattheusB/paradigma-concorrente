package lista2.questao3;

import java.util.Random;

public class Producer implements Runnable {

	
	private Data data;
	
	public Producer(Data data) {
		this.data = data;
	}
	
	
	
	@Override
	public void run() {
		while (true) {
			synchronized (this.data) {
				while(!this.data.isEmpty()) {
					try {
						this.data.wait();
					}catch(InterruptedException e) {
						
					}
					int produced = new Random().nextInt(11);
					this.data.put(produced);
					System.err.println("Value produced: " + produced);
					this.data.notifyAll();
				}
			}
		}
		
	}
	
	
	
	
}