package com.uce.jp.diagnostic_test_backend.repository;

import com.uce.jp.diagnostic_test_backend.entity.SearchHistory;
import com.uce.jp.diagnostic_test_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    List<User> findAll();



    boolean existsByName(String name);

}
