package com.vhh.nfcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "assists")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Assist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private LocalDateTime time;

    private String format;



//    @OneToOne(mappedBy = "assist", cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
}