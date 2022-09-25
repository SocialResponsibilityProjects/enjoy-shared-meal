package com.srp.enjoysharedmeal.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.sound.midi.Receiver;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "feedback_time", updatable = false, nullable = false)
    private LocalDate feedbackTime;

    @Column(length = 500, nullable = false)
    private String comment;

    @Min(1)
    @Max(5)
    private int vote;

    @ManyToOne
    private Sharer sharer;

    @ManyToOne
    private Receiver receiver;

    @ManyToOne
    private Food food;
}
