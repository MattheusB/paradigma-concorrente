package lista1.questao2;





public class Consumer implements Runnable {

    Channel channel;

    public Consumer(Channel channel){
        this.channel = channel;
    }

    @Override
    public void run(){
        for (int i = 0; i < 9; i++){
            System.err.println("Read Message: " + channel.takeMessage());
        }
        
        for (int i = 0; i < 3; i++){
            System.err.println("Read Message: " + channel.takeMessage());
        }
    }

}