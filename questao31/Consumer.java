package questao31;

public class Consumer implements Runnable{
	
	private Data data;
	private int firstValue;
	
	public Consumer(Data data) {
		this.data = data;
	}
	public static void main(String[] args) {
			
		Data data = new Data();
		Consumer consumer = new Consumer(data);
		int taken = consumer.gateway(5);
		System.out.println(taken);
	}
	
	public int gateway(int num_replicas) {
		for (int i = 0; i < num_replicas; i++) {
			Producer temp = new Producer(this.data);
			Thread thread = new Thread(temp);
			thread.start();
		}
		return this.data.take();
	}
	@Override
	public void run() {
		while (true) {
			
			synchronized(this.data) {
				while (this.data.isEmpty()) {
					try {
						this.data.wait();
					} catch (InterruptedException ex) {
					}
				}
				this.firstValue = this.data.take();
				System.err.println("Primeira Thread foi: " + this.firstValue);
				this.data.notifyAll();
			}

		}
	}	
	
}
