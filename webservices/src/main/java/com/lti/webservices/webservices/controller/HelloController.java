package com.lti.webservices.webservices.controller;

import com.lti.webservices.webservices.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloWorldBean helloWorldBean()
    {
        return  new HelloWorldBean("good morning sam");
    }

    @GetMapping("/hello/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name)
    {
       // return  new HelloWorldBean("good morning sam : "+name);
        return  new HelloWorldBean(String.format("good morning sam : %s ",name));

    }
}
