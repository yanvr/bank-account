package com.letscode.bankaccount.model;

import com.letscode.bankaccount.dto.AccountRequest;
import com.letscode.bankaccount.enums.AccountType;
import com.letscode.bankaccount.utils.GenerateAccountNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private Long userId;

    public Account(AccountRequest accountRequest) {
        this.number = GenerateAccountNumber.execute();
        this.agency = accountRequest.getAgency();
        this.accountType = accountRequest.getAccountType();
        this.balance = accountRequest.getBalance();
    }
}
