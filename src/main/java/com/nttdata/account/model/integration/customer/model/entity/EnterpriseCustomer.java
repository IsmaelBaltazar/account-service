package com.nttdata.account.model.integration.customer.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class EnterpriseCustomer{
    private String businessName;
    private String ruc;
    private List<HoldersEnterprise> holders;
}
