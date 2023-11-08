package org.example;

public class StringInverter implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        StringBuilder d = new StringBuilder(drink.getText());
        d.reverse();
        drink.setText(d.toString());
    }

    public void undo(StringDrink drink) {
        StringBuilder d = new StringBuilder(drink.getText());
        d.reverse();
        drink.setText(d.toString());
    }
}