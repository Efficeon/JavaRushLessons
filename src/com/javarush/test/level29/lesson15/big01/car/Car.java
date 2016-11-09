package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    /**заполненность бака*/
    public void fill(double numberOfLiters) throws Exception
    {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
    }

    /**расход поездки*/
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) return getSummerConsumption(length);

        else return getWinterConsumption(length);
    }

    /**определение лето или зима*/
    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        return (date.before(summerEnd) && date.after(summerStart));
    }

    /**потребление топлива зимой*/
    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    /**потребление топлива летом*/
    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    /**число пасажиров которые могут быть перевезены*/
    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred()) return 0;
        else return numberOfPassengers;
    }

    /**проверяет доступен ли водитель*/
    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    /**устанавливает доступного водителя*/
    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    /**старт движения автомобиля*/
    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) fastenPassengersBelts();
    }

    /**пристегнуть ремни безопасности пассажиров*/
    public void fastenPassengersBelts() {
    }

    /**пристегнуть ремни безопасности водителя*/
    public void fastenDriverBelt() {
    }

    /**максимальная скорость*/
    public abstract int getMaxSpeed();

    /**фабричный метод*/
    public static Car create(int type, int numberOfPassengers){
        switch (type) {
            case TRUCK: return new Truck(numberOfPassengers);
            case SEDAN: return new Sedan(numberOfPassengers);
            case CABRIOLET: return new Cabriolet(numberOfPassengers);
            default: return null;
        }
    }

    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() && fuel > 0;
    }
}
