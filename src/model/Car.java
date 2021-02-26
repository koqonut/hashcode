package model;

import state.CarState;

import java.util.ArrayDeque;
import java.util.Deque;

public class Car {

    public final int cid;
    public boolean isWaiting = true;
    public final CarState state;

    public final int noOfVertices;

    public Deque<Edge> path = new ArrayDeque<>();

    public Car(int cid, Edge currentEdge, int noOfVertices) {
        this.cid = cid;
        state = new CarState(currentEdge, 0);
        this.noOfVertices = noOfVertices;
    }

    public void addPath(Edge e) {
        path.addLast(e);
    }

    public Edge removePath() {
        return path.removeFirst();
    }


}
