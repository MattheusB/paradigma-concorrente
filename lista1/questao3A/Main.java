package lista1.questao3A;

public class Main{
    public static void main(String[] args) {
                
        Data data = new Data();
        Consumer consumer = new Consumer(data);
        int result = consumer.gateway(2);
        System.out.println(result);
        System.out.println("TERMINOU");   
    }
}

