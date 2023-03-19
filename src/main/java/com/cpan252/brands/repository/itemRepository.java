package com.cpan252.brands.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cpan252.brands.model.item;
import com.cpan252.brands.model.item.Brand;

public interface itemRepository extends CrudRepository<item, Long> {
    List<item> findByBrandFrom(Brand brand);

    List<item> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);
}