package com.cpan252.brands.repository;

import org.springframework.data.repository.CrudRepository;
import com.cpan252.brands.model.item;

public interface itemRepository extends CrudRepository<item, Long> {
}