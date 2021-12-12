package com.carmanufacturer.factory.parts.engine;

/**
 * An electric engine, uses inheritance to provide engine capabilities
 * (https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming))
 */
public class ElectricEngine extends Engine {
    @Override
    public void start() {
        System.out.println("Starting Electric Engine!");
    }
}
