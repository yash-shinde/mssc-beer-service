package com.example.lcbeerservice.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
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
    @Null
    private String version;
    @NotNull
    private BeerStyleEnum beerStyle;

    @NotBlank
    private String beerName;

    @Positive
    @NotNull
    private Long upc;

    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;

    private Long isn;

    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;

}
