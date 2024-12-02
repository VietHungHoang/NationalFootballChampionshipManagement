package com.vhh.nfcm.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "player_participation")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean isMain;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @OneToMany(mappedBy = "playerParticipation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assist> assists;

    @OneToMany(mappedBy = "playerParticipation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals;

    @OneToMany(mappedBy = "playerParticipation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;

    @OneToMany(mappedBy = "playerParticipation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Foul> fouls;

    @OneToMany(mappedBy = "playerParticipation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerSubstitution> playerSubstitutions;
}