package it.unibo.generics.graph.api;

import java.util.List;

public interface GetPathBehavior<N> {

    public List<N> getPath(N source, N target, Graph<N> graph);
    
}