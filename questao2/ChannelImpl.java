package questao2;

import java.util.ArrayList;

public class ChannelImpl<T> implements Channel<T> {
    private ArrayList<T> messages;
    private int capacity;


    public ChannelImpl(int capacity){
        this.messages = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void putMessage (String message){
        synchronized (this.messages){
            while (this.messages.size() == capacity){
                try {
                    this.messages.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        this.messages.add((T) message);
        this.messages.notifyAll();

        }
    }

    @Override
    public String takeMessage(){
        synchronized (this.messages){
            while (this.messages.size() == 0){
                try {
                    this.messages.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            T output = this.messages.get(0);
            this.messages.remove(output);
            this.messages.notifyAll();
            return output;

        }
    }




}