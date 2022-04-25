package com.letscode.bankaccount.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AccountType {
    POUPANCA("poupança"), CORRENTE("corrente"), SALARIO("salário");

    private String type;
}
