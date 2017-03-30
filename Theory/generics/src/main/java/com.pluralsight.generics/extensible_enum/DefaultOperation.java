package com.pluralsight.generics.extensible_enum;

public enum DefaultOperation implements Operation {

    MINUS("-") { public double apply(double x, double y) { return x - y; } },
    PLUS("+") { public double apply(double x, double y) { return x + y; }},
    TIMES("*") { public double apply(double x, double y) { return x * y; }},
    DEVIDE("/") { public double apply(double x, double y) { return x / y; }};

    private String symbol;

    DefaultOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
