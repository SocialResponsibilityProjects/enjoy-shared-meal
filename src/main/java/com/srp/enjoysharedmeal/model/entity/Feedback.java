package com.srp.enjoysharedmeal.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.srp.enjoysharedmeal.model.base.BaseEntity;
import com.srp.enjoysharedmeal.model.enums.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.sound.midi.Receiver;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity {

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "feedback_time", updatable = false, nullable = false)
    private LocalDateTime feedbackTime;

    @Column(length = 500, nullable = false)
    private String comment;

    @Enumerated
    private Vote vote;

    @ManyToOne
    private Sharer sharer;

    @ManyToOne
    private Receiver receiver;

    @ManyToOne
    private Food food;
}
