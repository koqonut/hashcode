package model;

import state.EdgeTraffic;

public class Edge implements Comparable<Edge> {

    public final int eid;
    public final String name;
    public final int length;
    public final Vertex vertexTo;
    public final Vertex vertexFrom;
    public final EdgeTraffic edgeTraffic;
    public int carsHandled = 0;


    public Edge(int eid, String name, int length, Vertex vertexTo, Vertex vertexFrom) {
        this.eid = eid;
        this.name = name;
        this.length = length;
        this.vertexTo = vertexTo;
        this.vertexFrom = vertexFrom;
        this.edgeTraffic = new EdgeTraffic();
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(o.carsHandled, this.carsHandled);
    }

    public void incrementCarsHandled() {
        carsHandled++;
    }
}
