package lista2.questao3;



public class Consumer implements Runnable{
	
	private Data data;
	
	public Consumer(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (this.data) {
				while (this.data.isEmpty()) {
					try {
						this.data.wait();
					}catch(InterruptedException e) {
						
					}
					
					int consumed = this.data.take();
					System.err.println("Value consumed: " + consumed);
					this.data.notifyAll();				
					}
			}
		}
		
	}
}