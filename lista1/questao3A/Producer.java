package lista1.questao3A;


import java.util.Random;


public class Producer implements Runnable{
	
	private Random gerador;
	private int randomNumber;
	private Data data;
	private int myId;
	
	public Producer(Data data, int id) {
		this.gerador = new Random();
		this.randomNumber = 0;
		this.data = data;
		this.myId = id;
	}
	
	public int request() {
		this.randomNumber = gerador.nextInt(30) + 1;
		System.out.println("MY id: "+this.myId+" NUMBER: "+this.randomNumber);
		try {
			Thread.sleep(this.randomNumber*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data.put(this.randomNumber);
		this.data.notifyAll();
	
		return this.randomNumber;
	}

	@Override
	public void run() {
		synchronized (this.data) {
			while(!this.data.isEmpty()) {
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
