package input;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    public final int index;
    public  List<Integer> incoming = new ArrayList<>();
    public  List<Integer> outgoing = new ArrayList<>();

    public Intersection(int index) {
        this.index = index;
    }
}
