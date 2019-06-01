package questao31;

public class Consumer {
	
	private Data data;
	
	public Consumer(Data data) {
		this.data = data;
	}
	public static void main(String[] args) {
			
		Data data = new Data();
		Consumer consumer = new Consumer(data);
		int n_thread = consumer.gateway(3);
		
		System.out.println(n_thread);
	}
	
	public int gateway(int num_replicas) {
		for (int i = 0; i < num_replicas; i++) {
			Producer temp = new Producer(data);
			Thread thread = new Thread(temp);
			thread.start();
			System.out.println("Thread Id: " + thread.getId());
			this.data.put(temp.getNum());
			System.out.println("Iteracao: " + i);
		}
		return this.data.take();
	}
	
	
}
