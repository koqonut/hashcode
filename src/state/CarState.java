package state;

import model.Edge;

public class CarState {
    public boolean isWaiting = true;
    public Edge currentEdge;
    public int disToTravel;

    public CarState(Edge currentEdge, int disToTravel) {
        this.currentEdge = currentEdge;
        this.disToTravel = disToTravel;
    }

    public int distTravelled() {
        return currentEdge.length - disToTravel;
    }
}
