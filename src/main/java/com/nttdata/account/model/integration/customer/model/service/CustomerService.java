package com.nttdata.account.model.integration.customer.model.service;

import com.nttdata.account.model.integration.customer.model.entity.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer> getCustomerMono(long idCustomer);
}
