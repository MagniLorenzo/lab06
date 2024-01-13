package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.PathCalculatorBehavior;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedList;

public class DepthFirst<N> implements PathCalculatorBehavior<N> {

    private static final Integer WHITE = 0;
    private static final Integer BLACK = 1;
    private static final Integer GRAY = 2;
    private Map<N, N> father;
    private Map<N, Integer> color;

    public List<N> getPath(final N source, final N target, final Map<N, Set<N>> graph) {
        this.father = new HashMap<>(graph.size());
        this.color = new HashMap<>(graph.size());
        for (final N key : graph.keySet()) {
            father.put(key, null);
            color.put(key, WHITE);
        }
        for (final N key : graph.keySet()) {
            if (color.get(key) == WHITE) {
                dfsVisit(graph, source);
            }
        }

        final List<N> result = new LinkedList<>();
        N tmpPointer = target;
        while (tmpPointer != null) {
            result.add(0, tmpPointer);
            tmpPointer = father.get(tmpPointer);
        }
        return result;
    }

    private void dfsVisit(final Map<N, Set<N>> graph, final N actualNode) {
        color.put(actualNode, GRAY);
        for (final N adjacentNode : graph.get(actualNode)) {
            if (color.get(adjacentNode) == WHITE) {
                father.put(adjacentNode, actualNode);
                dfsVisit(graph, adjacentNode);
            }
        }
        color.put(actualNode, BLACK);
    }
}