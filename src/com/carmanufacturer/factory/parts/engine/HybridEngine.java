package com.carmanufacturer.factory.parts.engine;

import com.carmanufacturer.factory.Car;

/**
 * A hybrid engine, uses inheritance (https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming))
 * and composition (https://en.wikipedia.org/wiki/Object_composition) to provide an engine. See also:
 * https://en.wikipedia.org/wiki/Composition_over_inheritance
 */
public class HybridEngine extends Engine {
    /**
     * This instance of {@link ElectricEngine} moves the {@link Car} when in electrical mode
     */
    private final ElectricEngine electricEngine = new ElectricEngine();
    /**
     * This instance of {@link ElectricEngine} moves the {@link Car} when in combustion mode
     */
    private final CombustionEngine combustionEngine = new CombustionEngine();

    /**
     * Starts both {@link Engine}s. Uses composition to start the engine
     */
    @Override
    public void start() {
        // start the electric engine
        electricEngine.start();
        // start the combustion engine
        combustionEngine.start();
    }
}
