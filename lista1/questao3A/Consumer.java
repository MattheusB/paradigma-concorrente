package lista1.questao3A;

public class Consumer{
	
	private Data data;
	
	public Consumer(Data data) {
		this.data = data;
	}
	
	public int gateway(int num_replicas) {
		Thread thread = null;
		synchronized(this.data){
			for (int i = 0; i < num_replicas; i++) {
				Producer temp = new Producer(this.data,i);
				thread = new Thread(temp);
				thread.start();
			}
		}
		synchronized(this.data){
			while(this.data.isEmpty()) {
				try {
					this.data.wait();	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			}
			return this.data.take();
		}
	}
}