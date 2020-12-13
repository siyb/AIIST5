package com.carmanufacturer.factory;

import com.carmanufacturer.factory.parts.Exhaust;
import com.carmanufacturer.factory.parts.Wheel;
import com.carmanufacturer.factory.parts.engine.HybridEngine;
import com.carmanufacturer.factory.parts.sport.SportBreak;
import com.carmanufacturer.factory.parts.sport.SportChassis;
import com.carmanufacturer.factory.parts.sport.SportTransmission;
import com.carmanufacturer.factory.parts.sport.SportWheel;

public class Main {
    public static void main(String[] args) {
        Car frankenCar = AssemblyLine
                .newAssemblyLine()
                .newCar("Model 1")
                .withChassis(new SportChassis())
                .withEngine(new HybridEngine())
                .withExhaust(new Exhaust())
                .withTransmission(new SportTransmission())
                .withWheelBreak(new SportBreak())
                .addWheel(new SportWheel())
                .addWheel(new SportWheel())
                .addWheel(new Wheel())
                .addWheel(new Wheel())
        .build();
    }
}
