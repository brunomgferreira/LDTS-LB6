package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {

    public StringBar() {
        isHappyHour = false;
        observers = new ArrayList<>();
    }

    @Override
    public boolean isHappyHour() {
        return isHappyHour;
    }

    @Override
    public void startHappyHour() {
        isHappyHour = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        isHappyHour = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }

}
