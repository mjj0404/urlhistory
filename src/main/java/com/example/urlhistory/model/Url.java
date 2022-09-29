package com.example.urlhistory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visited_at")
    private Date visitedAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expire_at")
    private Date expireAt;
    @Column(name = "is_expire")
    private boolean isExpire;
    @Column(name = "visit_count")
    private Long visitCount;
    @Column(name = "rating", nullable = true)
    private Long rating;

    @ManyToOne
    @JoinColumn(name = "url_group_id", nullable = true)
    private UrlGroup urlGroup;

    @ManyToOne
    @JoinColumn(name = "account_name", nullable = false)
    private Account account;
}
