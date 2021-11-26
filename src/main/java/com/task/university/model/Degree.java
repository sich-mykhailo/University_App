package com.task.university.model;

public enum Degree {
    ASSOCIATE_PROFESSOR("associate professor"),
    ASSISTANT("assistant"),
    PROFESSOR("professor");

    private final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

    public String getValue() {
        return degree;
    }
}
