package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> aList = new ArrayList<>(1000);
        for (int i = 1000; i < 2000; i++) {
            aList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> lList = new LinkedList<>(aList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer tmp = aList.get(0);
        aList.set(0, aList.get(aList.size() - 1));
        aList.set(aList.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("Contenuto di ArrayList: [");
        for (final Integer elem : aList) {
            System.out.print(elem + ", ");
        }
        System.out.println("]");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = calculateTimePerInsertion(aList, 100000, 0);
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Inserire 100000 elementi in un AllayList ha richiesto " + time + "ns (" + millis + "ms)");

        time = calculateTimePerInsertion(lList, 100000, 0);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Inserire 100000 elementi in una LinkedList ha richiesto " + time + "ns (" + millis + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = calculateTimePerReading(aList, 1000, aList.size() / 2);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Leggere 1000 volte l'elemte centrale in un ArrayList con " + aList.size() + " ha richiesto "
                + time + "ns (" + millis + "ms)");

        time = calculateTimePerReading(lList, 1000, lList.size() / 2);
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Leggere 1000 volte l'elemte centrale in una LinkedList con " + lList.size() + " ha richiesto "
                        + time + "ns (" + millis + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> worldMap = new HashMap<>();
        worldMap.put("Africa", Long.valueOf(1110635000));
        worldMap.put("Americas", Long.valueOf(972005000));
        worldMap.put("Antartica", Long.valueOf(0));
        worldMap.put("Asia", Long.valueOf(4298723000L));
        worldMap.put("Europe", Long.valueOf(742452000));
        worldMap.put("Oceania", Long.valueOf(38304000));

        /*
         * 8) Compute the population of the world
         */

        long worldPopulation = 0;
        for (final Long num : worldMap.values()) {
            worldPopulation += num;
        }
        System.out.println("La popolazione mondiale è: " + worldPopulation);
    }

    private static long calculateTimePerInsertion(final List<Integer> coll, int nElem, int pos) {
        long time = System.nanoTime();
        for (int i = 0; i < nElem; i++) {
            coll.add(pos, i);
        }
        return System.nanoTime() - time;
    }

    private static long calculateTimePerReading(final List<Integer> coll, int nReading, int pos) {
        long time = System.nanoTime();
        for (int i = 0; i < nReading; i++) {
            coll.get(pos);
        }
        return System.nanoTime() - time;
    }
}
