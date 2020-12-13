package com.carmanufacturer.factory;

import com.carmanufacturer.factory.parts.*;
import com.carmanufacturer.factory.parts.engine.Engine;

import java.util.List;

public class Car {
    private String name;

    private Engine engine;

    private Break wheelBreak;
    private Chassis chassis;
    private Exhaust exhaust;

    private Transmission transmission;

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
