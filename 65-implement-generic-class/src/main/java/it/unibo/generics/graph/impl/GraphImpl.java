package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph;
    private static final Integer WHITE = 0;
    private static final Integer BLACK = 1;
    private static final Integer GRAY = 2;

    public GraphImpl() {
        this.graph = new HashMap<>();
    }

    public void addNode(N node) {
        if (node != null) {
            this.graph.put(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            final Set<N> adjacencyList = this.graph.get(source);
            adjacencyList.add(target);
        }
    }

    public Set<N> nodeSet() {
        return this.graph.keySet();
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
        final Map<N, Integer> depth = new HashMap<>();
        final Map<N, N> father = new HashMap<>(this.graph.size());
        final Map<N, Integer> color = new HashMap<>(this.graph.size());
        for (final N key : this.graph.keySet()) {
            depth.put(key, 0);
            father.put(key, null);
            color.put(key, WHITE);
        }
        depth.put(source, 0);
        father.put(source, null);
        color.put(source, GRAY);
        final Queue<N> coda = new LinkedList<>();
        // TODO 
    }
}
