package com.thoughtworks.bootcamp.test;

public class StatisticProbability {
    private final float probabilityValue;

    public StatisticProbability(float probabilityValue) {
        this.probabilityValue = probabilityValue;
    }

    @Override
    public int hashCode() {

        return (int) probabilityValue;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        return this.hashCode()==obj.hashCode();

    }
}
