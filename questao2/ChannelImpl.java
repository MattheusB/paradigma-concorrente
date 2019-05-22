package questao2;

import java.util.ArrayList;



public class ChannelImpl implements Channel {
    private ArrayList<String> messages;
    private int capacity;


    public ChannelImpl(int capacity){
        this.messages = new ArrayList<>();
        this.capacity = capacity;

    }

    @Override
    public void putMessage (String message){
        synchronized (this.messages){
            while (this.messages.size() == this.capacity){
                try {
                    this.messages.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        this.messages.add(message);
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
            String output = this.messages.get(0);
            this.messages.remove(output);
            this.messages.notifyAll();
            return output;

        }
    }




}