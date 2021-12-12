package com.carmanufacturer.factory.parts.engine;

/**
 * A standard combustion engine, might be obsolete soon! Uses inheritance to provide engine capabilities
 * (https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming))
 */
public class CombustionEngine extends Engine {
    @Override
    public void start() {
        System.out.println("Starting Combustion Engine!");
    }
}
