package com.uce.jp.diagnostic_test_backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class StudentsController {

    private static final Map<Long, Map<String, Object>> students = new HashMap<>();

    static {
        students.put(1L, Map.of("id", 1L, "firstName", "Luis Gonzalo", "lastName", "Achig Carcelen", "age", 24));
        students.put(2L, Map.of("id", 2L, "firstName", "Jessiel Josue", "lastName", "Chasiguano Santin", "age", 22));
        students.put(3L, Map.of("id", 3L, "firstName", "Bryan Fabricio", "lastName", "Chileno Agualongo", "age", 23));
        students.put(4L, Map.of("id", 4L, "firstName", "Kleber Alejandro", "lastName", "Chiliquinga Lara", "age", 25));
        students.put(5L, Map.of("id", 5L, "firstName", "Kenny Israel", "lastName", "Cisneros Calderon", "age", 22));
        students.put(6L, Map.of("id", 6L, "firstName", "Davinson Mayer", "lastName", "Diaz Tapia", "age", 24));
        students.put(7L, Map.of("id", 7L, "firstName", "Juan Pablo", "lastName", "Morillo Macias", "age", 23));
        students.put(8L, Map.of("id", 8L, "firstName", "Gissela Dayana", "lastName", "Muzo Anchapaxi", "age", 21));
        students.put(9L, Map.of("id", 9L, "firstName", "Abel Eduardo", "lastName", "Navarrete Giler", "age", 25));
        students.put(10L, Map.of("id", 10L, "firstName", "Liz Daisy", "lastName", "Pillajo Cabrera", "age", 20));
        students.put(11L, Map.of("id", 11L, "firstName", "Joseph Alexander", "lastName", "Ponce Naranjo", "age", 24));
        students.put(12L, Map.of("id", 12L, "firstName", "Rodrigo Javier", "lastName", "Saransig Briones", "age", 23));
        students.put(13L, Map.of("id", 13L, "firstName", "Alex Armando", "lastName", "Tituana Ushina", "age", 22));
        students.put(14L, Map.of("id", 14L, "firstName", "Jonathan Rolando", "lastName", "Villarreal Cardenas", "age", 25));
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){
        Map<String, Object> student = students.get(id);

        if (student == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Student not found"));
        }

        return ResponseEntity.ok(student);
    }
}