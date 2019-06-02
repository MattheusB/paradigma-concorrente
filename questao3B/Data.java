package questao3B;

public class Data {
	private int value;
	
	public Data() { 
		this.value = -1;
	}
	
	public void put(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(
					"Nao pode adicionar valores negativos");
		}
		this.value = value;
		System.out.println("Primeiro Valor: " + value);
	}
	
	public int take() {
		int valueToTake = this.value;
		this.value = -1;
		return valueToTake;
	}
	
	public boolean isEmpty() {
		return this.value == -1;
	}
	
	public int getValue() {
		return this.value;
	}

}
