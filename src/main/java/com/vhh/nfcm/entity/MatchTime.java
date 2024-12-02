package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "match_times")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime time;
    private String description;
    @OneToMany(mappedBy = "matchTime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matches;
}
