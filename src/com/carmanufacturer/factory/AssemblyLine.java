package com.carmanufacturer.factory;

import com.carmanufacturer.factory.parts.*;
import com.carmanufacturer.factory.parts.engine.Engine;

import java.util.ArrayList;
import java.util.List;

public class AssemblyLine {

    private int wheelCount = 4;

    private String name;

    private Engine engine;

    private Break wheelBreak;
    private Chassis chassis;
    private Exhaust exhaust;

    private Transmission transmission;

    private List<Wheel> wheels;

    public static AssemblyLine newAssemblyLine() {
        return new AssemblyLine();
    }

    public static AssemblyLine newTruckAssemblyLine() {
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.wheelCount = 8;
        return assemblyLine;
    }

    private boolean hasConstructionStarted() {
        return this.name != null;
    }

    public AssemblyLine newCar(String name) {
        if (name == null) throw new NullPointerException();
        if (hasConstructionStarted()) throw new IllegalStateException("Construction already started!");
        this.wheels = new ArrayList<>();
        this.name = name;
        return this;
    }

    public AssemblyLine withEngine(Engine engine) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        this.engine = engine;
        return this;
    }

    public AssemblyLine withWheelBreak(Break wheelBreak) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        this.wheelBreak = wheelBreak;
        return this;
    }

    public AssemblyLine withChassis(Chassis chassis) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        this.chassis = chassis;
        return this;
    }

    public AssemblyLine withExhaust(Exhaust exhaust) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        this.exhaust = exhaust;
        return this;
    }

    public AssemblyLine withTransmission(Transmission transmission) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        this.transmission = transmission;
        return this;
    }

    public AssemblyLine addWheel(Wheel wheel) {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        wheels.add(wheel);
        return this;
    }

    public Car build() {
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        if (engine == null || wheelBreak == null || chassis == null ||
                exhaust == null || transmission == null || wheels.size() != wheelCount) {
            throw new RuntimeException("Some parts missing!");
        }
        Car c = new Car(name, engine, wheelBreak, chassis, exhaust, transmission, wheels);
        name = null;
        engine = null;
        wheelBreak = null;
        chassis = null;
        exhaust = null;
        transmission = null;
        wheels = null;
        return c;
    }
}
