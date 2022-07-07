package com.nttdata.account.model.integration.customer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@AllArgsConstructor
public class HoldersEnterprise {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
}
