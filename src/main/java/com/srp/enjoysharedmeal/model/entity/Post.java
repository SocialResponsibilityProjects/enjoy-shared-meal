package com.srp.enjoysharedmeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

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

    @Column(length = 600)
    private String details;

    @OneToOne
    @Column(nullable = false)
    private Food food;

    @OneToOne
    @Column(nullable = false)
    private User sharedBy;

    @OneToOne
    @Column(nullable = false)
    private Location sharedFrom;

    @OneToMany
    private List<Feedback> feedbacks;

}
