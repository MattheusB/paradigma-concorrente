package questao3B;

public class Consumer implements Runnable{
	
	private Data data;
	private int sum;
	
	public Consumer(Data data) {
		this.data = data;
	}
	public static void main(String[] args) {
			
		Data data = new Data();
		Consumer consumer = new Consumer(data);
		int result = consumer.gateway(2);
		System.out.println("A soma eh: " + result);
		
		
		
	}
	
	public int gateway(int num_replicas) {
		synchronized (this.data) {
			Thread thread = null;
			for (int i = 0; i < num_replicas; i++) {
				Producer temp = new Producer(this.data);
				thread = new Thread(temp);
				thread.start();
				System.out.println("Iteracao: " + i);
			}
			run();
		}
		return sum;
	}
	@Override
	public void run() {
		while (true) {
			System.out.println("Aqui");
			synchronized(this.data) {
				while (this.data.isEmpty()) {
					System.out.println("Waiting");
					try {
						this.data.wait();
					} catch (InterruptedException ex) {
					}
				}
				System.out.println("Acordou?");
				this.sum += this.data.take();
				System.err.println("Thread: " + Thread.currentThread().getName() + " Valor da soma: " + this.sum);
				this.data.notifyAll();
			}

		}
	}	
	
}
