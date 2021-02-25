import java.util.Comparator;

public class Street implements Comparator<Street> {
    public final int sId;
    public final int begin;
    public final int end;
    public final String name;
    public final int time;

    public Street(int sId, int begin, int end,String name, int time) {
        this.sId =sId;
        this.begin = begin;
        this.end = end;
        this.time = time;
        this.name = name;
    }

    @Override
    public int compare(Street o1, Street o2) {
        return o1.time - o2.time;
    }
}
