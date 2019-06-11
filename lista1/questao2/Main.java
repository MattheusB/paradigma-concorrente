package questao2;



public class Main {
    public static void main(String args[]) throws InterruptedException{
        Channel channel = new ChannelImpl(10);
        Producer producer = new Producer(channel);
        Consumer consumer = new Consumer(channel);


        Thread producerThread = new Thread(producer, "producerThread");
        Thread consumerThread = new Thread(consumer, "consumerThread");


        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}