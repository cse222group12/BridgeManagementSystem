package data_structures;


import java.util.LinkedList;
import java.util.List;

public class Vertex<E> {
    private final E data;
    private boolean visited;

    private List<Vertex<E>> neighbors = new LinkedList<>();


    public E getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(E data) {
        this.data = data;
    }

    public List<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex<E>> asList) {
        neighbors = asList;
    }

    @Override
    public String toString() {
        return (String)data;
    }
}
