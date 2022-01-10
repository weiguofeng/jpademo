package com.llbt.jpademo.optional;

public class Girl {

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
