package questao5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListComparator implements Runnable{

	private int size;
	
    public ListComparator(int threadsNumber){
    	
        this.size = 150000/threadsNumber;
    	
    	
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	private long putCopyOnWriteArrayList () {
		
		List<Integer> copyList = new CopyOnWriteArrayList<>();
		
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		copyList = putTest(copyList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
		
	}
	
	private long putSychronizedList() {
		List<Integer> synchList = new ArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		synchList = putTest(synchList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	private List<Integer> putTest(List<Integer> auxList) {
		for (int i = 0; i < this.size; i++) {
			auxList.add(i);
		}
		
		return auxList;
	}
	
	
	private long getCopyOnWriteArrayList() {
		
		List<Integer> copyList = new CopyOnWriteArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		copyList = putTest(copyList);
		
		startTime = System.currentTimeMillis();
		copyList = getTest(copyList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	private long getSynchronizedList() {
		List<Integer> synchList = new ArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		synchList = putTest(synchList);
		
		startTime = System.currentTimeMillis();
		synchList = getTest(synchList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	
	private List<Integer> getTest(List<Integer> auxList) {
		
		for (int i = 0; i < this.size; i++) {
			auxList.get(i);
		}
		
		return auxList;
	}
	
	
	private long removeCopyOnWriteArrayList() {
		List<Integer> copyList = new CopyOnWriteArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		copyList = putTest(copyList);
		
		startTime = System.currentTimeMillis();
		copyList = removeTest(copyList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
	}
	
	private long removeSynchronizedList() {
		List<Integer> synchList = new ArrayList<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		synchList = putTest(synchList);
		
		startTime = System.currentTimeMillis();
		synchList = removeTest(synchList);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	
	private List<Integer> removeTest(List<Integer> auxList) {
		for (int i = 0; i < this.size; i ++) {
			auxList.remove(0);
		}
		
		return auxList;
	}
	

}