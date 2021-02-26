package io;

import model.Car;
import model.Edge;
import model.Vertex;
import process.CityMap;

import java.util.List;

public class InputReader {

    public static CityMap createFromFile(List<String> lines) {
        StringBuilder sb = new StringBuilder();

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

            Vertex vf = cityMap.vertexList.get(vertexFrom);
            Vertex vt = cityMap.vertexList.get(vertexTo);

            Edge e = new Edge(id, line[2], time, vf, vt);
            cityMap.edgeList.add(e);
            cityMap.name2edgeMap.put(line[2], e);

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
            for (int k = 2; k < noOfHops; k++) {
                c.addPath(cityMap.name2edgeMap.get(line[k]));
            }
            cityMap.carList.add(c);
            id++;
        }

        return cityMap;
    }
}
