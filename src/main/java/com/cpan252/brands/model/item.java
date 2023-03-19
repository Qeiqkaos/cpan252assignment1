package com.cpan252.brands.model;
import java.time.LocalDate;
import lombok.Builder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Min(1000)
    private int price;
    @Min(2021)
    private int yearcreated;
    private Brand brandFrom;
    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

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