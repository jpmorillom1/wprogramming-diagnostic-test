package com.uce.jp.diagnostic_test_backend.controller;


import com.uce.jp.diagnostic_test_backend.dto.SearchHistoryDTO;
import com.uce.jp.diagnostic_test_backend.entity.SearchHistory;
import com.uce.jp.diagnostic_test_backend.entity.User;
import com.uce.jp.diagnostic_test_backend.service.SearchHistoryService;
import com.uce.jp.diagnostic_test_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SearchHistoryService searchHistoryService;


    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user= userService.findById(id);
        return ResponseEntity.ok().body(user);
    }


    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @GetMapping("/history")
    public ResponseEntity<List<SearchHistoryDTO>> getUserSearchHistory() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<SearchHistoryDTO> history = searchHistoryService.getUserSearchHistory(username);
        return ResponseEntity.ok(history);
    }


}
