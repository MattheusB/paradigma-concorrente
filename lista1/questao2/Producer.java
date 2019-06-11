package questao2;



public class Producer implements Runnable{
    Channel channel;

    public Producer (Channel channel){
        this.channel = channel;
    }

    @Override
    public void run(){
        for (int i = 1; i < 9; i++){
            channel.putMessage("Message " + i);
        }
    }

}

