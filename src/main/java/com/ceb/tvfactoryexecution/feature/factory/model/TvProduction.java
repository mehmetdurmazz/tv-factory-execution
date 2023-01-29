package com.ceb.tvfactoryexecution.feature.factory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tv_production")
public class TvProduction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private UUID panelBarcode;

    @Column
    private UUID mainBoardBarcode;

    @Column
    private String assembledBy;

    @OneToOne(mappedBy = "tvProduction", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Sales sales;
}
