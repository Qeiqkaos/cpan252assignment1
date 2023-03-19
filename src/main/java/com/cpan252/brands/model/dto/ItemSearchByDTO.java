package com.cpan252.brands.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ItemSearchByDTO {
    private String name;
    private String startDate;
    private String endDate;
}