package process;

import model.Edge;
import model.Vertex;
import util.OutputFile;
import util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForce {

    public OutputFile solve(CityMap cityMap) {

        OutputFile of = new OutputFile();
        Collections.sort(cityMap.vertexList);


        for (Vertex v : cityMap.vertexList) {
            if (v.incoming.size() == 0) {
                break;
            }
            List<Pair<String, Integer>> pList = of.result.get(v.vid);
            if (pList == null) {
                pList = new ArrayList<>();
                of.result.put(v.vid, pList);
            }

            if (v.incoming.size() == 1) {
                of.intersectionCount++;
                Pair<String, Integer> p = new Pair<>(v.incoming.get(0).name, 1);
                pList.add(p);

            } else {
                List<Edge> elist = v.incoming;
                Collections.sort(elist);
                of.intersectionCount++;
                //  if (v.incoming.size() < 100) {
                for (Edge e : elist) {
                    Pair<String, Integer> p = new Pair<>(e.name, 1);
                    pList.add(p);
                }
                        /*
                } else {
                    System.out.println("Dreadful stuff");
                    int edgeCount = elist.size();
                    double totalCount = 0;

                    for (int i = 0; i < elist.size(); i++) {
                        totalCount += elist.get(i).carsHandled;
                    }
                    System.out.println(" total count " + totalCount);
                    for (Edge e : elist) {
                        int seed = (int) (Math.ceil(cityMap.duration / edgeCount) * (Math.ceil(e.carsHandled / totalCount)));
                        if (seed != 0) {
                            Pair<String, Integer> p = new Pair<>(e.name, 1);
                            pList.add(p);
                        }
                    }
                }
                */
            }
        }
        return of;
    }
}
