package com.cpan252.brands.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.cpan252.brands.model.item;
public interface itemRepositoryPaginated extends PagingAndSortingRepository<item, Long> {
}