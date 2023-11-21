package org.example;

public class SmartStrategy implements OrderingStrategy {
    StringDrink drink;
    StringRecipe recipe;
    StringBar bar;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) {
            bar.order(drink, recipe);
        }
        else {
            this.drink = drink;
            this.recipe = recipe;
            this.bar = bar;
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        if(bar.isHappyHour() && this.bar == bar) {
            this.bar.order(this.drink, this.recipe);
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
