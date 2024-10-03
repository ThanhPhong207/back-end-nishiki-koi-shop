package org.example.nishiki_koi_shop.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_tour_detail")
public class OrderTourDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderTourDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_tour_id", nullable = false)
    private OrderTour orderTour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    private Integer numberOfPeople;

    private long price;
}
