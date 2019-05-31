import java.util.Random;

public class Request  Request implements Runnable{
	
	private Random gerador;
	private int id;
	private int randomNumber;
	
	public Request(int id) {
		this.gerador = new Random();
		this.id = id;
		this.randomNumber = 0;
	}
	
	public synchronized int request() {
		this.randomNumber = gerador.nextInt(31);
		try {
			Thread.sleep(this.randomNumber);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.randomNumber;
	}

	@Override
	public void run() {
		int numThread = request();
	}
	
	public int getNum() {
		return this.randomNumber;
	}

}
