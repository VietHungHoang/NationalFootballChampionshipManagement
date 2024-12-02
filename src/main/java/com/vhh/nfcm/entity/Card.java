package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "player_participation_id")
    private PlayerParticipation playerParticipation;

    @OneToOne
    @JoinColumn(name = "foul_id")
    private Foul foul;
}
