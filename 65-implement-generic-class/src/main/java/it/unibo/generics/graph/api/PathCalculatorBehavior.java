package it.unibo.generics.graph.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PathCalculatorBehavior<N> {

    List<N> getPath(N source, N target, Map<N, Set<N>> graph);
    
}