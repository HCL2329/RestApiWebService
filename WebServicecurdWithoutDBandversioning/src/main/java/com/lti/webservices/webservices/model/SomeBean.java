package com.lti.webservices.webservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

//2nd way
@JsonIncludeProperties(value={"f1","f3"})
public class SomeBean {

    private String f1;
    private String f2;
    //1st way of filtering means hiding data
  //  @JsonIgnore
    private String f3;

    public SomeBean() {
    }

    public SomeBean(String f1, String f2, String f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }
}
