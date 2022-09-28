package com.example.urlhistory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @OneToMany(mappedBy = "account")
    private Set<UrlGroup> urlGroups;

    @OneToMany(mappedBy = "account")
    private Set<Url> urls;
}
