package com.lti.webservices.webservices.filter;

import com.lti.webservices.webservices.model.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filter")
    public List<SomeBean> retrieve(){
      //  return  new SomeBean("Dk","DKG","dkg");

        return Arrays.asList(new SomeBean("Dk", "DKG", "dkg"),
                new SomeBean("Sk", "SKG", "skg"),
                new SomeBean("Bk", "BKG", "bkg"));

    }
}
