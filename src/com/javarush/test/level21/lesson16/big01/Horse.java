package com.javarush.test.level21.lesson16.big01;


public class Horse{

    private double distance;
    private double speed;
    private String name;

    public Horse (String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name) { this.name = name; }

    public void setSpeed(double speed) { this.speed = speed; }

    public void setDistance(double distance) { this.distance = distance; }

    public String getName() { return this.name; }

    public double getSpeed() {
        return this.speed;
    }

    public double getDistance() {
        return this.distance;
    }

    public void move(){
        distance += speed*Math.random();
    }
    public void print(){
        int dot = (int) this.distance;
        String dotLine = "";
        for (int i =0; i<dot; i++){
            dotLine = dotLine+".";
        }
        System.out.println(dotLine+this.getName());

    }

}
