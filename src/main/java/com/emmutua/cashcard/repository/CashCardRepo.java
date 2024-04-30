package com.emmutua.cashcard.repository;

import com.emmutua.cashcard.entity.CashCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashCardRepo extends MongoRepository<CashCard, ObjectId> {
}
