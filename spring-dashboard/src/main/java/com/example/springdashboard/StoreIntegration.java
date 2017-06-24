package com.example.springdashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by bojanreljic on 24/06/17.
 */
@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return "empty stores";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "empty defaulStroes";
    }
}
