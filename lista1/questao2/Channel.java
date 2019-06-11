package questao2;


public interface Channel {
    public void putMessage(String message);
    public String takeMessage();
}
