package com.cpan252.brands.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@Table
public class item {
    @Id
    private Long id;
    @NotBlank
    private String name;
    @Min(1000)
    private int price;
    @Min(2021)
    private int yearcreated;
    private Brand brandFrom;

    public enum Brand {
        Balenciaga("Balenciaga"), StoneIsland("Stone Island"), Dior("Dior"), Gucci("Gucci");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}