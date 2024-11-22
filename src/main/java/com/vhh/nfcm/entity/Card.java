package com.vhh.nfcm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
}
