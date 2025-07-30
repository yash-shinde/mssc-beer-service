package com.example.lcbeerservice.web.mappers;

import com.example.lcbeerservice.domain.Beer;
import com.example.lcbeerservice.web.model.BeerDto;
import com.example.lcbeerservice.web.model.BeerStyleEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class BeerMapper {

    public BeerDto toDto(Beer beer) {
        if (beer == null) {
            return null;
        }

        return BeerDto.builder()
                .id(beer.getId())
                .version(beer.getVersion() != null ? beer.getVersion().toString() : null)
                .beerStyle(parseStyle(beer.getBeerStyle()))
                .beerName(beer.getBeerName())
                .upc(beer.getUpc())
                .createdDate(toOffsetDateTime(beer.getCreatedDate()))
                .lastModifiedDate(toOffsetDateTime(beer.getLastModifiedDate()))
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityToBrew())
                .build();
    }

    public Beer toEntity(BeerDto dto) {
        if (dto == null) {
            return null;
        }

        return Beer.builder()
                .id(dto.getId())
                .version(parseVersion(dto.getVersion()))
                .beerStyle(dto.getBeerStyle() != null ? dto.getBeerStyle().name() : null)
                .beerName(dto.getBeerName())
                .upc(dto.getUpc() != null ? dto.getUpc().toString() : null)
                .createdDate(toTimestamp(dto.getCreatedDate()))
                .lastModifiedDate(toTimestamp(dto.getLastModifiedDate()))
                .price(dto.getPrice())
                .quantityToBrew(dto.getQuantityOnHand())
                .build();
    }

    private OffsetDateTime toOffsetDateTime(Timestamp ts) {
        return ts == null ? null : ts.toInstant().atOffset(ZoneOffset.UTC);
    }

    private Timestamp toTimestamp(OffsetDateTime odt) {
        return odt == null ? null : Timestamp.from(odt.toInstant());
    }

    private Long parseUpc(String upc) {
        try {
            return upc != null ? Long.parseLong(upc) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String parseUpc(Long upc) {
        return upc != null ? upc.toString() : null;
    }

    private Long parseVersion(String version) {
        try {
            return version != null ? Long.parseLong(version) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private @NotNull BeerStyleEnum parseStyle(String beerStyle) {
        if (beerStyle == null) return null;
        try {
            return BeerStyleEnum.valueOf(beerStyle.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
