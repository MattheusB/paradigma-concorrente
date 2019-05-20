package questao2;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;



public class ChannelImpl implements Channel {
    private ArrayList<String> messages;
    private int capacity;
    private Lock lock;
    private Condition empty;
    private Condition full;


    public ChannelImpl(int capacity){
        this.messages = new ArrayList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.empty = lock.newCondition();
        this.full = lock.newCondition();

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
            T output = this.messages.get(0);
            this.messages.remove(output);
            this.messages.notifyAll();
            return output;

        }
    }




}