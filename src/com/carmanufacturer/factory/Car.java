package com.carmanufacturer.factory;

import com.carmanufacturer.factory.parts.*;
import com.carmanufacturer.factory.parts.engine.Engine;

import java.util.List;

/**
 * This class represents a typical car
 */
public class Car {
    /**
     * The name of the car
     */
    private String name;

    /**
     * The instance of the engine that is powering the car
     */
    private Engine engine;

    /**
     * The breaks used in this car
     */
    private Break wheelBreak;

    /**
     * The chassis of the car
     */
    private Chassis chassis;

    /**
     * The car's exhaust
     */
    private Exhaust exhaust;

    /**
     * The car's transmission
     */
    private Transmission transmission;

    /**
     * A list of wheels, we could also declare four instances of wheels here but then we would limit the car to a certain
     * amount of wheels
     */
    private List<Wheel> wheels;

    public Car(String name, Engine engine, Break wheelBreak, Chassis chassis, Exhaust exhaust, Transmission transmission, List<Wheel> wheels) {
        this.name = name;
        this.engine = engine;
        this.wheelBreak = wheelBreak;
        this.chassis = chassis;
        this.exhaust = exhaust;
        this.transmission = transmission;
        this.wheels = wheels;
    }
}
