package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "fouls")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Foul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private LocalDateTime time;

    @OneToOne(mappedBy = "foul", cascade = CascadeType.ALL)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "player_participation_id")
    private PlayerParticipation playerParticipation;
}
