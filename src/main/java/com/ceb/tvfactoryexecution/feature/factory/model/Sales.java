package com.ceb.tvfactoryexecution.feature.factory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @Column(name = "tv_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "tv_id")
    private TvProduction tvProduction;

    @Column
    private int price;

    @Column
    private String soldBy;
}
