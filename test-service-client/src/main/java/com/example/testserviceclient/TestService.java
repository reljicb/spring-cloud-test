package com.example.testserviceclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
    public String defaultTest() {
        return "default result";
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultTest")
    public String test() {
        String res = restTemplate.getForObject("http://localhost:8091/test", String.class);
        System.out.println("res=" + res);
        return res;
    }
}

