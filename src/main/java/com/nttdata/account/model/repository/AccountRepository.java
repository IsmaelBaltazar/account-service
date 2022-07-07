package com.nttdata.account.model.repository;

import com.nttdata.account.model.document.Account;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account,Long> {
    @Query(value = "{ 'idCustomer': ?0 }")
    public Flux<Account> findByIdCustomer(Long idCustomer);
}
