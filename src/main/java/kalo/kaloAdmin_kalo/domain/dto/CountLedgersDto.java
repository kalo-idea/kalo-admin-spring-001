package kalo.kaloAdmin_kalo.domain.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountLedgersDto {
    
    private Long point;


    @QueryProjection
    @Builder
    public CountLedgersDto(Long point) {
        this.point = point;
    }
}
