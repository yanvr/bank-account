package com.letscode.bankaccount.dto;

import com.letscode.bankaccount.enums.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {

    private String agency;
    private AccountType accountType;
    private BigDecimal balance;
}
