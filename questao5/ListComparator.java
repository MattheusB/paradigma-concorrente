package questao5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListComparator implements Runnable{

	private int size;
	private CopyOnWriteArrayList<Integer> copyList;
	private ArrayList<Integer> synchList;
	private long startTime;
	private long stopTime;
	private long realTime;
	
    public ListComparator(int numberThreads){
    	this.copyList = new CopyOnWriteArrayList<>();
    	this.synchList = new ArrayList<>();
        this.size = 150000/numberThreads;
        this.startTime = 0;
        this.stopTime = 0;
        this.realTime = 0;
    	
    	
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	private long putCopyOnWriteArrayList () {
		
		this.startTime = System.currentTimeMillis();
		testPut(this.copyList);
		this.stopTime = System.currentTimeMillis();
		this.realTime = this.stopTime - this.startTime;
		
		return realTime;
		
		
	}
	
	private void testPut(List auxList) {
		for (int i = 0; i < this.size; i++) {
			auxList.add(i);
		}
	}

}