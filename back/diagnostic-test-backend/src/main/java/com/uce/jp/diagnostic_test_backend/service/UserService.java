package com.uce.jp.diagnostic_test_backend.service;


import com.uce.jp.diagnostic_test_backend.entity.User;
import com.uce.jp.diagnostic_test_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){

        if(!existsByName(user.getName())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        else {
            throw new RuntimeException("Nombre ya existe");
        }
    }


    public User findById(Long id){
        return userRepository.findById(id).orElseThrow();

    }

    public User findByName(String name){
        return userRepository.findByName(name).orElseThrow();

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }



    public void deleteUser(Long id){
      Optional<User> optionalUser= userRepository.findById(id);

      optionalUser.ifPresent(user -> {
          userRepository.deleteById(id);
      });

    }





    public     boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }



}
