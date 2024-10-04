package org.example.nishiki_koi_shop.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedBackId;

    private String comment;
    private LocalDate createdDate;
    private LocalDate deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour; // Tham chiếu đến tour nếu phản hồi liên quan đến tour

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_id")
    private Fish fish;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    public enum Rating {
        EXCELLENT, GOOD, AVERAGE, POOR, VERY_POOR
    }
}
