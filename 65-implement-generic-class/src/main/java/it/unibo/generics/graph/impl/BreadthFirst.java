package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.PathCalculatorBehavior;
import it.unibo.generics.graph.api.Graph;
import java.util.List;

public class BreadthFirst<N> implements PathCalculatorBehavior<N> {
    
    public List<N> getPath(N source, N target, Graph<N> graph){
        return null;
    }
}