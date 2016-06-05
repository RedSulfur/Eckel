package com.preparation.algorithms;


import java.util.*;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            pq.offer(random.nextInt(10 + i));
        }
        Queue351.printQ(pq);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        pq = new PriorityQueue<Integer>(list);
        Queue351.printQ(pq);

        pq = new PriorityQueue<Integer>(list.size(), Collections.reverseOrder());
        pq.addAll(list);
        Queue351.printQ(pq);

        String fact = "GENTLY MY MIND ESCAPES INTO RELAXING MODE OF PLEASURE";
        List<String> strings = Arrays.asList(fact.split(""));

        PriorityQueue<String> pqs = new PriorityQueue<String>(strings);
        Queue351.printQ(pqs);

        pqs = new PriorityQueue<String>(list.size(), Collections.reverseOrder());
        pqs.addAll(strings);
        Queue351.printQ(pqs);

        Set<Character> characters = new HashSet<Character>();
        for (char c :
                fact.toCharArray()) {
            characters.add(c);
        }

        PriorityQueue<Character> pqc = new PriorityQueue<Character>(characters);
        Queue351.printQ(pqc);
    }
}
