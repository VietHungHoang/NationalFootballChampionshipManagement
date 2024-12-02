package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "substitutions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Substitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reason;
    private LocalDateTime time;

    @OneToMany(mappedBy = "substitution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerSubstitution> playerSubstitutions;
}