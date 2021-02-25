import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarPath implements Comparator<CarPath> {
    public final int cid;
    public final int hops;
    public final List<Integer> streetList;

    public CarPath(int cid, int hops) {
        this.cid = cid;
        this.hops = hops;
        this.streetList = new ArrayList<>();
    }

    @Override
    public int compare(CarPath o1, CarPath o2) {
        return o1.hops-o2.hops;
    }
}
