package com.nttdata.account.model.document;

import com.mongodb.lang.Nullable;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
    @Transient
    public static final String SEQUENCE_NAME = "account_sequence";
    @Id
    private long idAccount;
    @NotNull
    private long idCustomer;
    @NotNull
    private long idProduct;
    @Nullable
    private String number;//Only for products accounts
    @NotNull
    private Float amount;
    @Nullable
    private int limit;//Only for Ahorro
    @Nullable
    private String dateMovement;//Only for Plazo Fijo
}
