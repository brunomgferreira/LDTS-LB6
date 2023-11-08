package org.example;

public class HumanClient implements Client {
    @Override
    public void happyHourStarted(Bar bar) {
        bar.startHappyHour();
    }

    @Override
    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }
}
