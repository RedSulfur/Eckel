package com.preparation.innerClasses;

interface Game {
    boolean move();
}

interface Factory {
    Game getGame();
}

class Checkers implements Game {

    private int moves = 0;
    private static final int MOVES = 3;

    private Checkers() {
    }

    public boolean move() {
        System.out.println("Checkers move: " + moves);
        return ++moves != MOVES;
    }

    public static Factory factory = new Factory() {
        public Game getGame() {
            return new Checkers();
        }
    };
}

class Chess implements Game {

    private int moves = 0;
    private static final int MOVES = 4;

    public Chess() {
    }

    public boolean move() {
        System.out.println("Chess moves: " + moves);
        return ++moves != MOVES;
    }

    public static Factory factory = new Factory() {
        public Game getGame() {
            return new Chess();
        }
    };
}

public class GameFactory {
    public static void playGame(Factory factory) {
        Game g = factory.getGame();
        while (g.move()) {
            ;
        }
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }

}
