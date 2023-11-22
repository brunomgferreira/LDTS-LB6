package org.example;

public class RomulanClient extends AlienClient {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        OrderingStrategy strategy = new ImpatientStrategy();
        return strategy;
    }
}
