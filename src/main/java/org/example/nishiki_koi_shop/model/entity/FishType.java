package org.example.nishiki_koi_shop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "fish_types")
public class FishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fishTypeId;

    private String name;
    private String description;
    private LocalDate deletedAt;

    @OneToMany(mappedBy = "fishType")
    private List<Fish> fish;

}
