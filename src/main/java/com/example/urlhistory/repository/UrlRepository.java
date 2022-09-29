package com.example.urlhistory.repository;

import com.example.urlhistory.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query(value = "SELECT * FROM url u WHERE u.account_name = :name", nativeQuery = true)
    List<Url> findUrlByName(@Param("name") String name);
}
