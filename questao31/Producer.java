package questao31;
import java.util.Random;


public class Producer implements Runnable{
	
	private Random gerador;
	private int id;
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
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Primeira a acabar: " + this.randomNumber);
		this.data.put(randomNumber);
		 notify();
		return this.randomNumber;
	}

	@Override
	public void run() {
		int numThread = request();
	}
	
	public synchronized int getNum() {
		return this.randomNumber;
	}

}
