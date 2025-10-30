package com.cpro.accounts.mongo.infrastructure.persistence.repository;

import com.cpro.accounts.mongo.infrastructure.persistence.document.AccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpringDataAccountRepository extends MongoRepository<AccountDocument, String> {

    Optional<AccountDocument> findByName();

    @Query(value = "{'ownerIdentification': ?0}", sort = "{'id': 1}")
    List<AccountDocument> findByOwner(String identification);
}
