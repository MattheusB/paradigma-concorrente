
public class Data {
	private int value;
	
	public Data() { 
		this.value = -1;
	}
	
	public void put(int value) {
		if (value < 0) {
			throws new IllegalArgumentException(
					"Nao pode adicionar valores negativos");
		}
		this.value = value;
	}
	
	public int take() {
		int valueToTake = this.value;
		this.value = -1;
		return valueToTake;
	}
	
	public boolean isEmpty() {
		return this.value == -1;
	}

}
