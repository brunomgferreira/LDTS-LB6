package org.example;

public class StringReplacer implements StringTransformer {
    private char charToReplace;
    private char newChar;

    public StringReplacer(char a, char x) {
        this.charToReplace = a;
        this.newChar = x;
    }

    @Override
    public void execute(StringDrink drink) {
        StringBuilder modifiedText = new StringBuilder();
        for(char c : drink.getText().toCharArray()) {
            if(c == charToReplace) modifiedText.append(newChar);
            else modifiedText.append(c);
        }
        drink.setText(modifiedText.toString());
    }

    public void undo(StringDrink drink) {
        StringBuilder modifiedText = new StringBuilder();
        for(char c : drink.getText().toCharArray()) {
            if(c == newChar) modifiedText.append(charToReplace);
            else modifiedText.append(c);
        }
        drink.setText(modifiedText.toString());
    }
}
