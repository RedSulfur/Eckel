package com.preparation.collections;


import java.util.PriorityQueue;

public class todoList extends PriorityQueue<todoList.todoItem>{

    public static class todoItem implements Comparable<todoItem>{

        private String desc;
        private char firstPrior;
        private int secPrior;

        public todoItem(String desc, char firstPrior, int secPrior) {
            this.desc = desc;
            this.firstPrior = firstPrior;
            this.secPrior = secPrior;
        }

        @Override
        public int compareTo(todoItem o) {

            if (firstPrior > o.firstPrior) {
                return +1;
            }
            if (firstPrior == o.firstPrior) {
                if (secPrior > o.secPrior) {
                    return +1;
                } else if (secPrior == o.secPrior)
                    return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(firstPrior) +
                    secPrior;
        }

    }
    public void add(String desc, char firstPrior, int secPrior) {
        super.add(new todoItem(desc,firstPrior,secPrior));
    }


    public static void main(String[] args) {

        todoList todoItems = new todoList();

        todoItems.add("Emty trash", 'A', 2);
        todoItems.add("Feed dog", 'A', 1);
        todoItems.add("Koursach", 'C', 2);
        todoItems.add("Gym", 'C', 1);
        todoItems.add("To eat", 'B', 2);
        todoItems.add("Play guitar", 'B', 1);

        while (todoItems.peek() != null) {
            System.out.println(todoItems.remove());
        }

    }
}
