import java.util.List;

public class ListComparator implements Runnable{
    private List<Integer> list;
    private long time;

    public ListComparator(List<Integer> list){
        this.list = list;
        
    }

}