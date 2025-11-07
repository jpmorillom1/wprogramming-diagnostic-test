package com.uce.jp.diagnostic_test_backend.repository;

import com.uce.jp.diagnostic_test_backend.entity.SearchHistory;
import com.uce.jp.diagnostic_test_backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchHistoryRepository extends CrudRepository<SearchHistory,Long> {

    List<SearchHistory> findByUserOrderBySearchDateDesc(User user);



}
