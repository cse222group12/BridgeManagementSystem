package data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch<E> {
    private final Vertex<E> startVertex;

    public DepthFirstSearch(Vertex<E> startVertex) {
        this.startVertex = startVertex;
    }


    public void traverse(Vertex<E> startVertex){
        Deque<Vertex<E>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()){
            Vertex<E> current = stack.pop();
            if (!current.isVisited()){
                current.setVisited(true);
                System.out.println(current.getData());
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public void traverseRecursively(Vertex<E> vertex){
        vertex.setVisited(true);
        System.out.println(vertex.getData());
        vertex.getNeighbors().forEach(neighbor->{
            if(!neighbor.isVisited()){
                traverseRecursively(neighbor);
            }
        });
    }
}
