package process;

import model.Edge;

import java.util.Collections;

public class BruteForce {
    
    public Object solve(CityMap cityMap) {

        //randomly assign initial state
        for (int t = 0; t < cityMap.duration; t++) {

            Collections.sort(cityMap.edgeList);
            for (Edge e : cityMap.edgeList) {

            }

        }

        return new Object();
    }
}
