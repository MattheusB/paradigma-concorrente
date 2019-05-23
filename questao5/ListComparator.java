package questao5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListComparator implements Runnable{

	private int size;
	
    public ListComparator(int numberThreads){
    	
        this.size = 150000/numberThreads;
    	
    	
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	private long putCopyOnWriteArrayList () {
		
		CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>();
		
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		testPut(copyList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
		
	}
	
	private long putSychronizedList() {
		ArrayList<Integer> synchList = new ArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		testPut(synchList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	private void testPut(List auxList) {
		for (int i = 0; i < this.size; i++) {
			auxList.add(i);
		}
	}
	
	
	private long getCopyOnWriteArrayList() {
		
		CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		testPut(copyList);
		
		startTime = System.currentTimeMillis();
		testGet(copyList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	
	private void testGet(List auxList) {
		
		for (int i = 0; i < this.size; i++) {
			auxList.get(i);
		}
	}

}