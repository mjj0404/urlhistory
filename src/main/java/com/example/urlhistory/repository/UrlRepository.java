package com.example.urlhistory.repository;

import com.example.urlhistory.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query(value = "SELECT * FROM url u WHERE u.account_name = :name", nativeQuery = true)
    List<Url> findUrlByName(@Param("name") String name);

    @Query(value = "SELECT * FROM url u WHERE u.account_name = :name AND u.is_expire NOT false ORDER BY u.created_at ASC", nativeQuery = true)
    List<Url> findUrlByNameOrderByCreatedAt(@Param("name") String name);
}
