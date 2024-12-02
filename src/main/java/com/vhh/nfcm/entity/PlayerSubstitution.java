package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_substitution")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerSubstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;

    @ManyToOne
    @JoinColumn(name = "player_participation_id")
    private PlayerParticipation playerParticipation;

    @ManyToOne
    @JoinColumn(name = "substitution_id")
    private Substitution substitution;
}