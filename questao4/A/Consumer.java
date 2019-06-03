package questao4.A;

public class Consumer implements Runnable{
	
	private Data data;
	private int firstValue;
	
	public Consumer(Data data) {
		this.data = data;
	}
	public static void main(String[] args) {
			
		Data data = new Data();
		Consumer consumer = new Consumer(data);
		int result = consumer.gateway(2);
		System.out.println(result);
		
		
		
	}
	
	public int gateway(int num_replicas) {
		synchronized (this.data) {
			Thread thread = null;
			for (int i = 0; i < num_replicas; i++) {
				Producer temp = new Producer(this.data);
				thread = new Thread(temp);
				thread.start();
		}
			this.data.notifyAll();
			try {
				this.data.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.data.getValue();
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
