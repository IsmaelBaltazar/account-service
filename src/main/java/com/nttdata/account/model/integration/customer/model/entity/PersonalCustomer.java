package com.nttdata.account.model.integration.customer.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class PersonalCustomer {
    private String name;
    private String lastname;
    private String dni;
}
