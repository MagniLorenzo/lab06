package it.unibo.generics.graph.api;

import java.util.List;

public interface PathCalculatorBehavior<N> {

    public List<N> getPath(N source, N target, Graph<N> graph);
    
}