package com.letscode.bankaccount.dto;

import com.letscode.bankaccount.enums.AccountType;
import com.letscode.bankaccount.model.Account;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {

    private Long id;
    private String number;
    private String agency;
    private AccountType accountType;
    private BigDecimal balance;

    public AccountResponse(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.agency = account.getAgency();
        this.accountType = account.getAccountType();
        this.balance = account.getBalance();
    }
}
