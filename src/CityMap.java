import java.util.*;

public class CityMap {
    public final int duration;
    public final int intersectionCount;
    public final int streetCount;
    public final int carCount;
    public final int scores;

    //maps street id to street object
    public final Map<Integer, Street> streetMap;

    //maps car id to carpath object
    public final Map<Integer, CarPath> carPathMap;

    //maps streetname to street id object
    public final Map<String,Integer> streetName2Id;

    public CityMap(int duration, int intersectionCount, int streetCount, int carCount, int scores) {
        this.duration = duration;
        this.intersectionCount = intersectionCount;
        this.streetCount = streetCount;
        this.carCount = carCount;
        this.scores = scores;
        streetMap = new HashMap<>();
        carPathMap = new HashMap<>();
        streetName2Id = new HashMap<>();
    }

}
