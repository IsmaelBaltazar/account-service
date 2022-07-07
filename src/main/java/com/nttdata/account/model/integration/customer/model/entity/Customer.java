package com.nttdata.account.model.integration.customer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private long idCustomer;
    private String city;
    private Boolean deleteState;
    private String address;
    private String type;//personal or enterprise
    private EnterpriseCustomer enterpriseCustomer;
    private PersonalCustomer personalCustomer;

}

