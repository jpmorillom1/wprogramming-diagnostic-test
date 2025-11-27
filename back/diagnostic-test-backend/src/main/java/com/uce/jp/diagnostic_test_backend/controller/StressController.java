package com.uce.jp.diagnostic_test_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stress")
public class StressController {

    @GetMapping("/cpu")
    public String stressCpu(){
        double result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += Math.sqrt(i);
        }
        return "result finished: " + result;
    }

}
