package com.evobank.architecture.domain;

public final class IntegerMother {
    public static Integer random() {
        return MotherCreator.random().number().randomDigit();
    }
    public static Integer between(int min, int max) {
        return MotherCreator.random().number().numberBetween(min, max);
    }
}
