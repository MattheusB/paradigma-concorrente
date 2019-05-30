import java.util.Random;


public class Main {
	
	private static int numThread = 0;
	
	public static void main(String[] args) {
		
	}
	
	public int geteway(int num_replicas) {
		for (int i = 0; i < num_replicas; i++) {
			Request temp = new Request(i);
			Thread thread = new Thread(temp);
			thread.start();
			numThread++;
		}
		return this.numThread;
	}
	
	public static class Request implements Runnable{
		
		private Random gerador;
		private int id;
		
		
		public Request(int id) {
			this.gerador = new Random();
			this.id = id;
		}
		
		public synchronized int request() {
			int numSorteado = gerador.nextInt(31);
			try {
				Thread.sleep(numSorteado);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return numSorteado;
		}
	
		@Override
		public void run() {
			request();
			System.out.println("Thread num: " + this.id);
		}
	}
}
