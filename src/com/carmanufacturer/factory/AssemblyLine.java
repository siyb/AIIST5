package com.carmanufacturer.factory;

import com.carmanufacturer.factory.parts.*;
import com.carmanufacturer.factory.parts.engine.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * The assemblyline, this class is modeled after the builder pattern (https://en.wikipedia.org/wiki/Builder_pattern).
 * The idea of the builder pattern is based on SOC (Separation Of Concern), as it separates the construction of the car
 * from the car itself. If you think of it, this makes total sense, why should a car know how to assemble itself?
 *
 * The builder stores all components of the car that is under construction until it is actually build. The builder belongs
 * to the "creational patterns"
 */
public class AssemblyLine {

    /**
     * For now, our AssemblyLine only supports constructing cars with 4 wheels.
     */
    private int wheelCount = 4;

    /**
     * The name of the car that is currently being constructed
     */
    private String name;

    /**
     * The engine used by the car that is currently being constructed
     */
    private Engine engine;

    /**
     * The breaks used by the car that is currently being constructed
     */
    private Break wheelBreak;

    /**
     * The chassis used by the car that is currently being constructed
     */
    private Chassis chassis;

    /**
     * The exhaust used by the car that is currently being constructed
     */
    private Exhaust exhaust;

    /**
     * The transmission used by the car that is currently being constructed
     */
    private Transmission transmission;

    /**
     * The wheels used by the car that is currently being constructed
     */
    private List<Wheel> wheels;

    /**
     * Another pattern that is part of the "creational patterns" family, the factory method
     * (https://en.wikipedia.org/wiki/Factory_method_pattern). This pattern can be useful to construct default instances
     * without having to specify the constructor parameters or even know the concrete type of object that is being
     * constructed (we will come back to this concept later!)
     * @return A usable assembly line
     */
    public static AssemblyLine newAssemblyLine() {
        return new AssemblyLine();
    }

    /**
     * This factory method (https://en.wikipedia.org/wiki/Factory_method_pattern) creates a truck assembly line by
     * adjusting the number of wheels that can be added to a car.
     *
     * @return A usable track assembly line
     */
    public static AssemblyLine newTruckAssemblyLine() {
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.wheelCount = 8;
        return assemblyLine;
    }

    /**
     * This private methods checks if construction of a car has already been started by checking if the car's name has
     * been set
     * @return true if the construction has started, false otherwise
     */
    private boolean hasConstructionStarted() {
        return this.name != null;
    }

    /**
     * Start constructing a new car
     * @param name the name of the car
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine newCar(String name) {
        // explicitly throw a nullpointer when no name has been supplied, so that the hasConstructionStarted check is
        // always functional when a car is being constructed
        if (name == null) throw new NullPointerException();
        // check if the construction has started and throw an exception if it has
        if (hasConstructionStarted()) throw new IllegalStateException("Construction already started!");
        // instantiate the wheel list
        this.wheels = new ArrayList<>();
        // store the name of the car in this instance of the builder
        this.name = name;
        return this;
    }

    /**
     * Adds an {@link Engine} to the {@link AssemblyLine}
     * @param engine The {@link Engine} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine withEngine(Engine engine) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // store the engine of the car in this instance of the builder
        this.engine = engine;
        return this;
    }

    /**
     * Adds an {@link Break} to the {@link AssemblyLine}
     * @param wheelBreak The {@link Break} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine withWheelBreak(Break wheelBreak) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // store the wheel break of the car in this instance of the builder
        this.wheelBreak = wheelBreak;
        return this;
    }

    /**
     * Adds an {@link Chassis} to the {@link AssemblyLine}
     * @param chassis The {@link Chassis} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine withChassis(Chassis chassis) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // store the chassis of the car in this instance of the builder
        this.chassis = chassis;
        return this;
    }

    /**
     * Adds an {@link Exhaust} to the {@link AssemblyLine}
     * @param exhaust The {@link Exhaust} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine withExhaust(Exhaust exhaust) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // store the exhaust of the car in this instance of the builder
        this.exhaust = exhaust;
        return this;
    }

    /**
     * Adds an {@link Transmission} to the {@link AssemblyLine}
     * @param transmission The {@link Transmission} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine withTransmission(Transmission transmission) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // store the transmission of the car in this instance of the builder
        this.transmission = transmission;
        return this;
    }

    /**
     * Adds an {@link Wheel} to the {@link AssemblyLine}
     * @param wheel The {@link Wheel} to add
     * @return the instance of {@link AssemblyLine} that is used for construction, allowing chaining of methods
     */
    public AssemblyLine addWheel(Wheel wheel) {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // add new wheels to the car
        wheels.add(wheel);
        return this;
    }

    /**
     * Validates and buils the {@link Car}. We could have created a separate method that takes care of the validation as
     * well.
     * @return the constructed {@link Car}
     */
    public Car build() {
        // check if the construction has started and throw an exception if it has
        if (!hasConstructionStarted()) throw new IllegalStateException("Construction has not started yet!");
        // validate that the car can actually be assembled
        if (engine == null || wheelBreak == null || chassis == null ||
                exhaust == null || transmission == null || wheels.size() != wheelCount) {
            throw new RuntimeException("Some parts missing!");
        }
        // construct the car
        Car c = new Car(name, engine, wheelBreak, chassis, exhaust, transmission, wheels);

        // reset all parts so that this assembly line can construct another car!
        name = null;
        engine = null;
        wheelBreak = null;
        chassis = null;
        exhaust = null;
        transmission = null;
        wheels = null;

        // return the constructed car
        return c;
    }
}
