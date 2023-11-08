package org.example;

public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        StringBuilder modifiedText = new StringBuilder();
        for(char c : drink.getText().toCharArray()) {
            if(Character.isLowerCase(c)) modifiedText.append(Character.toUpperCase(c));
            else modifiedText.append(Character.toLowerCase(c));
        }
        drink.setText(modifiedText.toString());
    }

    public void undo(StringDrink drink) {
        StringBuilder modifiedText = new StringBuilder();
        for(char c : drink.getText().toCharArray()) {
            if(Character.isLowerCase(c)) modifiedText.append(Character.toUpperCase(c));
            else modifiedText.append(Character.toLowerCase(c));
        }
        drink.setText(modifiedText.toString());
    }
}
