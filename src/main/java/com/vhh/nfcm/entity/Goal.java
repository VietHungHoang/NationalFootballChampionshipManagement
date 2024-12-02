package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "goals")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private LocalDateTime time;
    private String format;

    @OneToOne(mappedBy = "goal", cascade = CascadeType.ALL)
    private Assist assist;

    @ManyToOne
    @JoinColumn(name = "player_participation_id")
    private PlayerParticipation playerParticipation;
}

