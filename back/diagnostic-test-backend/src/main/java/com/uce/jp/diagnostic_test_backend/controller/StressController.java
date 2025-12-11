package com.uce.jp.diagnostic_test_backend.controller;

import com.uce.jp.diagnostic_test_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping("/stress")
public class StressController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/cpu")
    public String stressCpu() {
        System.out.println("Initializing cpu stress process");
        double result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += Math.sqrt(i);
        }
        return "strees test result: " + result;
    }

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello world!";
    }


    @GetMapping("/list")
    public ResponseEntity<?> getUsers(){

        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
