package com.lti.webservices.webservices.versioning;

public class Name {
    private String firstName;

    private String firstLast;

    public Name() {
    }

    public Name(String firstName, String firstLast) {
        this.firstName = firstName;
        this.firstLast = firstLast;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstLast() {
        return firstLast;
    }

    public void setFirstLast(String firstLast) {
        this.firstLast = firstLast;
    }
}
