package com.lti.webservices.webservices.model;

public class HelloWorldBean {
    private  String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }
    public HelloWorldBean() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
