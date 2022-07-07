package com.nttdata.account.service;

import com.nttdata.account.model.document.Account;
import com.nttdata.account.model.integration.customer.model.service.CustomerService;
import com.nttdata.account.model.repository.AccountRepository;
import com.nttdata.account.model.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
    Logger log  = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AccountRepository repository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    CustomerService customerService;
    @Override
    public Flux<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Account> save(Account account) {
        return customerService.getCustomerMono(account.getIdCustomer())
                .flatMap(c->{
                    if (c.getType().equalsIgnoreCase("Personal")){//Personal Account
                        return repository.findAll()
                                .filter(ac->ac.getIdCustomer()==account.getIdCustomer())
                                .defaultIfEmpty(new Account())
                                .next()
                                .flatMap(ac->{
                                    if (ac.getIdProduct()==1||ac.getIdProduct()==4){ // If credit or save product
                                        return Mono.just(new Account());
                                    }
                                    account.setIdAccount(sequenceGeneratorService.getSequenceNumber(Account.SEQUENCE_NAME));
                                    return repository.save(account);
                                });
                    }
                    //Enterprise Account
                    if (account.getIdProduct()==1){//Can't have save accout
                        return Mono.just(new Account());
                    }
                    account.setIdAccount(sequenceGeneratorService.getSequenceNumber(Account.SEQUENCE_NAME));
                    return repository.save(account);
                });
    }

    @Override
    public Mono<Account> update(Account account) {
        return repository.findById(account.getIdAccount()).flatMap(a-> this.repository.save(account));
    }
    @Override
    public Mono<Account> findById(Long idAccount) {
        return repository.findById(idAccount);
    }

    @Override
    public Flux<Account> findByIdCustomer(Long idCustomer) {
        return repository.findByIdCustomer(idCustomer);
    }


}
