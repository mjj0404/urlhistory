package com.example.urlhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UrlGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_group_id")
    private long id;

    @OneToMany(mappedBy = "urlGroup")
    private Set<Url> urls;

    @Column(name = "url_group_name")
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_url_group_id")
    private UrlGroup parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UrlGroup> childrenUrlGroup = new HashSet<>();

    @JsonIgnore
    public Set<UrlGroup> getChildrenUrlGroup() {
        return childrenUrlGroup;
    }

    @ManyToOne
    @JoinColumn(name = "account_name", nullable = false)
    private Account account;

}
