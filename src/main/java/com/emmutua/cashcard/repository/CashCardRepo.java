package com.emmutua.cashcard.repository;

import com.emmutua.cashcard.entity.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashCardRepo extends JpaRepository<CashCard, Long> {
}
