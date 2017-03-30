package com.pluralsight.generics.extensible_enum;

public enum ExtendedOperation implements Operation {

    POWER("^") { public double apply(double x, double y) { return Math.pow(x, y); }},
    MOD("%") { public double apply(double x, double y) { return x % y; }};

    private String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
