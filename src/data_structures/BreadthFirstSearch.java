package data_structures;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<E> {
    private final Vertex<E> startVertex;

    public BreadthFirstSearch(Vertex<E> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse(){
        Queue<Vertex<E>> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()){
            Vertex<E> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.getData());
                queue.addAll(current.getNeighbors());
            }
        }
    }
}
