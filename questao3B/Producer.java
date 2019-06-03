package questao3B;
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
	
	public int request() {
		synchronized (this.data) {
			this.randomNumber = gerador.nextInt(30) + 1;
			try {
				Thread.sleep(this.randomNumber*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data.put(this.randomNumber);
			this.data.notify();
			}
		return this.randomNumber;
	}

	@Override
	public void run() {
			synchronized (this.data) {
				System.out.println("Thread in producer: " + Thread.currentThread().getName());
				while (!this.data.isEmpty()) {
					try {
						this.data.wait();
					} catch (InterruptedException ex) {
						System.err.println(ex.getLocalizedMessage());
					}
				}
				request();
		}
	}

}
