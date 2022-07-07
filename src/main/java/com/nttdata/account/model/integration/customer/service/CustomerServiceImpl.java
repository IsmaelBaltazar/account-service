package com.nttdata.account.model.integration.customer.service;

import com.nttdata.account.model.integration.customer.model.entity.Customer;
import com.nttdata.account.model.integration.customer.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private WebClient.Builder webClient;
    @Override
    public Mono<Customer> getCustomerMono(long idCustomer) {
        String uriCustomer = "/api/customer/{idCustomer}";
        return webClient.build().get()
                .uri(uriCustomer, idCustomer)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
