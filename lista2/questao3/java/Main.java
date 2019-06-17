package lista2.questao3.java;


import java.util.Random;



public class Main {
    public static void main(String args[]) throws InterruptedException{
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        
        Thread producerThread = new Thread(producer, "producerThread");
        Thread consumerThread = new Thread(consumer, "consumerThread");
        
        producerThread.start();
        consumerThread.start();
        
        producerThread.join();
        consumerThread.join();
    }
}