package org.example;

public class FerengiClient extends AlienClient {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        OrderingStrategy strategy = new SmartStrategy();
        return strategy;
    }
}
