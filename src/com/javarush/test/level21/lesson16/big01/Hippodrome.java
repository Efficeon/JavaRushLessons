package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
    game = new Hippodrome();
        Horse Garret = new Horse("Garret", 3, 0);
        Horse Richard = new Horse("Richard", 3, 0);
        Horse Blecky = new Horse("Blecky", 3, 0);

        game.horses.add(Garret);
        game.horses.add(Richard);
        game.horses.add(Blecky);

        game.run();

        game.printWinner();
    }

    private static ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses(){ return horses; }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse h : horses){
            h.move();
        }
    }
    public void print() {
        for (Horse h : this.horses) {
            h.print();
        }

        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        Horse winner = horses.get(0);
        for (Horse w : horses){
            if (w.getDistance()>winner.getDistance()) winner=w;
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }
}
