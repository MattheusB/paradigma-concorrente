import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	public static int gateway(int num_replicas) {
		for (int i = 0; i < num_replicas; i++) {
			Request temp = new Request(i);
			Thread thread = new Thread(temp);
			thread.start();
		}
		return ;
	}
	
}
