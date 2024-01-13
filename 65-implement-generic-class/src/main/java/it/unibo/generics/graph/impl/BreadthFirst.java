package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.PathCalculatorBehavior;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirst<N> implements PathCalculatorBehavior<N> {

    private static final Integer WHITE = 0;
    private static final Integer BLACK = 1;
    private static final Integer GRAY = 2;

    public List<N> getPath(N source, N target, Map<N, Set<N>> graph) {
        final Map<N, Integer> depth = new HashMap<>(graph.size());
        final Map<N, N> father = new HashMap<>(graph.size());
        final Map<N, Integer> color = new HashMap<>(graph.size());
        for (final N key : graph.keySet()) {
            depth.put(key, 0);
            father.put(key, null);
            color.put(key, WHITE);
        }
        depth.put(source, 0);
        father.put(source, null);
        color.put(source, GRAY);
        final Queue<N> coda = new LinkedList<>();
        coda.add(source);
        while (!coda.isEmpty()) {
            final N actualNode = coda.poll();
            for (final N node : graph.get(actualNode)) {
                if (color.get(node) == WHITE) {
                    color.put(node, GRAY);
                    depth.put(node, depth.get(actualNode) + 1);
                    father.put(node, actualNode);
                    coda.add(node);
                }
            }
            color.put(actualNode, BLACK);
        }
        final List<N> result = new LinkedList<>();
        N tmpPointer = target;
        while (tmpPointer != null) {
            result.add(0, tmpPointer);
            tmpPointer = father.get(tmpPointer);
        }
        return result;
    }
}