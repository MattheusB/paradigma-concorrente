package questao3B;

public class Consumer implements Runnable{
	
	private Data data;
	private int sum;
	private int replicas;
	
	public Consumer(Data data) {
		this.data = data;
		this.replicas = 0;
	}
	public static void main(String[] args) throws InterruptedException {
			
		Data data = new Data();
		Consumer consumer = new Consumer(data);
		int result = consumer.gateway(4);
		System.out.println("RESULTADO FINAL: " + result);
		
		
		
	}
	
	public int gateway(int num_replicas) throws InterruptedException {
		synchronized (this.data) {
			this.replicas = num_replicas;
			Thread thread = null;
			for (int i = 0; i < num_replicas; i++) {
				Producer temp = new Producer(this.data);
				thread = new Thread(temp);
				thread.start();
			}
		}
		run();
		return sum;
	}
	@Override
	public void run() {
		while (data.getCont() < this.replicas) {
			synchronized(this.data) {
				while (this.data.isEmpty()) {
					try {
						this.data.wait();
					} catch (InterruptedException ex) {
					}
				}
				this.sum += this.data.take();
				System.err.println("Thread: " + Thread.currentThread().getName() + " Valor da soma: " + this.sum);
				this.data.notifyAll();
			}
		}
	}	
	
}
