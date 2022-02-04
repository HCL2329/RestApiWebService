package com.lti.webservices.webservices.controller;

import com.lti.webservices.webservices.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/helloInternationalized")
    public String helloWorldBeanInternationalized
            (@RequestHeader(name = "Accept-Language", required = false)Locale locale)
    {

       // return  messageSource.getMessage("good.morning.message",null,"Ser Gud",locale);
        return  messageSource.getMessage("good.morning.message",null,"Ser Gud", LocaleContextHolder.getLocale());

    }
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
