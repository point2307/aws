package com.recipe.persistence;

import com.recipe.dto.Funding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface FundingRepo extends CrudRepository<Funding, Long>, QuerydslPredicateExecutor<Funding> {

    @Query("select f from Funding f")
    public Page<Funding> getFundingList(Pageable pageable);
}