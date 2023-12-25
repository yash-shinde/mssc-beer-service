package com.example.lcbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private String version;
    private BeerStyleEnum beerStyle;
    private OffsetDateTime createdDate;
    private OffsetDateTime modifyDate;
    private Long isn;
    private BigDecimal price;
    private Integer quantityOnHand;

}
