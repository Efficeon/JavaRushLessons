package com.javarush.test.level33.lesson05.home05;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property="className")
public class Parking {

    public String name;
    public String city;
    public List<Auto> autos;

    public Parking(String name, String city) {
        this.name = name;
        this.city = city;
    }
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property="className")
    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override

    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", autos=" + autos +
                '}';

    }

}