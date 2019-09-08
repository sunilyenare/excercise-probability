package com.thoughtworks.bootcamp.test;

public class Probability {
    private final float value;

    public Probability(float value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Probability)) {
            return false;
        }
        Probability that = (Probability) object;
        return this.value == that.value;
    }

    public Probability not() {
        return new Probability(1.0f - value);
    }

    public Probability and(Probability event) {
        return new Probability(value * event.value);
    }
    public Probability or(Probability event) {
        return new Probability(value).not().and(new Probability(event.value).not()).not();
    }
}
