package com.example.urlhistory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private long id;



    @Column(name = "url_name")
    private String urlName;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "visited_at")
    private Timestamp visitedAt;
    @UpdateTimestamp
    @Column(name = "expire_at")
    private Timestamp expireAt;
    @Column(name = "days_to_expire")
    private long daysToExpire;
    @Column(name = "visit_count")
    private long visitCount;


    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private UrlGroup urlGroup;

    @ManyToOne
    @JoinColumn(name = "account_name", nullable = false)
    private Account account;

    private long ratingId;
}
