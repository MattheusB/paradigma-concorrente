package lista2.questao3;



public class Data {
	
	private int value = -1;
	
	public void put(int putValue) {
		
		if (putValue < 0) {
			throw new IllegalArgumentException("Does not accept negative numbers!");
		}
		
		else {
			this.value = putValue;
		}
		
	}
	
	public int take() {
		int takeValue = this.value;
		
		this.value = -1;
		
		return takeValue;
	}
	
	
	public boolean isEmpty() {
		if (this.value == -1) {
			return true;
		}else {
			return false;
		}
	}
	
}