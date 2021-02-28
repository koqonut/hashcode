package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    public final int vid;
    public List<Edge> incoming;
    public List<Edge> outgoing;

    public Vertex(int vid) {
        this.vid = vid;
        incoming = new ArrayList<>();
        outgoing = new ArrayList<>();
    }

    public void addOutgoingEdge(Edge e) {
        outgoing.add(e);
    }

    public void addIncomingEdge(Edge e) {
        incoming.add(e);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return vid == vertex.vid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid);
    }

    @Override
    public int compareTo(Vertex o) {
        int count = 0;
        for (Edge e : incoming) {
            count += e.carsHandled;
        }

        int count1 = 0;
        for (Edge e : o.incoming) {
            count1 += e.carsHandled;
        }

        return Integer.compare(count1, count);
    }
}
