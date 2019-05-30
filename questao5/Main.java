package questao5;

public class Main {
	
	final static int threadsNumber = 1;
	
	public static void main(String args[]) throws InterruptedException{
		
		for (int i = 0; i < threadsNumber; i++) {
			ListComparator listComparator = new ListComparator(threadsNumber);
			Thread thread = new Thread(listComparator, "thread" + i);
			thread.start();
		}
		
		
		for (int i = 0; i < threadsNumber; i++) {
			MapComparator mapComparator = new MapComparator(threadsNumber);
			Thread thread = new Thread(mapComparator, "thread" + i);
			thread.start();
		}
		
	}

}
