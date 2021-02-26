package process;

import model.Car;
import model.Edge;
import model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityMap {
    public final int duration;
    public final int vertexCount;
    public final int edgeCount;
    public final int carCount;
    public final int scores;


    //list of intersections
    public List<Vertex> vertexList;


    public List<Edge> edgeList;

    //list of all cars
    public List<Car> carList;


    //street name to edge map
    public Map<String, Edge> name2edgeMap;

    //the graph of vertices and edges
    public List<List<Vertex>> adjList;

    public CityMap(int duration, int vertexCount, int edgeCount, int carCount, int scores) {
        this.duration = duration;
        this.vertexCount = vertexCount;

        this.edgeCount = edgeCount;
        this.carCount = carCount;
        this.scores = scores;
        adjList = new ArrayList<>();
        name2edgeMap = new HashMap<>();
        vertexList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            Vertex v = new Vertex(i);
            vertexList.add(v);
            adjList.add(new ArrayList<>());
        }
        carList = new ArrayList<>();
        edgeList = new ArrayList<>();


    }


}
