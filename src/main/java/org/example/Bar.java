package org.example;

import java.util.ArrayList;
import java.util.List;

abstract public class Bar {

    List<BarObserver> observers;
    boolean isHappyHour;

    public Bar() {
        isHappyHour = false;
        observers = new ArrayList<>();
    }

    abstract public boolean isHappyHour();

    abstract public void startHappyHour();

    abstract public void endHappyHour();

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers) {
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
        }
    }
}
