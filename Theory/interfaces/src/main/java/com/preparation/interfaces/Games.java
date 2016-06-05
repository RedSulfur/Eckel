package com.preparation.interfaces;

/**
 * Created by sulfur on 05.04.16.
 */

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame(String g);
}

class FactoryPattern implements GameFactory {
    public Game getGame(String g) {
        if (g == null) {
            return null;
        }
        if(g.equalsIgnoreCase("Checkers")) return new Checkers();
        else if (g.equalsIgnoreCase("Chess")) return new Chess();
        return null;
    }
}

class Checkers implements Game {
    private int moves = 0;
    private static int MOVES = 3;
    public boolean move() {
            System.out.println("Checkers move " + moves);
            return ++moves != MOVES;
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    public boolean move() {
        System.out.println("Chess moe " + moves);
        return ++moves != MOVES;
    }
}

public class Games {

    public static void playGame (Game g) {
        while (g.move())
            ;
    }

    /*
    In Factory pattern, we create object without exposing the
    creation logic to the client and refer to newly created object
    using a common interface.
    */

    public static void main(String[] args) {
        FactoryPattern games = new FactoryPattern();
        playGame(games.getGame("CHECKERS"));
        playGame(games.getGame("CHESS"));
    }

}
