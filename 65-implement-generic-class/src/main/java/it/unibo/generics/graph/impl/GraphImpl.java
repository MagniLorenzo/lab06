package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.PathCalculatorBehavior;

import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph;
    private PathCalculatorBehavior<N> pathCalculator;

    public GraphImpl() {
        this(new BreadthFirst<>());
    }

    public GraphImpl(final PathCalculatorBehavior<N> pathCalculatorBehavior) {
        this.graph = new HashMap<>();
        this.pathCalculator = pathCalculatorBehavior;
    }

    public void addNode(N node) {
        if (node != null) {
            this.graph.putIfAbsent(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
        if (graph.containsKey(source) && graph.containsKey(target)) {
            final Set<N> adjacencyList = this.graph.get(source);
            adjacencyList.add(target);
        }
    }

    public Set<N> nodeSet() {
        return new HashSet<>(graph.keySet());
    }

    public Set<N> linkedNodes(N node) {
        return this.graph.get(node);
    }

    /**
     * Gets one sequence of nodes connecting source to target.
     * 
     * @param source
     *               the source node
     * @param target
     *               the target node
     * @return a sequence of nodes connecting sources and target
     */
    public List<N> getPath(N source, N target) {
        if (graph.containsKey(source) && graph.containsKey(target)) {
            return pathCalculator.getPath(source, target, graph);
        } else {
            return Collections.emptyList();
        }
    }

}
