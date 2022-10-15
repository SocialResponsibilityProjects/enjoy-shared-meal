package com.srp.enjoysharedmeal.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srp.enjoysharedmeal.model.type.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String details;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Food> foods = new HashSet<>();

    @ElementCollection
    @Column(nullable = false)
    private List<String> photos;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User sharedBy;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private Location location;

    @OneToMany
    private List<Feedback> feedbacks;

}
