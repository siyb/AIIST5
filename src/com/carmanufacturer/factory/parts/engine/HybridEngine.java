package com.carmanufacturer.factory.parts.engine;

public class HybridEngine extends Engine {
    private final ElectricEngine electricEngine = new ElectricEngine();
    private final CombustionEngine combustionEngine = new CombustionEngine();

    @Override
    public void start() {
        electricEngine.start();
        combustionEngine.start();
    }
}
