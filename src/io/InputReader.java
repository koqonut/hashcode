package io;

import model.Car;
import model.Edge;
import model.Vertex;
import process.CityMap;

import java.util.List;

public class InputReader {

    public static CityMap createFromFile(List<String> lines) {
        //read line 0;

        String[] line0 = lines.get(0).split(" ");
        int duration = Integer.valueOf(line0[0]);
        int vertexCounts = Integer.valueOf(line0[1]);
        int edgeCounts = Integer.valueOf(line0[2]);
        int cars = Integer.valueOf(line0[3]);
        int scores = Integer.valueOf(line0[3]);

        CityMap cityMap = new CityMap(duration, vertexCounts, edgeCounts, cars, scores);

        int id = 0;
        int i = 1;
        for (; i <= edgeCounts; i++) {

            String[] line = lines.get(i).split(" ");
            int vertexFrom = Integer.valueOf(line[0]);
            int vertexTo = Integer.valueOf(line[1]);
            int time = Integer.valueOf(line[3]);
            String name = line[2];

            Vertex vf = cityMap.vertexList.get(vertexFrom);
            Vertex vt = cityMap.vertexList.get(vertexTo);

            Edge e = new Edge(id, name, time, vf, vt);
            cityMap.edgeList.add(e);
            cityMap.name2edgeMap.put(name, e);

            vf.addOutgoingEdge(e);
            vt.addIncomingEdge(e);


            cityMap.adjList.get(vertexFrom).add(vt);

        }
        System.out.println("streets done  " + i);
        id = 0;
        for (; i <= edgeCounts + cars; i++) {
            String[] line = lines.get(i).split(" ");
            int noOfHops = Integer.valueOf(line[0]);
            Edge currEdgeLoc = cityMap.name2edgeMap.get(line[1]);
            Car c = new Car(id, currEdgeLoc, noOfHops);
            currEdgeLoc.edgeTraffic.carsWaiting.add(c);
            currEdgeLoc.incrementCarsHandled();

            for (int k = 2; k <= noOfHops; k++) {
                Edge e = cityMap.name2edgeMap.get(line[k]);
                e.incrementCarsHandled();
                //System.out.println("e " + e.name + " dist |" + e.distanceFromEnd + "|" + totalDistance);
            }
            cityMap.carList.add(c);
            id++;
        }
        /*
        for (Edge e : cityMap.edgeList) {
            System.out.println("Cars Handled  " + e.carsHandled);
        }

         */

        System.out.println("Cars done  " + i);
        return cityMap;
    }
}
