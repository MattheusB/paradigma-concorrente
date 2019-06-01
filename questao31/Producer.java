package questao31;
import java.util.Random;


public class Producer implements Runnable{
	
	private Random gerador;
	private int randomNumber;
	private Data data;
	
	public Producer(Data data) {
		this.gerador = new Random();
		this.randomNumber = 0;
		this.data = data;
	}
	
	public synchronized int request() {
		this.randomNumber = gerador.nextInt(31);
		try {
			Thread.sleep(this.randomNumber);
			System.out.println("Random num: " + randomNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data.put(this.randomNumber);
		return this.randomNumber;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.data) {
				if (!this.data.isEmpty()) {
					try {
						this.data.wait();
					} catch (InterruptedException ex) {
						System.err.println(ex.getLocalizedMessage());
					}
					
				}
				request();
				this.data.notifyAll();
			}
		}
	}

}
