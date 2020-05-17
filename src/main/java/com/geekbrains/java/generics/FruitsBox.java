package com.geekbrains.java.generics;

import java.util.ArrayList;
import java.util.List;

public class FruitsBox<F extends Fruit> {
    private List<F> container = new ArrayList<>();

    void put(F fruit) {
        container.add(fruit);
    }

    public void putAll(FruitsBox<F> anotherBox) {
        container.addAll(anotherBox.popAll());
    }

    public List<F> popAll() {
        List<F> copy = new ArrayList<>(container);
        container.clear();
        return copy;
    }

    public Double getWeight() {
        Double total = 0.;
        for (F fruit : container) {
            total += fruit.getWeight();
        }
        return total;
    }

    public Boolean compare(FruitsBox<?> anotherBox) {
        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.0001;
    }
}
