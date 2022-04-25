package com.letscode.bankaccount.service;

import com.letscode.bankaccount.dto.AccountRequest;
import com.letscode.bankaccount.dto.AccountResponse;

public interface AccountService {

    AccountResponse create(AccountRequest accountRequest, Long id);

    AccountResponse findById(Long id);
}
