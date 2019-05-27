package questao5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapComparator implements Runnable{
	
	private int size;

	
	
	public MapComparator(int threadsNumber) {
		this.size = 150000/threadsNumber;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	private long putConcurrentHashMap() {
		Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		concurrentMap = putTest(concurrentMap);
		endTime = System.currentTimeMillis();
		
		realTime = endTime - startTime;
		return realTime;
		
	}
	
	private long putSynchronizedHashMap() {
		Map<String, Integer> synchMap = new HashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		startTime = System.currentTimeMillis();
		synchMap = putTest(synchMap);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	
	private Map<String, Integer> putTest(Map<String, Integer> auxMap) {
		for (int i = 0; i < this.size; i++) {
			auxMap.put(String.valueOf(i), i);
		}
		
		return auxMap;
	}
	
	
	private long getConcurrentHashMap() {
		Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		concurrentMap = putTest(concurrentMap);
		
		startTime = System.currentTimeMillis();
		concurrentMap = getTest(concurrentMap);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
	}
	
	private long getSynchronizedHashMap() {
		Map<String, Integer> synchMap = new HashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		synchMap = putTest(synchMap);
		
		startTime = System.currentTimeMillis();
		synchMap = getTest(synchMap);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
	}
	
	private Map<String, Integer> getTest(Map<String, Integer> auxMap) {
		
		Iterator<String> iterator = auxMap.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			auxMap.get(key);
		}
		
		return auxMap;
	}
	
	
	private long removeConcurrentHashMap() {
		Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		concurrentMap = putTest(concurrentMap);
		
		startTime = System.currentTimeMillis();
		concurrentMap = removeTest(concurrentMap);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
	}
	
	
	private long removeSynchronizedHashMap() {
		Map<String, Integer> synchMap = new HashMap<>();
		long startTime = 0;
		long endTime = 0;
		long realTime = 0;
		
		synchMap = putTest(synchMap);
		
		startTime = System.currentTimeMillis();
		synchMap = removeTest(synchMap);
		endTime = System.currentTimeMillis();
		realTime = endTime - startTime;
		
		return realTime;
		
	}
	
	private Map<String, Integer> removeTest(Map<String, Integer> auxMap) {
		for (int i = 0; i < this.size; i++) {
			auxMap.remove(String.valueOf(i), i);
		}
		return auxMap;
	}
	
	

}
