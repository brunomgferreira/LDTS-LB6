package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringTransformerGroupTest {
    @Test
    public void transformerGroup() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        StringTransformerGroup tg = new
                StringTransformerGroup(transformers);
        tg.execute(drink);
        assertEquals("dCbA-DcBa", drink.getText());
    }

    @Test
    public void transformerComposite() {
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new
                StringTransformerGroup(transformers1);
        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new
                StringTransformerGroup(transformers2);
        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);
        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix(drink);
        assertEquals("DcBx-dCbA", drink.getText());
    }

    @Test
    public void addObserver() {
        Bar bar = new StringBar();
        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourEnded(bar);
        bar.startHappyHour();
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourEnded(bar);
        bar.endHappyHour();
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourEnded(bar);
    }
    @Test
    public void removeObserver() {
        Bar bar = new StringBar();
        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        bar.removeObserver(clientMock);
        bar.startHappyHour();
        bar.endHappyHour();
    }
}