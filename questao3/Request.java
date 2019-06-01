import java.util.Random;


public class Request implements Runnable{
	
	private Random gerador;
	private int id;
	private int randomNumber;
	private Data data;
	
	public Request(int id) {
		this.gerador = new Random();
		this.id = id;
		this.randomNumber = 0;
		this.data = New Data();
	}
	
	public synchronized int request() {
		this.randomNumber = gerador.nextInt(31);
		try {
			Thread.sleep(this.randomNumber);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data.put(randomNumber)
		this.data.notifyAll();
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
