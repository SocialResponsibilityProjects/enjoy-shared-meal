package com.srp.enjoysharedmeal.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Min(1)
    private int counter;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "food_sharing_time", updatable = false, nullable = false)
    private LocalDateTime foodSharingTime;

    @ManyToOne
    private Sharer sharer;

    //    private List<Feedback> feedbacks;
    //    private List<Receiver> receivers;
}
